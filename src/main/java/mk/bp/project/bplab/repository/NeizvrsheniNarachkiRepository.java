package mk.bp.project.bplab.repository;

import mk.bp.project.bplab.model.Narachka;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface NeizvrsheniNarachkiRepository extends JpaRepository<Narachka, Integer> {
    List<Narachka> findAllBySostojba(String sostojba);
}
