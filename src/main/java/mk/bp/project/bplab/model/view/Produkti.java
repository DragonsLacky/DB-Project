package mk.bp.project.bplab.model.view;

import lombok.Data;
import org.hibernate.annotations.Immutable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Data
@Entity
@Immutable
@Table(schema = "lab_project", name = "produkti")
public class Produkti {
    @Id
    @Column(name = "id")
    protected Integer id;
    @Column(name = "ime")
    protected String ime;
    @Column(name = "proizvoditel")
    protected String proizvoditel;
    @Column(name = "kolicina")
    protected Integer kolicina;
    @Column(name = "tezina")
    protected BigDecimal tezina;
    @Column(name = "cena")
    protected BigDecimal cena;
    @Column(name = "vkupna_tezina")
    protected BigDecimal vkupnaTezina;
    @Column(name = "vkupna_vrednost")
    protected BigDecimal vrednost;
    
}
