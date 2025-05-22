package com.online.reservation.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TrainScheduleResponse {

    private Long id;
    private LocalDate travelDate;
    private int availableSeats;
    @JsonIgnore
    private TrainResponse train;  // Nested train object with full train details

}

