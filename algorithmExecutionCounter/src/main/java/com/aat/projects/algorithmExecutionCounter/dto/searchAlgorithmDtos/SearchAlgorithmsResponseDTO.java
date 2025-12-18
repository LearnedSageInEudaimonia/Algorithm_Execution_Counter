package com.aat.projects.algorithmExecutionCounter.dto.searchAlgorithmDtos;

import com.aat.projects.algorithmExecutionCounter.enums.SearchArray;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SearchAlgorithmsResponseDTO {
    private SearchArray searchType;
    private int target;
    private int comparisons;
    private int index;
    private long executionTimeNs;
    private boolean sortedRequired;
    private int arraySize;
    private String bigONotation;
}
