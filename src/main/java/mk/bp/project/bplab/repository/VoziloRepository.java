package mk.bp.project.bplab.repository;

import mk.bp.project.bplab.model.Vozach;
import mk.bp.project.bplab.model.Vozilo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VoziloRepository extends JpaRepository<Vozilo, String> {
    List<Vozilo> findByVozach(Vozach vozach);
}
