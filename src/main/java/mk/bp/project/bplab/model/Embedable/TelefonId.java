package mk.bp.project.bplab.model.Embedable;

import com.sun.source.doctree.SerialDataTree;
import mk.bp.project.bplab.model.Vozach;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class TelefonId implements Serializable {
    @OneToOne
    @JoinColumn(name = "embg")
    protected Vozach embg;
    @Column(name = "telefonski_broj")
    protected String broj;
    
    public Vozach getEmbg() {
        return embg;
    }
    
    public String getBroj() {
        return broj;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TelefonId)) return false;
        TelefonId telefonId = (TelefonId) o;
        return getEmbg().getEmbg().equals(telefonId.getEmbg().getEmbg()) && getBroj().equals(telefonId.getBroj());
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(getEmbg().getEmbg(), getBroj());
    }
}
