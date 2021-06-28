package mk.bp.project.bplab.repository;

import mk.bp.project.bplab.model.Produkt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProduktRepository extends JpaRepository<Produkt, Integer> {
}
