package mk.bp.project.bplab.service.Implementation;

import mk.bp.project.bplab.model.Embedable.ProduktMagacinId;
import mk.bp.project.bplab.model.Grad;
import mk.bp.project.bplab.model.Magacin;
import mk.bp.project.bplab.model.ProduktSeNaogjaVoMagacin;
import mk.bp.project.bplab.repository.ProduktRepository;
import mk.bp.project.bplab.repository.ProduktiVoMagacinRepository;
import mk.bp.project.bplab.repository.SingleMagacinRepository;
import mk.bp.project.bplab.service.MagacinService;
import mk.bp.project.bplab.service.ProduktMagacinService;
import mk.bp.project.bplab.service.SingleMagacinService;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.Optional;

@Service
public class SingleMagacinServiceImplementation implements SingleMagacinService {
    private final SingleMagacinRepository repository;
    private final MagacinService magacinService;
    private final ProduktRepository produktRepository;
    private final ProduktiVoMagacinRepository produktiVoMagacinRepository;
    private final ProduktMagacinService produktMagacinService;
    
    public SingleMagacinServiceImplementation(SingleMagacinRepository repository, MagacinService magacinService, ProduktRepository produktRepository, ProduktiVoMagacinRepository produktiVoMagacinRepository, ProduktMagacinService produktMagacinService) {
        this.repository = repository;
        this.magacinService = magacinService;
        this.produktRepository = produktRepository;
        this.produktiVoMagacinRepository = produktiVoMagacinRepository;
        this.produktMagacinService = produktMagacinService;
    }
    
    @Override
    public Optional<Magacin> findById(Integer id) {
        return repository.findById(id);
    }
    @Override
    public void saveMagacin(String adresa, Grad grad) throws SQLException {
        Magacin magacin = new Magacin(adresa,grad);
        repository.save(magacin);
        produktRepository.findAll().forEach(produkt -> {
            produktiVoMagacinRepository.save(new ProduktSeNaogjaVoMagacin(new ProduktMagacinId(produkt,magacin),"",0));
        });
        produktMagacinService.updateView();
        magacinService.updateView();
    }
}
