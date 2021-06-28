package mk.bp.project.bplab.service;

import mk.bp.project.bplab.model.view.Produkti;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface ProduktiService {
    List<Produkti> findAll();
    Optional<Produkti> findById(Integer id);
    void updateView() throws SQLException;
}
