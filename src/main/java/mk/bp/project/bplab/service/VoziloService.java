package mk.bp.project.bplab.service;

import mk.bp.project.bplab.model.Vozach;
import mk.bp.project.bplab.model.Vozilo;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public interface VoziloService {
    List<Vozilo> findAll();
    List<Vozilo> findById(Vozach vozach);
    void saveVozilo(String embg, String registracija, String model, String sostojba, BigDecimal kapacitet, Date servis);
}
