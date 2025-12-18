package com.aat.projects.algorithmExecutionCounter.controller;

import com.aat.projects.algorithmExecutionCounter.dto.AlgorithmsRequestDTO;
import com.aat.projects.algorithmExecutionCounter.dto.AlgorithmsResponseDTO;
import com.aat.projects.algorithmExecutionCounter.dto.searchAlgorithmDtos.SearchAlgorithmsRequestDTO;
import com.aat.projects.algorithmExecutionCounter.dto.searchAlgorithmDtos.SearchAlgorithmsResponseDTO;
import com.aat.projects.algorithmExecutionCounter.service.AlgorithmsService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("algorithms/")
@RequiredArgsConstructor
public class AlgorithmsController {

    private final AlgorithmsService algorithmsService;
    @PostMapping("/sort-algorithms")
    public ResponseEntity<AlgorithmsResponseDTO> sort(
            @RequestBody @Valid AlgorithmsRequestDTO request ){
        AlgorithmsResponseDTO response = algorithmsService.executeSortingAlgorithm(request);

        return ResponseEntity.ok(response);
    }

    @PostMapping("/search-array")
    public ResponseEntity<SearchAlgorithmsResponseDTO> search(
            @RequestBody @Valid SearchAlgorithmsRequestDTO request) {
        SearchAlgorithmsResponseDTO response = algorithmsService.executeSearchAlgorithm(request);
        return ResponseEntity.ok(response);
    }
}
