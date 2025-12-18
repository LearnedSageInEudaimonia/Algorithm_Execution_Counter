package com.aat.projects.algorithmExecutionCounter.enums;

import lombok.Getter;

@Getter
public enum SearchArray {
    LINEAR_SEARCH(false, "O(n)"),
    BINARY_SEARCH(true, "O(log n)");
    boolean sorted;
    String bigONotation;

    SearchArray(boolean b, String bigONotation) {
        this.sorted = b;
        this.bigONotation= bigONotation;
    }

}
