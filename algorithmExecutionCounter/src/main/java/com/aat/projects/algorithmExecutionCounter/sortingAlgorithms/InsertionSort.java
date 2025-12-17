package com.aat.projects.algorithmExecutionCounter.sortingAlgorithms;

public class InsertionSort {
    public static Result sort(int[] arr) {
        Result result = new Result(0,0);

        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;


            while (j >= 0) {
                result.comparisons++;

                if (arr[j] > key) {
                    arr[j + 1] = arr[j];
                    result.swaps++;
                    j--;
                } else {
                    break;
                }
            }

            arr[j + 1] = key;
        }

        return result;
    }

}
