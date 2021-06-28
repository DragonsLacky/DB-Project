package mk.bp.project.bplab.service;

import mk.bp.project.bplab.model.view.IzvrsheniNarachki;

import java.sql.SQLException;
import java.util.List;

public interface IzvrsheniNarachkiService {
    List<IzvrsheniNarachki> findAll();
    List<IzvrsheniNarachki> findNeizvrsheni();
    List<IzvrsheniNarachki> findIzvrsheni();
}
