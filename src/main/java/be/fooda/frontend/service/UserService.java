package be.fooda.frontend.service;

import be.fooda.frontend.model.user.User;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {

    private final RestTemplate restTemplate;

    //    @Value("${fooda.user.service.url}")
    private final String baseUrl = "https://fooda-backend-user.herokuapp.com/";

    public UserService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    private HttpHeaders headers() {
        HttpHeaders authHeaders = new HttpHeaders();
        authHeaders.add("Authorization", "true");
        return authHeaders;
    }

    public ResponseEntity<String> sendSmsCode(String phone) {
        final String completeUrl = baseUrl + "code?phone={phone}";
        Map<String, Object> params = new HashMap<>();
        params.put("phone", phone);

        return restTemplate.exchange(completeUrl, HttpMethod.GET, new HttpEntity<>(headers()), String.class, params);
    }

    public ResponseEntity<String> validateSmsCode(String phone, String code) {
        final String completeUrl = baseUrl + "validate?phone={phone}&code={code}";
        Map<String, Object> params = new HashMap<>();
        params.put("phone", phone);
        params.put("code", code);

        return restTemplate.exchange(completeUrl, HttpMethod.GET, new HttpEntity<>(headers()), String.class, params);
    }

    public ResponseEntity<String> loginWithPassword(String phone, String password) {
        final String completeUrl = baseUrl + "login?phone={phone}&password={password}";
        Map<String, Object> params = new HashMap<>();
        params.put("phone", phone);
        params.put("password", password);

        return restTemplate.exchange(completeUrl, HttpMethod.GET, new HttpEntity<>(headers()), String.class, params);
    }

    public ResponseEntity existByUserId(Long id) {
        final String completeUrl = baseUrl + "exists?id={id}";
        Map<String, Object> params = new HashMap<>();
        params.put("id", id);
        return restTemplate.exchange(completeUrl, HttpMethod.GET, new HttpEntity<>(headers()), String.class, params);
    }

    public ResponseEntity getUserById(Long id) {
        final String completeUrl = baseUrl + "get_by_id?id={id}";
        Map<String, Object> params = new HashMap<>();
        params.put("id", id);
        return restTemplate.exchange(completeUrl, HttpMethod.GET, new HttpEntity<>(headers()), User.class, params);
    }

    public ResponseEntity getUserByUsername(String username) {
        final String completeUrl = baseUrl + "get_by_phone?phone={phone}";
        Map<String, Object> params = new HashMap<>();
        params.put("phone", username);
        return restTemplate.exchange(completeUrl, HttpMethod.GET, new HttpEntity<>(headers()), User.class, params);
    }
}
