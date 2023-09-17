package com.example.utils;

import com.example.dto.reservation.RequestReservationDTO;
import com.example.dto.reservation.ResponseReservationDTO;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

public class RestClientResa<T, V> {


    private final String server = "http://localhost:8083/";

    private final RestTemplate template;

    private HttpStatusCode status;

    private final HttpHeaders headers;

    public RestClientResa() {
        template = new RestTemplate();
        headers = new HttpHeaders();
        headers.add("Accept", "*/*");
        headers.add("content-type", "application/json");

    }

    public T get(String uri, Class<T> type) {
        HttpEntity<String> requestEntity = new HttpEntity<>("", headers);
        ResponseEntity<T> responseEntity = template.exchange(server + uri, org.springframework.http.HttpMethod.GET, requestEntity, type);
        status = responseEntity.getStatusCode();
        return responseEntity.getBody();
    }

    public T delete(String uri, Class<T> type) {
        HttpEntity<String> requestEntity = new HttpEntity<>("", headers);
        ResponseEntity<T> responseEntity = template.exchange(server + uri, org.springframework.http.HttpMethod.DELETE, requestEntity, type);
        status = responseEntity.getStatusCode();
        return responseEntity.getBody();
    }


    public T post(String uri, V data, Class<T> type) {
        HttpEntity<V> requestEntity = new HttpEntity<>(data, headers);
        ResponseEntity<T> responseEntity = template.exchange(server + uri, org.springframework.http.HttpMethod.POST, requestEntity, type);
        status = responseEntity.getStatusCode();
        return responseEntity.getBody();
    }

    public Object put(String uri, RequestReservationDTO reservation, Class<ResponseReservationDTO> responseReservationDTOClass) {
        HttpEntity<RequestReservationDTO> requestEntity = new HttpEntity<>(reservation, headers);
        ResponseEntity<ResponseReservationDTO> responseEntity = template.exchange(server + uri, HttpMethod.PUT, requestEntity, responseReservationDTOClass);
        status = responseEntity.getStatusCode();
        return responseEntity.getBody();
    }
}
