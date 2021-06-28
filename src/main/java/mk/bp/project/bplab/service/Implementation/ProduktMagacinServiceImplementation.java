package mk.bp.project.bplab.service.Implementation;

import mk.bp.project.bplab.model.ProduktSeNaogjaVoMagacin;
import mk.bp.project.bplab.model.view.MagacinProdukt;
import mk.bp.project.bplab.repository.ProduktMagacinRepository;
import mk.bp.project.bplab.repository.ProduktiVoMagacinRepository;
import mk.bp.project.bplab.service.ProduktMagacinService;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

@Service
public class ProduktMagacinServiceImplementation implements ProduktMagacinService {
    private final ProduktMagacinRepository repository;
    private final ProduktiVoMagacinRepository magacinRepository;
    private final DataSource dataSource;
    public ProduktMagacinServiceImplementation(ProduktMagacinRepository repository, ProduktiVoMagacinRepository magacinRepository, DataSource dataSource) {
        this.repository = repository;
        this.magacinRepository = magacinRepository;
        this.dataSource = dataSource;
    }
    
    @Override
    public List<MagacinProdukt> findAll() {
        return repository.findAll();
    }
    
    @Override
    public List<MagacinProdukt> findByMagacin(Integer id) {
        return repository.findByIdMagacin(id);
    }
    
    @Override
    public void saveProdukt(Integer produkt ,Integer magacin, Integer kolicina) throws SQLException {
        ProduktSeNaogjaVoMagacin pm = magacinRepository.findByProduktMagacinProduktIdAndProduktMagacinMagacinId(produkt,magacin).get();
        pm.setKolicina(kolicina);
        magacinRepository.save(pm);
        updateView();
        System.out.println(pm);
    }
    
    @Override
    public void updateView() throws SQLException {
        String sql = "create or replace view Listanje_produkti_po_magacin as\n" +
                "select M.id_magacin as Id, M.adresa as Adresa, G.ime_grad as Grad, P.ime_produkt as Produkt, p.proizvoditel as Proizvoditel, Psnvm.kolicina as vkupna_kolicina ,Psnvm.kolicina * P.tezina as vkupna_tezina, C.kolicina as Cena_po_produkt, C.kolicina * Psnvm.kolicina as vrednost\n" +
                "from lab_project.Magacin as M\n" +
                "    inner join lab_project.Grad G on G.id_grad = M.id_grad\n" +
                "    inner join lab_project.Produkt_se_naogja_vo_magacin Psnvm on M.id_magacin = Psnvm.id_magacin\n" +
                "    inner join lab_project.Produkt P on P.id_produkt = Psnvm.id_produkt\n" +
                "    inner join lab_project.Cena C on P.id_produkt = C.id_produkt and C.data_do is null\n" +
                "order by vrednost desc";
        
        Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement();
        statement.executeUpdate(sql);
        connection.close();
    }
    
    
}
