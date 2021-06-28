package mk.bp.project.bplab.model;

import lombok.Data;
import mk.bp.project.bplab.model.Embedable.PrevozNarachkaId;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Data
@Entity
@Table(schema = "lab_project", name = "prevoz_narachka")
public class PrevozNarachka {
    @EmbeddedId
    protected PrevozNarachkaId id;
    @Column(name = "dostaveno_na")
    protected ZonedDateTime dostavenaNa;
    
    public PrevozNarachka() {
    
    }
    
    public PrevozNarachka(PrevozNarachkaId id, ZonedDateTime dostavenaNa) {
        this.id = id;
        this.dostavenaNa = dostavenaNa;
    }
}
