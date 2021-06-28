package mk.bp.project.bplab.repository;

import mk.bp.project.bplab.model.Embedable.ProduktMagacinId;
import mk.bp.project.bplab.model.Magacin;
import mk.bp.project.bplab.model.Produkt;
import mk.bp.project.bplab.model.ProduktSeNaogjaVoMagacin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProduktiVoMagacinRepository extends JpaRepository<ProduktSeNaogjaVoMagacin, ProduktMagacinId> {
    List<ProduktSeNaogjaVoMagacin> findAllByProduktMagacinProduktId(Integer produkt);
    Optional<ProduktSeNaogjaVoMagacin> findByProduktMagacinProduktIdAndProduktMagacinMagacinId(Integer produkt, Integer magacin);
}
