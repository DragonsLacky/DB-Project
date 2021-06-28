package mk.bp.project.bplab.service;


import mk.bp.project.bplab.model.Magacin;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;

public interface NeizvrsheniNarachkiService {
    void narachaj(LocalDateTime dateTime, Magacin izvoz, Magacin uvoz, String sostojba,Integer[] produkt, Integer[] kolicina) throws SQLException;
    void izvrshiNarachka(Integer id,String vozach, String vozilo) throws SQLException;
    void updateView() throws SQLException;
}
