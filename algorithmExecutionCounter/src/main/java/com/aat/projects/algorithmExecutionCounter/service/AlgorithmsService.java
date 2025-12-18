package com.aat.projects.algorithmExecutionCounter.service;

import com.aat.projects.algorithmExecutionCounter.dto.AlgorithmsRequestDTO;
import com.aat.projects.algorithmExecutionCounter.dto.AlgorithmsResponseDTO;
import com.aat.projects.algorithmExecutionCounter.dto.searchAlgorithmDtos.SearchAlgorithmsRequestDTO;
import com.aat.projects.algorithmExecutionCounter.dto.searchAlgorithmDtos.SearchAlgorithmsResponseDTO;
import com.aat.projects.algorithmExecutionCounter.enums.Algorithms;
import com.aat.projects.algorithmExecutionCounter.enums.SearchArray;
import com.aat.projects.algorithmExecutionCounter.searching.BinarySearch;
import com.aat.projects.algorithmExecutionCounter.searching.LinearSearch;
import com.aat.projects.algorithmExecutionCounter.searching.SearchResult;
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

    public SearchAlgorithmsResponseDTO executeSearchAlgorithm(SearchAlgorithmsRequestDTO request) {
        SearchArray searchType = request.getSearchType();
        int[] array = request.getArray();

        SearchResult searchResult;

        switch (searchType){
            case LINEAR_SEARCH -> {
                searchResult = LinearSearch.search(array, request.getTarget());
            }
            case BINARY_SEARCH -> {
                searchResult = BinarySearch.search(array, request.getTarget());
            }
            default -> throw new IllegalArgumentException("Illegal Search Type");
        }
        return SearchAlgorithmsResponseDTO.builder()
                .index(searchResult.getIndex())
                .comparisons(searchResult.getComparisons())
                .searchType(request.getSearchType())
                .sortedRequired(searchType.isSorted())
                .executionTimeNs(searchResult.getExecutionTimeNs())
                .bigONotation(searchType.getBigONotation())
                .arraySize(request.getArray().length)
                .target(request.getTarget())
                .build();
    }
}
