package mk.bp.project.bplab.service.Implementation;

import mk.bp.project.bplab.model.view.IzvrsheniNarachki;
import mk.bp.project.bplab.repository.NarachkiIzvrsheniRepository;
import mk.bp.project.bplab.service.IzvrsheniNarachkiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

@Service
public class IzvrsheniNarachkiServiceImplementation implements IzvrsheniNarachkiService {
    @Autowired
    private final NarachkiIzvrsheniRepository repository;
    
    public IzvrsheniNarachkiServiceImplementation(NarachkiIzvrsheniRepository repository) {
        this.repository = repository;
    }
    
    @Override
    public List<IzvrsheniNarachki> findAll() {
        return repository.findAll();
    }
    
    @Override
    public List<IzvrsheniNarachki> findNeizvrsheni() {
        return repository.findBySostojba("NEDOSTAVENA");
    }
    
    @Override
    public List<IzvrsheniNarachki> findIzvrsheni() {
        return repository.findBySostojba("DOSTAVENA");
    }
    

}
