package mk.bp.project.bplab.model.Embedable;

import mk.bp.project.bplab.model.Magacin;
import mk.bp.project.bplab.model.Produkt;

import javax.persistence.Embeddable;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ProduktMagacinId implements Serializable {
    @OneToOne
    @JoinColumn(name = "id_produkt")
    protected Produkt produkt;
    @OneToOne
    @JoinColumn(name = "id_magacin")
    protected Magacin magacin;
    
    public ProduktMagacinId() {
    
    }
    
    public Produkt getProdukt() {
        return produkt;
    }
    
    public Magacin getMagacin() {
        return magacin;
    }
    
    public ProduktMagacinId(Produkt produkt, Magacin magacin) {
        this.produkt = produkt;
        this.magacin = magacin;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProduktMagacinId)) return false;
        ProduktMagacinId that = (ProduktMagacinId) o;
        return getProdukt().getId().equals(that.getProdukt().getId()) && getMagacin().getId().equals(that.getMagacin().getId());
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(getProdukt().getId(), getMagacin().getId());
    }
}
