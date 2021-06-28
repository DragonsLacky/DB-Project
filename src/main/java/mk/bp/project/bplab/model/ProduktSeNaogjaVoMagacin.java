package mk.bp.project.bplab.model;

import lombok.Data;
import mk.bp.project.bplab.model.Embedable.ProduktMagacinId;

import javax.persistence.*;

@Data
@Entity
@Table(schema = "lab_project", name = "produkt_se_naogja_vo_magacin")
public class ProduktSeNaogjaVoMagacin {
    @EmbeddedId
    protected ProduktMagacinId produktMagacin;
    @Column(name = "sektor")
    protected String sektor;
    @Column(name = "kolicina")
    protected Integer kolicina;
    
    public ProduktSeNaogjaVoMagacin(ProduktMagacinId produktMagacin, String sektor, Integer kolicina) {
        this.produktMagacin = produktMagacin;
        this.sektor = sektor;
        this.kolicina = kolicina;
    }
    
    public ProduktSeNaogjaVoMagacin() {
    
    }
    
    public ProduktMagacinId getProduktMagacin() {
        return produktMagacin;
    }
    
    public String getSektor() {
        return sektor;
    }
    
    public Integer getKolicina() {
        return kolicina;
    }
}