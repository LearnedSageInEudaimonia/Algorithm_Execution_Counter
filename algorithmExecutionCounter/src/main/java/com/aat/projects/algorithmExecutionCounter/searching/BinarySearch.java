package com.aat.projects.algorithmExecutionCounter.searching;

public class BinarySearch {
    public static SearchResult search(int[] arr, int target){
        SearchResult searchResult = new SearchResult();
        int start = 0, end = arr.length - 1;
        long startTime = System.nanoTime();
        while(start < end){
            int mid = start + (end - start)/2;
            searchResult.incrementComparisons();
            if(arr[mid] == target){
                searchResult.setIndex(mid);
                break;
            }else if(arr[mid] < target){
                start++;
            }else{
                end--;
            }
        }
        long endTime = System.nanoTime();
        searchResult.setExecutionTimeNs(endTime - startTime);
        return searchResult;
    }
}
