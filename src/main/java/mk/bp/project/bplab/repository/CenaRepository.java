package mk.bp.project.bplab.repository;

import mk.bp.project.bplab.model.Cena;
import mk.bp.project.bplab.model.Embedable.CenaId;
import mk.bp.project.bplab.model.Produkt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.ZonedDateTime;
import java.util.List;

@Repository
public interface CenaRepository extends JpaRepository<Cena, CenaId> {
    Cena findByIdProduktIdAndDataDo(Integer id, ZonedDateTime zonedDateTime);
}
