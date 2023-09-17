package com.example.utils;


import com.example.dto.utilisateur.RequestUtilisateurDTO;
import com.example.dto.utilisateur.ResponseUtilisateurDTO;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

public class RestClient<T, V> {

    private final String server = "http://localhost:8082/";

    private final RestTemplate template;

    private HttpStatusCode status;

    private final HttpHeaders headers;


    public RestClient() {
        template = new RestTemplate();
        headers = new HttpHeaders();
        headers.add("Accept", "*/*");
        headers.add("content-type", "application/json");
    }

    public T get(String uri, Class<T> type) {
        HttpEntity<String> requestEntity = new HttpEntity<>("", headers);

        ResponseEntity<T> responseEntity = template.exchange(server + uri, HttpMethod.GET, requestEntity, type);

        status = responseEntity.getStatusCode();
        return responseEntity.getBody();
    }

    public T post(String uri, V data, Class<T> type) {
        HttpEntity<V> requestEntity = new HttpEntity<>(data, headers);
        ResponseEntity<T> responseEntity = template.exchange(server + uri, HttpMethod.POST, requestEntity, type);
        status = responseEntity.getStatusCode();
        return responseEntity.getBody();
    }
    public T delete(String uri, Class<T> type) {
        HttpEntity<String> requestEntity = new HttpEntity<>("", headers);

        ResponseEntity<T> responseEntity = template.exchange(server + uri, HttpMethod.DELETE, requestEntity, type);

        status = responseEntity.getStatusCode();
        return responseEntity.getBody();
     }


    public Object put(String uri, RequestUtilisateurDTO requestUtilisateurDTO, Class<ResponseUtilisateurDTO> responseUtilisateurDTOClass) {
        HttpEntity<RequestUtilisateurDTO> requestEntity = new HttpEntity<>(requestUtilisateurDTO, headers);
        ResponseEntity<ResponseUtilisateurDTO> responseEntity = template.exchange(server + uri, HttpMethod.PUT, requestEntity, responseUtilisateurDTOClass);
        status = responseEntity.getStatusCode();
        return responseEntity.getBody();
    }
}
