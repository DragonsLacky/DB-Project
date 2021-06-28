package mk.bp.project.bplab.service.Implementation;

import mk.bp.project.bplab.model.view.NarachaniProdukti;
import mk.bp.project.bplab.repository.NarachaniProduktiRepository;
import mk.bp.project.bplab.service.NarachaniProduktiService;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ConnectionBuilder;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Service
public class NarachaniProduktiServiceImplementation implements NarachaniProduktiService {
    private final NarachaniProduktiRepository repository;
    private final DataSource dataSource;
    
    public NarachaniProduktiServiceImplementation(NarachaniProduktiRepository repository, DataSource dataSource) {
        this.repository = repository;
        this.dataSource = dataSource;
    }
    
    @Override
    public List<NarachaniProdukti> findAll() {
        return repository.findAll();
    }
    
    @Override
    public List<NarachaniProdukti> findByNarachka(Integer id) {
        return repository.findByNarachka(id);
    }
    
    @Override
    public Optional<NarachaniProdukti> findById(Integer id) {
        return repository.findById(id);
    }
    
    @Override
    public void updateView() throws SQLException {
        String sql =
                "create or replace view narachani_produkti as\n" +
                        "select  P.id_produkt as produkt, ime_produkt as Naziv, tezina as tezina_po_eden, c.kolicina as cena, tezina * Nssop.kolicina as Vkupna_tezina, c.kolicina * Nssop.kolicina as Vkupna_cena, Nssop.id_narachka as narachka, proizvoditel, Nssop.kolicina\n" +
                        "from lab_project.Produkt as P\n" +
                        "inner join lab_project.Narachka_se_sostoi_od_produkt Nssop on P.id_produkt = Nssop.id_produkt\n" +
                        "inner join lab_project.Cena C on P.id_produkt = C.id_produkt\n" +
                        "inner join lab_project.Narachka N on N.id_narachka = Nssop.id_narachka\n" +
                        "where data_od= (\n" +
                        "    select min(data_od) as minimal\n" +
                        "        from lab_project.Cena\n" +
                        "        inner join lab_project.produkt P1 on P1.id_produkt = Cena.id_produkt\n" +
                        "        inner join lab_project.Narachka_se_sostoi_od_produkt Nssop2 on P.id_produkt = Nssop2.id_produkt\n" +
                        "        inner join lab_project.Narachka N2 on N2.id_narachka = Nssop2.id_narachka\n" +
                        "        left join lab_project.prevoz_narachka pn on N2.id_narachka = pn.id_narachka\n" +
                        "        where N2.id_narachka = N.id_narachka and P1.id_produkt = P.id_produkt and ((pn.dostaveno_na > data_od and pn.dostaveno_na < data_do) or (N2.dostava_do > data_od and N2.dostava_do < data_do) or ((N2.dostava_do < data_od or N2.dostava_do > data_do) and N2.dostava_do > data_od) or (data_do is null))\n" +
                        "        group by N2.id_narachka, P1.id_produkt\n" +
                        "    )";
    
        Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement();
        statement.executeUpdate(sql);
        connection.close();
    }
}
