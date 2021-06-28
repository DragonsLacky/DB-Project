package mk.bp.project.bplab.repository;

import mk.bp.project.bplab.model.view.Produkti;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProduktiRepository extends JpaRepository<Produkti, Integer> {

}
