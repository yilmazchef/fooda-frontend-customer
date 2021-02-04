package be.fooda.frontend.service;

import be.fooda.frontend.model.auth.Auth;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AuthService {

    private final RestTemplate restTemplate;

    @Value("${fooda.auth.service.url}")
    private String baseUrl;

    public AuthService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ResponseEntity authorize (Auth auth){
        final String completeUrl = baseUrl;
        return restTemplate.exchange(completeUrl, HttpMethod.POST, new HttpEntity<>(auth),String.class);
    }
}
