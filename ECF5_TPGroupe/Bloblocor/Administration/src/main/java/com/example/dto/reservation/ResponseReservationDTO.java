package com.example.dto.reservation;

import com.example.observation.dto.EstimationDTO;
import com.example.observation.dto.UserDTO;
import com.example.observation.entity.Reservation;
import lombok.Data;

import java.util.List;

@Data

public class ResponseReservationDTO {
    private List<Reservation> reservations;
    private UserDTO userDTO;
    private EstimationDTO estimationDTO;

}
