package mk.bp.project.bplab.model;

import lombok.Data;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Data
@Entity
@Table(schema = "lab_project", name = "narachka")
public class Narachka {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_narachka")
    protected Integer id;
    @Column(name = "dostava_do")
    protected ZonedDateTime dostavaDo;
    @ManyToOne
    @JoinColumn(name = "id_magacin_izvoz")
    protected Magacin MagacinIzvoz;
    @ManyToOne
    @JoinColumn(name = "id_magacin_uvoz")
    protected Magacin MagacinUvoz;
    @Column(name = "sostojba")
    protected String sostojba;
    
    public Narachka(){
    
    }
    
    public Narachka(ZonedDateTime dostavaDo, Magacin magacinIzvoz, Magacin magacinUvoz, String sostojba) {
        this.dostavaDo = dostavaDo;
        MagacinIzvoz = magacinIzvoz;
        MagacinUvoz = magacinUvoz;
        this.sostojba = sostojba;
    }
}
