package com.aat.projects.algorithmExecutionCounter.entity;

import com.aat.projects.algorithmExecutionCounter.enums.Algorithms;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.Array;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "sort_history")
public class SortAlgorithmHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Enumerated
    private Algorithms algorithmsType;

    @NotNull
    private int arraySize;

    @NotNull
    private long comparisons;

    @NotNull
    private long swaps;

    @NotNull
    private String timeComplexity;

    @NotNull
    private boolean stable;

    @NotNull
    private  boolean inplace;

    @NotNull
    @CreationTimestamp
    private LocalDateTime time;

}
