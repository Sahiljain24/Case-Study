package com.online.train.service;

import com.online.train.model.TrainSchedule;
import com.online.train.model.TrainStop;
import com.online.train.repsitory.*;
import com.online.train.model.Train;
import com.online.train.repsitory.TrainRepository;
import com.online.train.repsitory.TrainScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TrainService {


    @Autowired
    private TrainRepository trainRepository;

    @Autowired
    private TrainScheduleRepository trainScheduleRepository;

    @Autowired
    private TrainStopRepository trainStopRepository;

    // Save the Train, TrainStop, and TrainSchedule
    public Train saveTrain(Train train) {
        // Save the train first
        Train savedTrain = trainRepository.save(train);

        // Save all the TrainStops related to the train
        for (TrainStop stop : train.getRoute()) {
            stop.setTrain(savedTrain);  // Make sure to associate the train with the stop
            trainStopRepository.save(stop);
        }

        // Save all the TrainSchedules related to the train
        for (TrainSchedule schedule : train.getSchedules()) {
            schedule.setTrain(savedTrain);  // Make sure to associate the train with the schedule
            trainScheduleRepository.save(schedule);
        }

        return savedTrain;  // Return the saved train (including stops and schedules)
    }



public List<Train> getAllTrains() {
        return trainRepository.findAll();
    }

    public List<Train> getTrainsByDateAndRoute(LocalDate travelDate, String source, String destination) {
        return trainRepository.findTrainsByScheduleDateAndRoute(travelDate, source, destination);
    }
}
