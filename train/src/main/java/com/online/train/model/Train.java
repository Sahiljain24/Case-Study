package com.online.train.model;



import jakarta.persistence.*;
import lombok.*;

import java.util.List;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Train {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String source;
    private String destination;
    private double fare;

    @OneToMany(mappedBy = "train", cascade = CascadeType.ALL)
    private List<TrainStop> route;

    @OneToMany(mappedBy = "train", cascade = CascadeType.ALL)
    private List<TrainSchedule> schedules;
}
