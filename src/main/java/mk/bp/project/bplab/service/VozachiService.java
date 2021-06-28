package mk.bp.project.bplab.service;

import mk.bp.project.bplab.model.view.Vozachi;

import java.sql.SQLException;
import java.util.List;

public interface VozachiService {
    List<Vozachi> findAll();
    void updateView() throws SQLException;
}
