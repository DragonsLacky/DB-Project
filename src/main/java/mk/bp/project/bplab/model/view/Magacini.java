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
@Table(schema = "lab_project", name = "magacini")
public class Magacini {
    @Id
    @Column(name = "magacin")
    protected Integer id;
    @Column(name = "adresa")
    protected String adresa;
    @Column(name = "grad")
    protected String grad;
}
