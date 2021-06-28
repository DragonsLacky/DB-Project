package mk.bp.project.bplab.service.Implementation;

import mk.bp.project.bplab.model.Cena;
import mk.bp.project.bplab.model.Embedable.CenaId;
import mk.bp.project.bplab.model.Embedable.ProduktMagacinId;
import mk.bp.project.bplab.model.Produkt;
import mk.bp.project.bplab.model.ProduktSeNaogjaVoMagacin;
import mk.bp.project.bplab.repository.*;
import mk.bp.project.bplab.service.ProduktMagacinService;
import mk.bp.project.bplab.service.ProduktService;
import mk.bp.project.bplab.service.ProduktiService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ProduktServiceImplementation implements ProduktService {
    private final ProduktRepository repository;
    private final CenaRepository cenaRepository;
    private final ProduktiService service;
    private final ProduktMagacinService magacinService;
    private final ProduktiVoMagacinRepository produktiVoMagacinRepository;
    private final SingleMagacinRepository magacinRepository;
    
    public ProduktServiceImplementation(ProduktRepository repository, CenaRepository cenaRepository, ProduktiService service, ProduktMagacinService magacinService, ProduktiVoMagacinRepository produktiVoMagacinRepository, SingleMagacinRepository magacinRepository) {
        this.repository = repository;
        this.cenaRepository = cenaRepository;
        this.service = service;
        this.magacinService = magacinService;
        this.produktiVoMagacinRepository = produktiVoMagacinRepository;
        this.magacinRepository = magacinRepository;
    }
    
    @Override
    public Optional<Produkt> findById(Integer id) {
        return repository.findById(id);
    }
    
    @Override
    public void saveProdukt(String ime, String proizvoditel,Integer kolicina, BigDecimal tezina, BigDecimal cena) throws SQLException {
        Produkt produkt = new Produkt(ime, kolicina, tezina, proizvoditel);
        repository.save(produkt);
        cenaRepository.save(new Cena(new CenaId(produkt, ZonedDateTime.now()),cena));
        magacinRepository.findAll().forEach(magacin ->{
            produktiVoMagacinRepository.save(new ProduktSeNaogjaVoMagacin(new ProduktMagacinId(produkt, magacin),"",0));
        });
        service.updateView();
        magacinService.updateView();
    }
    
    @Override
    public void changeCena(Integer id, BigDecimal cena) throws SQLException {
        Cena c = cenaRepository.findByIdProduktIdAndDataDo(id,null);
        Produkt produkt = repository.findById(id).get();
        c.setDataDo(ZonedDateTime.now());
        cenaRepository.save(c);
        cenaRepository.save(new Cena(new CenaId(produkt,ZonedDateTime.now()),cena));
        service.updateView();
        magacinService.updateView();
    }
}
