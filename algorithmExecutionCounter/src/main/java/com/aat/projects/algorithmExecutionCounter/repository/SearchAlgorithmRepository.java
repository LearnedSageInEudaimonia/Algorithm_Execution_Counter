package com.aat.projects.algorithmExecutionCounter.repository;

import com.aat.projects.algorithmExecutionCounter.entity.SearchAlgorithmHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SearchAlgorithmRepository extends JpaRepository<SearchAlgorithmHistory, Long>{
}
