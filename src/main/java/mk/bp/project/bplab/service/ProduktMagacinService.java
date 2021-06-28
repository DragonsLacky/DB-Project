package mk.bp.project.bplab.service;

import mk.bp.project.bplab.model.view.MagacinProdukt;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

public interface ProduktMagacinService {
    List<MagacinProdukt> findAll();
    List<MagacinProdukt> findByMagacin(Integer id);
    void saveProdukt(Integer produkt, Integer magacin, Integer kolicina) throws SQLException;
    void updateView() throws SQLException;
}
