package mk.bp.project.bplab.service;

import mk.bp.project.bplab.model.Grad;

import java.util.List;
import java.util.Optional;

public interface GradService {
    List<Grad> findAll();
    Optional<Grad> findById(Integer id);
}
