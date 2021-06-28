package mk.bp.project.bplab.service.Implementation;

import mk.bp.project.bplab.model.*;
import mk.bp.project.bplab.model.Embedable.NarachkaProduktId;
import mk.bp.project.bplab.model.Embedable.PrevozNarachkaId;
import mk.bp.project.bplab.repository.*;
import mk.bp.project.bplab.service.MagacinService;
import mk.bp.project.bplab.service.NarachaniProduktiService;
import mk.bp.project.bplab.service.NeizvrsheniNarachkiService;
import mk.bp.project.bplab.service.ProduktMagacinService;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Repository
public class NeizvrsheniNarachkiServiceImplementation implements NeizvrsheniNarachkiService {
    private final NeizvrsheniNarachkiRepository repository;
    private final ProduktRepository produktRepository;
    private final PrevozNarachkaRepository prevozNarachkaRepository;
    private final NarachkaProduktRepository narachkaProduktRepository;
    private final ProduktiVoMagacinRepository produktiVoMagacinRepository;
    private final VozachRepository vozachRepository;
    private final VoziloRepository voziloRepository;
    private final NarachaniProduktiService narachaniProduktiService;
    private final ProduktMagacinService produktMagacinService;
    private final SingleMagacinRepository sMagacinRepository;
    private final DataSource dataSource;
    
    public NeizvrsheniNarachkiServiceImplementation(NeizvrsheniNarachkiRepository repository, ProduktRepository produktRepository, PrevozNarachkaRepository prevozNarachkaRepository, NarachkaProduktRepository narachkaProduktRepository, ProduktiVoMagacinRepository produktiVoMagacinRepository, VozachRepository vozachRepository, VoziloRepository voziloRepository, NarachaniProduktiService narachaniProduktiService, ProduktMagacinService produktMagacinService, SingleMagacinRepository sMagacinRepository, DataSource dataSource) {
        this.repository = repository;
        this.produktRepository = produktRepository;
        this.prevozNarachkaRepository = prevozNarachkaRepository;
        this.narachkaProduktRepository = narachkaProduktRepository;
        this.produktiVoMagacinRepository = produktiVoMagacinRepository;
        this.vozachRepository = vozachRepository;
        this.voziloRepository = voziloRepository;
        this.narachaniProduktiService = narachaniProduktiService;
        this.produktMagacinService = produktMagacinService;
        this.sMagacinRepository = sMagacinRepository;
        this.dataSource = dataSource;
    }
    
    @Override
    public void izvrshiNarachka(Integer id, String vozach, String vozilo) throws SQLException {
        Narachka narachka = repository.findById(id).get();
        narachka.setSostojba("DOSTAVENA");
        prevozNarachkaRepository.save(new PrevozNarachka(new PrevozNarachkaId(narachka, vozachRepository.findById(vozach).get(), voziloRepository.findById(vozilo).get()), ZonedDateTime.now()));
        if(sMagacinRepository.findById(narachka.getMagacinIzvoz().getId()).isPresent() && sMagacinRepository.findById(narachka.getMagacinUvoz().getId()).isPresent()){
            Magacin izvoz = sMagacinRepository.findById(narachka.getMagacinIzvoz().getId()).get();
            Magacin uvoz = sMagacinRepository.findById(narachka.getMagacinUvoz().getId()).get();
            List<NarachkaSeSostoiOdProdukt> produkti = narachkaProduktRepository.findAll().stream().filter(narachkaSeSostoiOdProdukt -> narachkaSeSostoiOdProdukt.getId().getNarachka().getId().equals(narachka.getId())).collect(Collectors.toList());
            produkti.forEach(produkt -> {
                List<ProduktSeNaogjaVoMagacin> produktSeNaogjaVoMagacin = produktiVoMagacinRepository.findAllByProduktMagacinProduktId(produkt.getId().getProdukt().getId()).stream().filter(produkt1 -> produkt1.getProduktMagacin().getMagacin().getId().equals(izvoz.getId())).collect(Collectors.toList());
                for (ProduktSeNaogjaVoMagacin seNaogjaVoMagacin : produktSeNaogjaVoMagacin) {
//                    if(seNaogjaVoMagacin.getKolicina() - produkt.getKolicina() < 0){
//                        throw new IllegalArgumentException();
//                    }else{}
                        seNaogjaVoMagacin.setKolicina(seNaogjaVoMagacin.getKolicina() - produkt.getKolicina());

                    produktiVoMagacinRepository.save(seNaogjaVoMagacin);
                }
                produktSeNaogjaVoMagacin = produktiVoMagacinRepository.findAllByProduktMagacinProduktId(produkt.getId().getProdukt().getId()).stream().filter(produkt1 -> produkt1.getProduktMagacin().getMagacin().getId().equals(uvoz.getId())).collect(Collectors.toList());
                for (ProduktSeNaogjaVoMagacin seNaogjaVoMagacin : produktSeNaogjaVoMagacin) {
                    seNaogjaVoMagacin.setKolicina(seNaogjaVoMagacin.getKolicina() + produkt.getKolicina());
                    produktiVoMagacinRepository.save(seNaogjaVoMagacin);
                }
            });
        }
        produktMagacinService.updateView();
        updateView();
    }
    
    @Override
    public void updateView() throws SQLException {
        String sql = "create or replace view narachki as\n" +
                "select lab_project.narachka.id_narachka as Narachka, M.id_magacin as magacin_izvoz, M.adresa as adresa_i, G.ime_grad as grad_i, M2.id_magacin as magacin_uvoz, M2.adresa as adresa_u, G2.ime_grad as grad_u,v.EMBG as vozach ,V.ime || ' ' || V.prezime as ime_prezime, dostava_do as dostava_do, dostaveno_na as dostavena_na, narachka.sostojba\n" +
                "from lab_project.narachka\n" +
                "    inner join lab_project.Magacin M on M.id_magacin = Narachka.id_magacin_izvoz\n" +
                "    inner join lab_project.Grad G on G.id_grad = M.id_grad\n" +
                "    inner join lab_project.Magacin M2 on M2.id_magacin = Narachka.id_magacin_uvoz\n" +
                "    inner join lab_project.Grad G2 on G2.id_grad = M2.id_grad\n" +
                "    left join lab_project.Prevoz_narachka Pn on Narachka.id_narachka = Pn.id_narachka\n" +
                "    left join lab_project.Vozach V on Pn.EMBG_vozach = V.EMBG;";
        Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement();
        statement.executeUpdate(sql);
        connection.close();
    }
    
    @Override
    public void narachaj(LocalDateTime dateTime, Magacin izvoz, Magacin uvoz, String sostojba, Integer[] produkt, Integer[] kolicina) throws SQLException {
        Narachka narachka = new Narachka(dateTime.atZone(ZoneId.of("Europe/Skopje")),izvoz,uvoz, sostojba);
        repository.save(narachka);
        AtomicInteger integer = new AtomicInteger();
        List<Optional<Produkt>> produkti = Arrays.stream(produkt).sequential().map(produktRepository::findById).collect(Collectors.toList());
        Arrays.stream(produkt).sequential().map(produktRepository::findById).forEach(produkt1 -> {
            narachkaProduktRepository.save(new NarachkaSeSostoiOdProdukt(new NarachkaProduktId(narachka,produkt1.get()),kolicina[integer.getAndIncrement()]));
        });
        narachaniProduktiService.updateView();
        updateView();
    }
}
