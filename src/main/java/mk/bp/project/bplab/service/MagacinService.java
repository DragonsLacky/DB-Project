package mk.bp.project.bplab.service;

import mk.bp.project.bplab.model.view.Magacini;

import java.sql.SQLException;
import java.util.List;

public interface MagacinService {
    List<Magacini> findAll();
    void updateView() throws SQLException;
}
