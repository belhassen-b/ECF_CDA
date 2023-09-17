package com.example.utils;

import com.example.dto.observation.RequestObservationDTO;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class RestClientObservation <T,V>    {

    private final String server = "http://localhost:8085/";

    private RestTemplate template;

    private HttpStatusCode status;

    private final HttpHeaders headers;

    public RestClientObservation() {
        template = new RestTemplate();
        headers = new HttpHeaders();
        headers.add("Accept", "*/*");
        headers.add("content-type", "application/json");
    }

public T get(String uri, Class<T> type) {
    HttpEntity<String> requestEntity = new HttpEntity<>("", headers);
    ResponseEntity <T> responseEntity = template.exchange(server + uri, org.springframework.http.HttpMethod.GET, requestEntity, type);
    status = responseEntity.getStatusCode();
    return responseEntity.getBody();
}

public T post(String uri, V data, Class<T> type) {
    HttpEntity<V> requestEntity = new HttpEntity<>(data, headers);
    ResponseEntity <T> responseEntity = template.exchange(server + uri, org.springframework.http.HttpMethod.POST, requestEntity, type);
    status = responseEntity.getStatusCode();
    return responseEntity.getBody();
}

public T put(String uri, RequestObservationDTO observation, Class<T> type) {
    HttpEntity<String> requestEntity = new HttpEntity<>("", headers);
    ResponseEntity <T> responseEntity = template.exchange(server + uri, org.springframework.http.HttpMethod.PATCH, requestEntity, type);
    status = responseEntity.getStatusCode();
    return responseEntity.getBody();
}

public T delete(String uri, Class<T> type) {
    HttpEntity<String> requestEntity = new HttpEntity<>("", headers);
    ResponseEntity <T> responseEntity = template.exchange(server + uri, org.springframework.http.HttpMethod.DELETE, requestEntity, type);
    status = responseEntity.getStatusCode();
    return responseEntity.getBody();

}
}


