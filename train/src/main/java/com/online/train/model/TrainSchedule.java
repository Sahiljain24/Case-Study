package com.online.train.model;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.*;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TrainSchedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate travelDate;
    private int availableSeats;

    @ManyToOne
    @JoinColumn(name = "train_id")
    private Train train;
}
