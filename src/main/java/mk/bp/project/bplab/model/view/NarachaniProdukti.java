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
@Table(schema = "lab_project", name = "narachani_produkti")
public class NarachaniProdukti {
    @Id
    @Column(name = "produkt")
    protected Integer id;
    @Column(name = "naziv")
    protected String ime;
    @Column(name = "proizvoditel")
    protected String proizvoditel;
    @Column(name = "kolicina")
    protected Integer kolicina;
    @Column(name = "tezina_po_eden")
    protected BigDecimal edinechnaTezina;
    @Column(name = "cena")
    protected BigDecimal edinechnaCena;
    @Column(name = "vkupna_tezina")
    protected BigDecimal vkupnaTezina;
    @Column(name = "vkupna_cena")
    protected BigDecimal vkupnaCena;
    @Column(name = "narachka")
    protected Integer narachka;
}
