package mk.bp.project.bplab.repository;

import mk.bp.project.bplab.model.view.Magacini;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MagacinRepository extends JpaRepository<Magacini, Integer> {
    
}
