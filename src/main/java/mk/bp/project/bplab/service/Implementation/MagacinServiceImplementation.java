package mk.bp.project.bplab.service.Implementation;

import mk.bp.project.bplab.model.view.Magacini;
import mk.bp.project.bplab.repository.MagacinRepository;
import mk.bp.project.bplab.service.MagacinService;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

@Service
public class MagacinServiceImplementation implements MagacinService {
    private final MagacinRepository repository;
    private final DataSource dataSource;
    
    public MagacinServiceImplementation(MagacinRepository repository, DataSource dataSource) {
        this.repository = repository;
        this.dataSource = dataSource;
    }
    
    @Override
    public List<Magacini> findAll() {
        return repository.findAll();
    }
    
    @Override
    public void updateView() throws SQLException {
        String sql = "create or replace view lab_project.magacini as\n" +
                "select id_magacin as magacin, adresa, ime_grad as grad\n" +
                "from lab_project.magacin\n" +
                "inner join lab_project.grad g on g.id_grad = magacin.id_grad";
        
        Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement();
        statement.executeUpdate(sql);
        connection.close();
    }
}
