package com.aat.projects.algorithmExecutionCounter.entity;


import com.aat.projects.algorithmExecutionCounter.enums.SearchArray;
import jakarta.persistence.*;
import lombok.*;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "search_Algorithm_history")
public class SearchAlgorithmHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Enumerated
    private SearchArray searchType;

    @NotNull
    private int target;

    @NotNull
    private int comparisons;

    @NotNull
    private int index;

    @NotNull
    private long executionTimeNs;

    @NotNull
    private boolean sortedRequired;

    @NotNull
    private int arraySize;

    @NotNull
    private String bigONotation;

    @CreationTimestamp
    private LocalDateTime time;

}
