package com.online.train.controller;


import com.online.train.model.Train;
import com.online.train.service.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/trains")
public class TrainController {

    @Autowired
    private TrainService trainService;

    @PostMapping("/add")
    public Train addTrain(@RequestBody Train train) {
        return trainService.saveTrain(train);
    }

    @GetMapping("/search/all")
    public List<Train> getAllTrains() {
        return trainService.getAllTrains();
    }


    @GetMapping("/search")
    public List<Train> getTrainsByDateAndRoute(@RequestParam LocalDate travelDate,
                                               @RequestParam String source,
                                               @RequestParam String destination) {
        return trainService.getTrainsByDateAndRoute(travelDate, source, destination);
    }

}