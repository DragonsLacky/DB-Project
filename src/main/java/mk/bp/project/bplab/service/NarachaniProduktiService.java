package mk.bp.project.bplab.service;

import mk.bp.project.bplab.model.view.NarachaniProdukti;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface NarachaniProduktiService {
    List<NarachaniProdukti> findAll();
    List<NarachaniProdukti> findByNarachka(Integer id);
    Optional<NarachaniProdukti> findById(Integer id);
    void updateView() throws SQLException;
}
