package mk.bp.project.bplab.service;

import mk.bp.project.bplab.model.Grad;
import mk.bp.project.bplab.model.Magacin;

import java.sql.SQLException;
import java.util.Optional;

public interface SingleMagacinService {
    Optional<Magacin> findById(Integer id);
    void saveMagacin(String adresa, Grad grad) throws SQLException;
}
