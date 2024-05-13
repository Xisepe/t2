package ru.ccfit.golubevm.springnsupractice.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ccfit.golubevm.springnsupractice.core.model.Model;

public interface ModelRepository extends JpaRepository<Model, Integer> {
}