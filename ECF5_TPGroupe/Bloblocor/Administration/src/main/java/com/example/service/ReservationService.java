package com.example.service;

import com.example.dto.reservation.RequestReservationDTO;
import com.example.dto.reservation.ResponseReservationDTO;
import com.example.dto.reservation.ResponseTakeReservationDTO;
import com.example.utils.RestClientResa;

public class ReservationService {
    private final RestClientResa _restClient;

    public ReservationService() {
        _restClient = new RestClientResa<ResponseReservationDTO, RequestReservationDTO>();
    }


    public ResponseTakeReservationDTO getByIdTake(int id) {
        return (ResponseTakeReservationDTO) _restClient.get("/api/reservationadmin/" + id, ResponseTakeReservationDTO.class);
    }

    public ResponseReservationDTO getById(int id) {
        return (ResponseReservationDTO) _restClient.get("/api/reservationadmin/" + id, ResponseReservationDTO.class);
    }


    public ResponseReservationDTO add(RequestReservationDTO reservationDTO) {
        return (ResponseReservationDTO) _restClient.post("/api/reservationadmin", reservationDTO, ResponseReservationDTO.class);
    }

    public String delete(Long id) {
        return (String) _restClient.delete("/api/reservationadmin/delete/" + id, String.class);
    }

    public ResponseReservationDTO getAll() {
        ResponseReservationDTO responseReservationDTOList = (ResponseReservationDTO) _restClient.get("/api/reservationadmin/all", ResponseReservationDTO.class);
        return responseReservationDTOList;
    }

    public ResponseReservationDTO update(RequestReservationDTO reservation) {
        return (ResponseReservationDTO) _restClient.put("/api/reservationadmin/update/" + reservation.getId(), reservation, ResponseReservationDTO.class);
    }
    public int getReservationCount(int reservationId) {
        return (int) _restClient.get("/api/reservationadmin/count/"+reservationId, int.class);
    }
}