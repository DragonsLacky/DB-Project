package mk.bp.project.bplab.service.Implementation;

import mk.bp.project.bplab.model.view.Vozachi;
import mk.bp.project.bplab.repository.VozachiRepository;
import mk.bp.project.bplab.service.VozachiService;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

@Service
public class VozachiServiceImplementation implements VozachiService {
    private final VozachiRepository repository;
    private final DataSource dataSource;
    
    public VozachiServiceImplementation(VozachiRepository repository, DataSource dataSource) {
        this.repository = repository;
        this.dataSource = dataSource;
    }
    
    @Override
    public List<Vozachi> findAll() {
        return repository.findAll();
    }
    
    @Override
    public void updateView() throws SQLException {
        String sql = "create or replace view vozachi as\n" +
                "select EMBG, ime || ' ' || prezime as ime_prezime, broj_dozvola,vazhnost_do\n" +
                "from lab_project.Vozach;";
        
        Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement();
        statement.executeUpdate(sql);
        connection.close();
    }
}
