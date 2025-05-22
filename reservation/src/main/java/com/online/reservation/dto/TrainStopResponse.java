package com.online.reservation.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
@AllArgsConstructor
public class TrainStopResponse {

        private Long id;

        private String stationName;
        private String arrivalTime;
        private String departureTime;
        private TrainResponse train;



}
