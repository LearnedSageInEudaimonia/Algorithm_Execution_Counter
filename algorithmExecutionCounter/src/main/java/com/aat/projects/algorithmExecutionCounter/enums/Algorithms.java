package com.aat.projects.algorithmExecutionCounter.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum Algorithms {
    BUBBLE_SORT(TimeComplexity.O_N_SQUARE, true, true),
    INSERTION_SORT(TimeComplexity.O_N_SQUARE,true, true),
    SELECTION_SORT(TimeComplexity.O_N_SQUARE, false, true);

    private final TimeComplexity timeComplexity;
    @Getter
    private final boolean stable;
    @Getter
    private final boolean inPlace;

    public String getTimeComplexity(){
        return timeComplexity.getDisplay();
    }

}
