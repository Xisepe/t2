package ru.ccfit.golubevm.springnsupractice.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ccfit.golubevm.springnsupractice.core.model.ModelHistory;

public interface ModelHistoryRepository extends JpaRepository<ModelHistory, Integer> {
}