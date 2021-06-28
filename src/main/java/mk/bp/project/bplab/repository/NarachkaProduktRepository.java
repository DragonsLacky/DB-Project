package mk.bp.project.bplab.repository;

import mk.bp.project.bplab.model.Embedable.NarachkaProduktId;
import mk.bp.project.bplab.model.NarachkaSeSostoiOdProdukt;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NarachkaProduktRepository extends JpaRepository<NarachkaSeSostoiOdProdukt, NarachkaProduktId> {

}
