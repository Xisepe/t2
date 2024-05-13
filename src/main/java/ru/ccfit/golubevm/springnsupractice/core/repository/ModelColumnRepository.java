package ru.ccfit.golubevm.springnsupractice.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ccfit.golubevm.springnsupractice.core.model.ModelColumn;

public interface ModelColumnRepository extends JpaRepository<ModelColumn, Integer> {
}