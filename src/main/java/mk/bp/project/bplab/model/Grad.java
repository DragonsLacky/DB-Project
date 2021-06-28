package mk.bp.project.bplab.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(schema = "lab_project", name = "grad")
public class Grad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_grad")
    protected Integer id;
    @Column(name = "ime_grad")
    protected String imeGrad;
}
