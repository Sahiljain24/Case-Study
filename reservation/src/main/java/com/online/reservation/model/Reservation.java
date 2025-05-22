package com.online.reservation.model;




import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Passenger info
    private String passengerName;
    private String gender;
    private int age;
    private String address;
    private String bankName;
    private String creditCardNumber;

    // Reservation info
    private Long trainId;
    private String source;
    private String destination;
    private LocalDate travelDate;
    private String seatClass;

    private int numberOfStations;
    private int totalFare;
    private String pnr;
    private String status; // BOOKED / CANCELLED
}
