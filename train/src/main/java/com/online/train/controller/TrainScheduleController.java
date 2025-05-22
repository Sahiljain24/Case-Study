package com.online.train.controller;

import com.online.train.model.TrainSchedule;
import com.online.train.repsitory.TrainScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/schedules")
public class TrainScheduleController {

    @Autowired
    private TrainScheduleRepository trainScheduleRepository;

    @GetMapping("/check")
    public ResponseEntity<TrainSchedule> checkAvailability(
            @RequestParam Long trainId,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {

        TrainSchedule schedule = trainScheduleRepository
                .findByTrain_IdAndTravelDate(trainId, date)
                .orElseThrow(() -> new RuntimeException("No schedule found for this train on the given date"));

        return ResponseEntity.ok(schedule);
    }
}
