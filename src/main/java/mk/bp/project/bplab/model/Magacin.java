package mk.bp.project.bplab.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(schema = "lab_project",name = "magacin")
public class Magacin {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_magacin")
    protected Integer id;
    @Column(name = "adresa")
    protected String adresa;
    @ManyToOne
    @JoinColumn(name = "id_grad")
    protected Grad grad;
    public Magacin() {
    
    }
    
    public Magacin(String adresa, Grad grad) {
        this.adresa = adresa;
        this.grad = grad;
    }
}
