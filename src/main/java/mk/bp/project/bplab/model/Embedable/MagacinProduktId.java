package mk.bp.project.bplab.model.Embedable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class MagacinProduktId implements Serializable {
    @Column(name = "id")
    protected Integer magacin;
    @Column(name = "id_produkt")
    protected Integer produkt;
    
    public Integer getMagacin() {
        return magacin;
    }
    
    public Integer getProdukt() {
        return produkt;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MagacinProduktId)) return false;
        MagacinProduktId that = (MagacinProduktId) o;
        return getMagacin().equals(that.getMagacin()) && getProdukt().equals(that.getProdukt());
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(getMagacin(), getProdukt());
    }
}
