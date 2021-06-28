package mk.bp.project.bplab.model.view;

import lombok.Data;
import org.hibernate.annotations.Immutable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Immutable
@Table(schema = "lab_project", name = "vozachi")
public class Vozachi {
    @Id
    @Column(name = "embg")
    protected String embg;
    @Column(name = "ime_prezime")
    protected String imePrezime;
    @Column(name = "broj_dozvola")
    protected String dozvola;
    @Column(name = "vazhnost_do")
    protected String vazhnost;
}
