package com.aat.projects.algorithmExecutionCounter.sortingAlgorithms;

public class BubbleSort {

    public static Result sort(int[] arr) {
        Result result = new Result(0,0);
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;

            for (int j = 0; j < n - 1 - i; j++) {
                result.comparisons++;

                if (arr[j] > arr[j + 1]) {
                    // swap
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

                    result.swaps++;
                    swapped = true;
                }
            }

            // optimization: stop if already sorted
            if (!swapped) break;
        }
        return result;
    }

}
