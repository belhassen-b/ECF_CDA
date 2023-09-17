package com.example.observation.tool;

import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;


public class RestClient<T,V> {
    private String urlApiUtilisateur;

    private RestTemplate template;
    private HttpHeaders httpHeaders;
    private HttpStatus httpStatus;

    public RestClient() {
    }

    public RestClient(String urlApiUtilisateur) {
        template = new RestTemplate();
        httpHeaders = new HttpHeaders();
        httpHeaders.add("Accept", "*/*");
        httpHeaders.add("content-type", "application/json");
        this.urlApiUtilisateur = urlApiUtilisateur;
    }

    public T get(String uri, Class<T> type) {
        HttpEntity<String> requestEntity = new HttpEntity<>("", httpHeaders);
        ResponseEntity<T> response = template.exchange(urlApiUtilisateur+uri, HttpMethod.GET, requestEntity, type);
        return response.getBody();
    }

    public boolean testToken(String token, Class<T> type) {
        httpHeaders.add("Authorization", token);
        HttpEntity<String> requestEntity = new HttpEntity<>("", httpHeaders);
        String urlApiToken = "http://localhost:8081/api/test";
        ResponseEntity<T> response = template.exchange(urlApiToken, HttpMethod.GET, requestEntity, type);
        System.out.println(response);
        if(response.hasBody()) {
            return response.getStatusCode().is2xxSuccessful();
        }
        return false;
    }

    public T post(String uri, V data, Class<T> type) {
        HttpEntity<V> requestEntity = new HttpEntity<>(data, httpHeaders);
        ResponseEntity<T> responseEntity = template.exchange(urlApiUtilisateur+uri, HttpMethod.POST, requestEntity, type);
        httpStatus = (HttpStatus) responseEntity.getStatusCode();
        return responseEntity.getBody();
    }

    public T delete(String uri, Class<T> type) {
        HttpEntity<String> requestEntity = new HttpEntity<>("", httpHeaders);
        ResponseEntity<T> responseEntity = template.exchange(urlApiUtilisateur+uri, HttpMethod.DELETE, requestEntity, type);
        httpStatus = (HttpStatus) responseEntity.getStatusCode();
        return responseEntity.getBody();
    }
}