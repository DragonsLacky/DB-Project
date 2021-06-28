package mk.bp.project.bplab.model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.ZonedDateTime;

@Data
@Entity
@Table(schema = "lab_project", name = "vozilo")
public class Vozilo {
    @Id
    @Column(name = "registracija")
    protected String registracija;
    @Column(name = "model")
    protected String model;
    @Column(name = "sostojba")
    protected String sostojba;
    @Column(name = "data_servis")
    protected ZonedDateTime dataServis;
    @Column(name = "kapacitet")
    protected BigDecimal kapacitet;
    @ManyToOne
    @JoinColumn(name = "embg_vozach")
    protected Vozach vozach;
    
    public Vozilo() {
    }
    
    public Vozilo(String registracija, String model, String sostojba, ZonedDateTime dataServis, BigDecimal kapacitet, Vozach vozach) {
        this.registracija = registracija;
        this.model = model;
        this.sostojba = sostojba;
        this.dataServis = dataServis;
        this.kapacitet = kapacitet;
        this.vozach = vozach;
    }
}
