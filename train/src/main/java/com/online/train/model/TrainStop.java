package com.online.train.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TrainStop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String stationName;
    private String arrivalTime;
    private String departureTime;

    @ManyToOne
    @JoinColumn(name = "train_id")
    private Train train;
}

