package mk.bp.project.bplab.service.Implementation;

import mk.bp.project.bplab.model.Vozach;
import mk.bp.project.bplab.model.Vozilo;
import mk.bp.project.bplab.repository.VozachRepository;
import mk.bp.project.bplab.repository.VoziloRepository;
import mk.bp.project.bplab.service.VoziloService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;

@Service
public class VoziloServiceImplementation implements VoziloService {
    private final VoziloRepository repository;
    private final VozachRepository vozachRepository;
    
    public VoziloServiceImplementation(VoziloRepository repository, VozachRepository vozachRepository) {
        this.repository = repository;
        this.vozachRepository = vozachRepository;
    }
    
    @Override
    public List<Vozilo> findAll() {
        return repository.findAll();
    }
    
    @Override
    public List<Vozilo> findById(Vozach vozach) {
        return repository.findByVozach(vozach);
    }
    
    @Override
    public void saveVozilo(String embg, String registracija, String model, String sostojba, BigDecimal kapacitet, Date servis) {
        repository.save(new Vozilo(registracija,model,sostojba, ZonedDateTime.ofInstant(servis.toInstant(), ZoneId.systemDefault()),kapacitet, vozachRepository.findById(embg).get() ));
    }
    
    
}
