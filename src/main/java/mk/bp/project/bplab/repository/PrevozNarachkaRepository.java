package mk.bp.project.bplab.repository;

import mk.bp.project.bplab.model.Embedable.PrevozNarachkaId;
import mk.bp.project.bplab.model.PrevozNarachka;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrevozNarachkaRepository extends JpaRepository<PrevozNarachka, PrevozNarachkaId> {

}
