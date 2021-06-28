package mk.bp.project.bplab.model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
@Table(schema = "lab_project",name = "produkt")
public class Produkt {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_produkt")
    protected Integer id;
    @Column(name = "ime_produkt")
    protected String ime;
    @Column(name = "kolicina")
    protected Integer kolicina;
    @Column(name = "tezina")
    protected BigDecimal tezina;
    @Column(name = "proizvoditel")
    protected String proizvoditel;
    
    public Produkt() {
    
    }
    
    public Produkt(String ime, Integer kolicina, BigDecimal tezina, String proizvoditel) {
        this.ime = ime;
        this.kolicina = kolicina;
        this.tezina = tezina;
        this.proizvoditel = proizvoditel;
    }
    
    
}
