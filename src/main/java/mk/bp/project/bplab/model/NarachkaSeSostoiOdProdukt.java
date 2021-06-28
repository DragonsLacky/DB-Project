package mk.bp.project.bplab.model;

import lombok.Data;
import mk.bp.project.bplab.model.Embedable.NarachkaProduktId;

import javax.persistence.*;

@Data
@Entity
@Table(schema = "lab_project", name = "narachka_se_sostoi_od_produkt")
public class NarachkaSeSostoiOdProdukt {
    @EmbeddedId
    protected NarachkaProduktId id;
    @Column(name = "kolicina")
    protected Integer kolicina;
    public NarachkaSeSostoiOdProdukt(){
    
    }
    
    public NarachkaSeSostoiOdProdukt(NarachkaProduktId id, Integer kolicina) {
        this.id = id;
        this.kolicina = kolicina;
    }
    
}
