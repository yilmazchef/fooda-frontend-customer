package be.fooda.frontend.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService {

    private final RestTemplate restTemplate;

    @Value("${fooda.user.service.url}")
    private String baseUrl;

    public UserService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ResponseEntity<String> sendSmsCode(String phoneNumber) {
        final String completeUrl = baseUrl + "send_sms_code?phoneNumber={phoneNumber}}";
        return restTemplate.getForEntity(completeUrl, String.class, phoneNumber);
    }
}
