package mk.bp.project.bplab.model;

import lombok.Data;
import mk.bp.project.bplab.model.Embedable.CenaId;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.ZonedDateTime;

@Data
@Entity
@Table(schema = "lab_project", name = "cena")
public class Cena {
    @EmbeddedId
    protected CenaId id;
    @Column(name = "data_do")
    protected ZonedDateTime dataDo;
    @Column(name = "kolicina")
    protected BigDecimal kolicina;
    
    public Cena() {
    
    }
    
    public Cena(CenaId id, BigDecimal kolicina) {
        this.id = id;
        this.kolicina = kolicina;
    }
}
