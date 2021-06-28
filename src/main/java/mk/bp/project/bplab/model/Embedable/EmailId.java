package mk.bp.project.bplab.model.Embedable;

import mk.bp.project.bplab.model.Vozach;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class EmailId implements Serializable {
    @ManyToOne
    @JoinColumn(name = "embg")
    protected Vozach vozach;
    @Column(name = "adresa")
    protected String adresa;
    
    public Vozach getVozach() {
        return vozach;
    }
    
    public String getAdresa() {
        return adresa;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EmailId)) return false;
        EmailId emailId = (EmailId) o;
        return getVozach().getEmbg().equals(emailId.getVozach().getEmbg()) && getAdresa().equals(emailId.getAdresa());
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(getVozach().getEmbg(), getAdresa());
    }
}
