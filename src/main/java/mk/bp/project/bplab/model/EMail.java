package mk.bp.project.bplab.model;

import lombok.Data;
import mk.bp.project.bplab.model.Embedable.EmailId;

import javax.persistence.*;

@Data
@Entity
@Table(schema = "lab_project", name = "e_mail")
public class EMail {
    @EmbeddedId
    protected EmailId id;
}
