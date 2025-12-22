package com.aat.projects.algorithmExecutionCounter.service;

import com.aat.projects.algorithmExecutionCounter.dto.AlgorithmsRequestDTO;
import com.aat.projects.algorithmExecutionCounter.dto.AlgorithmsResponseDTO;
import com.aat.projects.algorithmExecutionCounter.dto.searchAlgorithmDtos.SearchAlgorithmsRequestDTO;
import com.aat.projects.algorithmExecutionCounter.dto.searchAlgorithmDtos.SearchAlgorithmsResponseDTO;
import com.aat.projects.algorithmExecutionCounter.entity.SearchAlgorithmHistory;
import com.aat.projects.algorithmExecutionCounter.entity.SortAlgorithmHistory;
import com.aat.projects.algorithmExecutionCounter.enums.Algorithms;
import com.aat.projects.algorithmExecutionCounter.enums.SearchArray;
import com.aat.projects.algorithmExecutionCounter.repository.SearchAlgorithmRepository;
import com.aat.projects.algorithmExecutionCounter.repository.SortAlgorithmRepository;
import com.aat.projects.algorithmExecutionCounter.searching.BinarySearch;
import com.aat.projects.algorithmExecutionCounter.searching.LinearSearch;
import com.aat.projects.algorithmExecutionCounter.searching.SearchResult;
import com.aat.projects.algorithmExecutionCounter.sortingAlgorithms.BubbleSort;
import com.aat.projects.algorithmExecutionCounter.sortingAlgorithms.InsertionSort;
import com.aat.projects.algorithmExecutionCounter.sortingAlgorithms.Result;
import com.aat.projects.algorithmExecutionCounter.sortingAlgorithms.SelectionSort;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.util.Arrays;

@Service
public class AlgorithmsService {

    private final SortAlgorithmRepository sortAlgorithmRepository;
    private final SearchAlgorithmRepository searchAlgorithmRepository;

    public AlgorithmsService(SortAlgorithmRepository sortAlgorithmRepository,
                             SearchAlgorithmRepository searchAlgorithmRepository) {
        this.sortAlgorithmRepository = sortAlgorithmRepository;
        this.searchAlgorithmRepository = searchAlgorithmRepository;
    }

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
        SortAlgorithmHistory sortAlgorithmHistory = SortAlgorithmHistory.builder()
                .algorithmsType(algorithmType)
                .arraySize(originalArray.length)
                .inplace(algorithmType.isInPlace())
                .stable(algorithmType.isStable())
                .timeComplexity(algorithmType.getTimeComplexity())
                .swaps(result.getSwaps())
                .comparisons(result.getComparisons())
                .time(LocalDateTime.now())
                .build();
        sortAlgorithmRepository.save(sortAlgorithmHistory);

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
        SearchAlgorithmHistory searchAlgorithmHistory = SearchAlgorithmHistory.builder()
                .arraySize(array.length)
                .bigONotation(searchType.getBigONotation())
                .comparisons(searchResult.getComparisons())
                .index(searchResult.getIndex())
                .target(request.getTarget())
                .executionTimeNs(searchResult.getExecutionTimeNs())
                .sortedRequired(searchType.isSorted())
                .searchType(request.getSearchType())
                .time(LocalDateTime.now())
                .build();

        searchAlgorithmRepository.save(searchAlgorithmHistory);
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
