package com.aat.projects.algorithmExecutionCounter.dto.searchAlgorithmDtos;

import com.aat.projects.algorithmExecutionCounter.enums.SearchArray;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import jakarta.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
public class SearchAlgorithmsRequestDTO {
    @NotNull(message = "search Type is required")
    private SearchArray searchType;

    @NotNull(message = "Array object is required")
    @NotEmpty(message = "Array should not be empty")
    private int[] array;

    @NotNull(message = "Target element should be provided")
    private int target;
}
