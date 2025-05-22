package com.online.reservation.dto;

import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TrainResponse {
    private Long id;
    private String name;
    private String source;
    private String destination;
    private double fare;
    private List<TrainStopResponse> route;

     private List<TrainScheduleResponse> schedules;
}
