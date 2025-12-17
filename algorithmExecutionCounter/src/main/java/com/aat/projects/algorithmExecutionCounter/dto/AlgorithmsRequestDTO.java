package com.aat.projects.algorithmExecutionCounter.dto;


import com.aat.projects.algorithmExecutionCounter.enums.Algorithms;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class AlgorithmsRequestDTO {
    @NotNull(message = "Algorithm type must be provided")
    private Algorithms algorithms;

    @NotNull(message = "Input array must not be null")
    @NotEmpty(message = "Input array must not be empty")
    private int[] array;

}
