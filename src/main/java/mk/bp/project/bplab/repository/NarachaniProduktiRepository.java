package mk.bp.project.bplab.repository;

import mk.bp.project.bplab.model.view.NarachaniProdukti;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NarachaniProduktiRepository extends JpaRepository<NarachaniProdukti, Integer> {
    List<NarachaniProdukti> findByNarachka(Integer id);
}
