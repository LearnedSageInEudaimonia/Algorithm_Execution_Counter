package com.aat.projects.algorithmExecutionCounter.service;

import com.aat.projects.algorithmExecutionCounter.dto.AlgorithmsRequestDTO;
import com.aat.projects.algorithmExecutionCounter.dto.AlgorithmsResponseDTO;
import com.aat.projects.algorithmExecutionCounter.enums.Algorithms;
import com.aat.projects.algorithmExecutionCounter.sortingAlgorithms.BubbleSort;
import com.aat.projects.algorithmExecutionCounter.sortingAlgorithms.InsertionSort;
import com.aat.projects.algorithmExecutionCounter.sortingAlgorithms.Result;
import com.aat.projects.algorithmExecutionCounter.sortingAlgorithms.SelectionSort;
import org.springframework.stereotype.Service;


import java.util.Arrays;

@Service
public class AlgorithmsService {
    public AlgorithmsResponseDTO executeSortingAlgorithm(AlgorithmsRequestDTO request){
        Algorithms algorithmType = request.getAlgorithms();
        int[] originalArray = request.getArray();
        int[] workingArray = Arrays.copyOf(originalArray, originalArray.length);
        Result result;

        switch (algorithmType){
            case BUBBLE_SORT -> {
                result = BubbleSort.sort(workingArray);
            }
            case INSERTION_SORT -> {
                 result = InsertionSort.sort(workingArray);
            }
            case SELECTION_SORT -> {
                 result = SelectionSort.sort(workingArray);
            }
            default -> throw new IllegalArgumentException("UnSupported algorithm Type");
        }
        return AlgorithmsResponseDTO.builder()
                .algorithms(algorithmType)
                .comparisons(result.getComparisons())
                .sortedArray(workingArray)
                .originalArray(originalArray)
                .swaps(result.getSwaps())
                .timeComplexity(algorithmType.getTimeComplexity())
                .stable(algorithmType.isStable())
                .InPlace(algorithmType.isInPlace())
                .build();
    }
}
