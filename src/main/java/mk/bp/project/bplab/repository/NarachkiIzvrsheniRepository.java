package mk.bp.project.bplab.repository;

import mk.bp.project.bplab.model.Narachka;
import mk.bp.project.bplab.model.view.IzvrsheniNarachki;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NarachkiIzvrsheniRepository extends JpaRepository<IzvrsheniNarachki, Narachka> {
    List<IzvrsheniNarachki> findBySostojba(String sostojba);
}
