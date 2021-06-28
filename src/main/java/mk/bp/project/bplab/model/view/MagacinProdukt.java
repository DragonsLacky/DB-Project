package mk.bp.project.bplab.model.view;

import lombok.Data;
import mk.bp.project.bplab.model.Embedable.MagacinProduktId;
import org.hibernate.annotations.Immutable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Data
@Entity
@Immutable
@Table(schema = "lab_project",name = "listanje_produkti_po_magacin")
public class MagacinProdukt {
    @EmbeddedId
    protected MagacinProduktId id;
    @Column(name = "produkt")
    protected String imeProdukt;
    @Column(name = "proizvoditel")
    protected String proizvoditel;
    @Column(name = "cena_po_produkt")
    protected BigDecimal cena;
    @Column(name = "vkupna_kolicina")
    protected Integer kolicina;
    @Column(name = "vkupna_tezina")
    protected BigDecimal tezina;
    @Column(name = "vrednost")
    protected BigDecimal vrednost;
}
