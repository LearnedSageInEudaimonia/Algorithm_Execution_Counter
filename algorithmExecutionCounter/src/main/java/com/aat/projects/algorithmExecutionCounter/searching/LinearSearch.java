package com.aat.projects.algorithmExecutionCounter.searching;

public class LinearSearch {
    public static SearchResult search(int[] arr, int target){

        SearchResult searchResult = new SearchResult();

        long startTime = System.nanoTime();

        for(int i = 0 ; i < arr.length; i++){
            searchResult.incrementComparisons();
            if(arr[i] == target){
                 searchResult.setIndex(i);
                 break;
            }
        }

        long endTime = System.nanoTime();
        searchResult.setExecutionTimeNs( endTime - startTime);

        return searchResult;
    }
}
