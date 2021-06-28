package mk.bp.project.bplab.repository;

import mk.bp.project.bplab.model.Embedable.MagacinProduktId;
import mk.bp.project.bplab.model.Embedable.ProduktMagacinId;
import mk.bp.project.bplab.model.ProduktSeNaogjaVoMagacin;
import mk.bp.project.bplab.model.view.MagacinProdukt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProduktMagacinRepository extends JpaRepository<MagacinProdukt, MagacinProduktId> {
    List<MagacinProdukt> findByIdMagacin(Integer id);
}
