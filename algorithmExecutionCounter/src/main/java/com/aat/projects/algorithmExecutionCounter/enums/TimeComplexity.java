package com.aat.projects.algorithmExecutionCounter.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum TimeComplexity {
    O_N("O(n)"),
    O_N_SQUARE("O(n²)"),
    O_N_LOG_N("O(n log n)");

    private final String display;
}
