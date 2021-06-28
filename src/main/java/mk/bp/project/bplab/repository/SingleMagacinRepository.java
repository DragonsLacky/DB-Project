package mk.bp.project.bplab.repository;

import mk.bp.project.bplab.model.Magacin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SingleMagacinRepository extends JpaRepository<Magacin, Integer> {

}
