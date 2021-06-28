package mk.bp.project.bplab.service.Implementation;

import mk.bp.project.bplab.model.view.Produkti;
import mk.bp.project.bplab.repository.ProduktiRepository;
import mk.bp.project.bplab.service.ProduktiService;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;

@Service
public class ProduktiServiceImplementation implements ProduktiService {
    
    private final ProduktiRepository repository;
    private final DataSource dataSource;
    
    public ProduktiServiceImplementation(ProduktiRepository repository, DataSource dataSource) {
        this.repository = repository;
        this.dataSource = dataSource;
    }
    
    @Override
    public List<Produkti> findAll() {
        return repository.findAll();
    }
    
    @Override
    public Optional<Produkti> findById(Integer id) {
        return repository.findById(id);
    }
    
    @Override
    public void updateView() throws SQLException {
        String sql = "create or replace view produkti as\n" +
                "select Produkt.id_produkt as id, ime_produkt as ime, Produkt.kolicina as kolicina, tezina, C.kolicina cena, C.kolicina * Produkt.kolicina as Vkupna_vrednost, tezina * Produkt.kolicina as Vkupna_tezina, Produkt.proizvoditel as proizvoditel\n" +
                "from lab_project.Produkt\n" +
                "inner join lab_project.Cena C on Produkt.id_produkt = C.id_produkt\n" +
                "where C.data_do is null\n" +
                "order by Vkupna_vrednost desc";
        
        Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement();
        statement.executeUpdate(sql);
        connection.close();
    }
}
