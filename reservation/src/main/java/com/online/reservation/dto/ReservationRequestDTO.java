package com.online.reservation.dto;



import lombok.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReservationRequestDTO {

    private String passengerName;
    private String gender;
    private int age;
    private String address;
    private String bankName;
    private String creditCardNumber;

    private Long trainId;
    private String source;
    private String destination;
    private String seatClass;
    private LocalDate travelDate;
}
