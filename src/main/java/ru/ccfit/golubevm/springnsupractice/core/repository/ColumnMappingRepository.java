package ru.ccfit.golubevm.springnsupractice.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ccfit.golubevm.springnsupractice.core.model.ColumnMapping;

public interface ColumnMappingRepository extends JpaRepository<ColumnMapping, Integer> {
}