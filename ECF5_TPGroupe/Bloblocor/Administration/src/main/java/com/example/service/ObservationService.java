package com.example.service;

import com.example.dto.observation.RequestObservationDTO;
import com.example.dto.observation.ResponseObservationDTO;
import com.example.utils.RestClientObservation;
import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Collections;
import java.util.List;

public class ObservationService {

    private RestClientObservation _restClient;

    public ObservationService() {
        _restClient = new RestClientObservation<ResponseObservationDTO, RequestObservationDTO>();
    }

    public String getById(String id) {
        return (String) _restClient.get("/api/observationadmin/" + id, String.class);
    }

    public ResponseObservationDTO add(RequestObservationDTO observationDTO) {
        return (ResponseObservationDTO) _restClient.post("/api/observationadmin", observationDTO, ResponseObservationDTO.class);
    }


    public String delete(String id) {
        return (String) _restClient.delete("/api/observationadmin/delete/" + id, String.class);
    }

    public List<ResponseObservationDTO> getAll() {
    try {
        String jsonResponse = (String) _restClient.get("/api/observationadmin", String.class);
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(jsonResponse, new TypeReference<>() {
        });
    } catch (JsonProcessingException e) {
        e.printStackTrace();
        return Collections.emptyList();
    }
    }


//    public int getTopRatingByUserId(long userIdLong) {
//        return (int) _restClient.get("/api/observationadmin/topRating/" + userIdLong, int.class);
//    }
//
//
//    public int getLowRatingByUserId(long userIdLong) {
//        return (int) _restClient.get("/api/observationadmin/lowRating/" + userIdLong, int.class);
//    }
//
//    public Object getAverageRatingByUserId(long userIdLong) {
//        return (Object) _restClient.get("/api/observationadmin/averageRating/" + userIdLong, Object.class);
//    }

    public int getObservationCount(int userId) {
        return (int) _restClient.get("/api/observationadmin/count/"+userId, int.class);
    }
}
