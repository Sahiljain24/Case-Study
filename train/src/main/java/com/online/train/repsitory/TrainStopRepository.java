package com.online.train.repsitory;



import com.online.train.model.TrainStop;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TrainStopRepository extends JpaRepository<TrainStop, Long> {
    List<TrainStop> findByStationName(String stationName);
}
