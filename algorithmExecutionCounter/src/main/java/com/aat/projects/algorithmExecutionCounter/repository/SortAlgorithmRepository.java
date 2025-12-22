package com.aat.projects.algorithmExecutionCounter.repository;

import com.aat.projects.algorithmExecutionCounter.entity.SortAlgorithmHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SortAlgorithmRepository extends JpaRepository<SortAlgorithmHistory, Long> {
}
