package com.aat.projects.algorithmExecutionCounter.dto;

import com.aat.projects.algorithmExecutionCounter.enums.Algorithms;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AlgorithmsResponseDTO {
    private Algorithms algorithms;
    private int[] originalArray;
    private int[] sortedArray;
    private long comparisons;
    private long swaps;
    private String timeComplexity;
    private boolean stable;
    private boolean InPlace;
}
