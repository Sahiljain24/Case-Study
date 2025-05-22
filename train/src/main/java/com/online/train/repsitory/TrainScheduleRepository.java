package com.online.train.repsitory;



import com.online.train.model.TrainSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface TrainScheduleRepository extends JpaRepository<TrainSchedule, Long> {
    Optional<TrainSchedule> findByTrain_IdAndTravelDate(Long trainId, LocalDate travelDate);
}
