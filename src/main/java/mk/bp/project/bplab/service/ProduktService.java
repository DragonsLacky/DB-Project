package mk.bp.project.bplab.service;

import mk.bp.project.bplab.model.Produkt;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Optional;

public interface ProduktService {
    Optional<Produkt> findById(Integer id);
    void saveProdukt(String ime,String proizvoditel, Integer kolicina, BigDecimal tezina, BigDecimal cena) throws SQLException;
    void changeCena(Integer id, BigDecimal cena) throws SQLException;
}
