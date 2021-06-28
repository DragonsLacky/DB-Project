package mk.bp.project.bplab.model.Embedable;

import mk.bp.project.bplab.model.Produkt;

import javax.persistence.*;
import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.Objects;

@Embeddable
public class CenaId implements Serializable {
    @ManyToOne
    @JoinColumn(name = "id_produkt")
    protected Produkt produkt;
    @Column(name = "data_od")
    protected ZonedDateTime dataOd;
    
    public mk.bp.project.bplab.model.Produkt getProdukt() {
        return produkt;
    }
    
    public CenaId() {
    
    }
    
    public CenaId(mk.bp.project.bplab.model.Produkt produkt, ZonedDateTime dataOd) {
        this.produkt = produkt;
        this.dataOd = dataOd;
    }
    
    public ZonedDateTime getDataOd() {
        return dataOd;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CenaId)) return false;
        CenaId cenaId = (CenaId) o;
        return getProdukt().getId().equals(cenaId.getProdukt().getId()) && getDataOd().equals(cenaId.getDataOd());
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(getProdukt().getId(), getDataOd());
    }
}
