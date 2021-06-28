package mk.bp.project.bplab.model.Embedable;

import mk.bp.project.bplab.model.Magacin;
import mk.bp.project.bplab.model.Narachka;
import mk.bp.project.bplab.model.Produkt;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class NarachkaProduktId implements Serializable {
    @OneToOne
    @JoinColumn(name = "id_narachka")
    protected Narachka narachka;
    @JoinColumn(name = "id_produkt")
    @OneToOne
    protected Produkt produkt;
    
    public NarachkaProduktId() {
    
    }
    
    public NarachkaProduktId(Narachka narachka, Produkt produkt) {
        this.narachka = narachka;
        this.produkt = produkt;
    }
    
    public Narachka getNarachka() {
        return narachka;
    }
    
    public Produkt getProdukt() {
        return produkt;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NarachkaProduktId)) return false;
        NarachkaProduktId that = (NarachkaProduktId) o;
        return getNarachka().getId().equals(that.getNarachka().getId()) && getProdukt().getId().equals(that.getProdukt().getId());
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(getNarachka().getId(), getProdukt().getId());
    }
}
