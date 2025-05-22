package com.online.train.repsitory;


import com.online.train.model.Train;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface TrainRepository extends JpaRepository<Train, Long> {
    @Query("SELECT t FROM Train t JOIN t.schedules ts WHERE ts.travelDate = :travelDate " +
            "AND t.source = :source AND t.destination = :destination")
    List<Train> findTrainsByScheduleDateAndRoute(@Param("travelDate") LocalDate travelDate,
                                                 @Param("source") String source,
                                                 @Param("destination") String destination);
}