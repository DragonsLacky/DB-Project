package mk.bp.project.bplab.model;

import lombok.Data;
import mk.bp.project.bplab.model.Embedable.TelefonId;

import javax.persistence.*;

@Data
@Entity
@Table(schema = "lab_project", name = "telefon")
public class Telefon {
    @EmbeddedId
    protected TelefonId telefon;
}
