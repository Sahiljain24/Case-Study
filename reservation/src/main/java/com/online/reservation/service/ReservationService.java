package com.online.reservation.service;


import com.online.reservation.dto.ReservationRequestDTO;
import com.online.reservation.dto.TrainScheduleResponse;
import com.online.reservation.model.Reservation;
import com.online.reservation.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.UUID;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepo;

    @Autowired
    private RestTemplate restTemplate;

    public Reservation createReservation(ReservationRequestDTO dto) {
        // Step 1: Seat check
        String scheduleUrl = "http://train/api/schedules/check?trainId=" + dto.getTrainId()
                + "&date=" + dto.getTravelDate();

        ResponseEntity<TrainScheduleResponse> response = restTemplate.getForEntity(scheduleUrl, TrainScheduleResponse.class);
        TrainScheduleResponse schedule = response.getBody();

        if (schedule == null || schedule.getAvailableSeats() <= 0) {
            throw new RuntimeException("No seats available for the selected train and date.");
        }

        // Step 2: Calculate fare
        int stationCount = 3; // TODO: Replace with logic from train-service route
        int fare = stationCount * 100;

        // Step 3: Save Reservation
        Reservation res = new Reservation();
        res.setPassengerName(dto.getPassengerName());
        res.setGender(dto.getGender());
        res.setAge(dto.getAge());
        res.setAddress(dto.getAddress());
        res.setBankName(dto.getBankName());
        res.setCreditCardNumber(dto.getCreditCardNumber());
        res.setTrainId(dto.getTrainId());
        res.setSource(dto.getSource());
        res.setDestination(dto.getDestination());
        res.setSeatClass(dto.getSeatClass());
        res.setTravelDate(dto.getTravelDate());
        res.setNumberOfStations(stationCount);
        res.setTotalFare(fare);
        res.setPnr(UUID.randomUUID().toString().substring(0, 8).toUpperCase());
        res.setStatus("BOOKED");

        return reservationRepo.save(res);
    }

    public Reservation cancelReservation(String pnr) {
        Reservation res = reservationRepo.findByPnr(pnr);
        if (res == null) throw new RuntimeException("PNR not found");

        res.setStatus("CANCELLED");
        return reservationRepo.save(res);
    }
}
