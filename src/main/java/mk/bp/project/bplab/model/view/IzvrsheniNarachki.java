package mk.bp.project.bplab.model.view;

import lombok.Data;
import org.hibernate.annotations.Immutable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.ZonedDateTime;

@Data
@Entity
@Table(schema = "lab_project",name = "narachki")
public class IzvrsheniNarachki {
    @Id
    @Column(name = "narachka")
    protected Integer narachka;
    @Column(name = "magacin_izvoz")
    protected Integer idIzvoz;
    @Column(name = "adresa_i")
    protected String adresaIzvoz;
    @Column(name = "grad_i")
    protected String gradIzvoz;
    @Column(name = "magacin_uvoz")
    protected Integer idUvoz;
    @Column(name = "adresa_u")
    protected String adresaUvoz;
    @Column(name = "grad_u")
    protected String gradUvoz;
    @Column(name = "vozach")
    protected String vozachEMBG;
    @Column(name = "ime_prezime")
    protected String vozachImePrezime;
    @Column(name = "dostava_do")
    protected ZonedDateTime rokDostava;
    @Column(name = "dostavena_na")
    protected ZonedDateTime dostavena;
    @Column(name = "sostojba")
    protected String sostojba;
}
