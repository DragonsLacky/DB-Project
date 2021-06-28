package mk.bp.project.bplab.service.Implementation;

import mk.bp.project.bplab.model.Vozach;
import mk.bp.project.bplab.repository.VozachRepository;
import mk.bp.project.bplab.service.VozachService;
import mk.bp.project.bplab.service.VozachiService;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class VozachServiceImplementation implements VozachService {
    private final VozachRepository repository;
    private final VozachiService service;
    
    public VozachServiceImplementation(VozachRepository repository, VozachiService service) {
        this.repository = repository;
        this.service = service;
    }
    
    @Override
    public List<Vozach> findAll() {
        return repository.findAll();
    }
    
    @Override
    public Optional<Vozach> findById(String id) {
        return repository.findById(id);
    }
    
    @Override
    public void saveVozach(String ime, String prezime, String embg, String dozvola, Date vazhnost) throws SQLException {
        repository.save(new Vozach(embg,ime,prezime,dozvola, ZonedDateTime.ofInstant(vazhnost.toInstant(), ZoneId.systemDefault())));
        service.updateView();
    }
}
