package mk.bp.project.bplab.service.Implementation;

import mk.bp.project.bplab.model.Grad;
import mk.bp.project.bplab.repository.GradRepository;
import mk.bp.project.bplab.service.GradService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GradServiceImplementation implements GradService {
    private final GradRepository repository;
    
    public GradServiceImplementation(GradRepository repository) {
        this.repository = repository;
    }
    
    @Override
    public List<Grad> findAll() {
        return repository.findAll();
    }
    
    @Override
    public Optional<Grad> findById(Integer id) {
        return repository.findById(id);
    }
}
