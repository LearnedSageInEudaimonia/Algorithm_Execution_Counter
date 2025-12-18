package com.aat.projects.algorithmExecutionCounter.searching;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SearchResult {

    private int index = -1;
    private int comparisons;
    private long executionTimeNs;

    public void incrementComparisons() {
        this.comparisons++;
    }
}