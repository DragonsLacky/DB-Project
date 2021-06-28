package mk.bp.project.bplab.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.ZonedDateTime;

@Data
@Entity
@Table(schema = "lab_project", name = "vozach")
public class Vozach {
    @Id
    @Column(name = "embg")
    protected String embg;
    @Column(name = "ime")
    protected String ime;
    @Column(name = "prezime")
    protected String prezime;
    @Column(name = "broj_dozvola")
    protected String dozvola;
    @Column(name = "vazhnost_do")
    protected ZonedDateTime vazhnost;
    
    public Vozach() {
    }
    
    public Vozach(String embg, String ime, String prezime, String dozvola, ZonedDateTime vazhnost) {
        this.embg = embg;
        this.ime = ime;
        this.prezime = prezime;
        this.dozvola = dozvola;
        this.vazhnost = vazhnost;
    }
}
