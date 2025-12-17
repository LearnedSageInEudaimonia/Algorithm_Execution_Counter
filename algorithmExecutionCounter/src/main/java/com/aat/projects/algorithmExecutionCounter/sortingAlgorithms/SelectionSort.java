package com.aat.projects.algorithmExecutionCounter.sortingAlgorithms;

import com.aat.projects.algorithmExecutionCounter.enums.Algorithms;

public class SelectionSort {

    public static Result sort(int[] arr) {
        Result result = new Result(0,0);
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < n; j++) {
                result.comparisons++;

                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            // swap only if needed
            if (minIndex != i) {
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;

                result.swaps++;
            }
        }
        return result;
    }
}
