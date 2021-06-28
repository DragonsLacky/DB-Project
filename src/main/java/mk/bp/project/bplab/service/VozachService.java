package mk.bp.project.bplab.service;

import mk.bp.project.bplab.model.Vozach;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface VozachService {
    List<Vozach> findAll();
    Optional<Vozach> findById(String id);
    void saveVozach(String ime, String prezime, String embg,String dozvola, Date vazhnost) throws SQLException;
}
