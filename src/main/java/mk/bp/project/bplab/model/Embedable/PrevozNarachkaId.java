package mk.bp.project.bplab.model.Embedable;

import mk.bp.project.bplab.model.Narachka;
import mk.bp.project.bplab.model.Vozach;
import mk.bp.project.bplab.model.Vozilo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class PrevozNarachkaId implements Serializable {
    @ManyToOne
    @JoinColumn(name = "id_narachka")
    protected Narachka narachka;
    @ManyToOne
    @JoinColumn(name = "embg_vozach")
    protected Vozach vozach;
    @ManyToOne
    @JoinColumn(name = "registracija_vozilo")
    protected Vozilo vozilo;
    
    public Narachka getNarachka() {
        return narachka;
    }
    
    public Vozach getVozach() {
        return vozach;
    }
    
    public Vozilo getVozilo() {
        return vozilo;
    }
    
    public PrevozNarachkaId() {
    
    }
    
    public PrevozNarachkaId(Narachka narachka, Vozach vozach, Vozilo vozilo) {
        this.narachka = narachka;
        this.vozach = vozach;
        this.vozilo = vozilo;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PrevozNarachkaId)) return false;
        PrevozNarachkaId that = (PrevozNarachkaId) o;
        return getNarachka().getId().equals(that.getNarachka().getId()) && getVozach().getEmbg().equals(that.getVozach().getEmbg()) && getVozilo().getRegistracija().equals(that.getVozilo().getRegistracija());
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(getNarachka().getId(), getVozach().getEmbg(), getVozilo().getRegistracija());
    }
}
