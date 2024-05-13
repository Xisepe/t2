package ru.ccfit.golubevm.springnsupractice.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ccfit.golubevm.springnsupractice.core.model.ModelColumnHistory;

public interface ModelColumnHistoryRepository extends JpaRepository<ModelColumnHistory, Integer> {
}