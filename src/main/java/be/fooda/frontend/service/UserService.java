package be.fooda.frontend.service;

import be.fooda.frontend.model.user.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {

    private final RestTemplate restTemplate;

    @Value("${fooda.user.service.url}")
    private String baseUrl;

    public UserService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ResponseEntity<String> sendSmsCode(String phone) {

        final String completeUrl = "https://fooda-backend-user.herokuapp.com/code?phone={phone}";
        Map<String, Object> params = new HashMap<>();
        params.put("phone", phone);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "true");

        return restTemplate.exchange(completeUrl, HttpMethod.GET, new HttpEntity<>(headers), String.class, params);
    }

    public ResponseEntity<String> validateSmsCode(String phone, String code) {
        final String completeUrl = "https://fooda-backend-user.herokuapp.com/validate?phone={phone}&code={code}";
        Map<String, Object> params = new HashMap<>();
        params.put("phone", phone);
        params.put("code", code);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "true");

        return restTemplate.exchange(completeUrl, HttpMethod.GET, new HttpEntity<>(headers), String.class, params);
    }

    public ResponseEntity validateSmsCodeForUpdate(String existingPhoneNumber, String newPhoneNumber,
                                                   String smsCodeFromExistingPhone, String smsCodeFromNewPhone) {
        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("existingPhoneNumber", existingPhoneNumber);
        queryParams.put("newPhoneNumber", newPhoneNumber);
        queryParams.put("smsCodeFromExistingPhone", smsCodeFromExistingPhone);
        queryParams.put("smsCodeFromNewPhone", smsCodeFromNewPhone);
        final String completeUrl = baseUrl + "validate_sms_code_for_update?" +
                "existingPhoneNumber={existingPhoneNumber}&newPhoneNumber={newPhoneNumber}&" +
                "smsCodeFromExistingPhone={smsCodeFromExistingPhone}&smsCodeFromNewPhone={smsCodeFromNewPhone}";
        return restTemplate.exchange(completeUrl, HttpMethod.GET, HttpEntity.EMPTY, String.class, queryParams);
    }

    public ResponseEntity existByUserId(Long id) {
        final String completeUrl = baseUrl + "exist_by_user_id?id={id}";
        return restTemplate.exchange(completeUrl, HttpMethod.GET, HttpEntity.EMPTY, String.class, id);
    }

    public ResponseEntity getUserById(Long id) {
        final String completeUrl = baseUrl + "get_user_by_id?id={id}";
        return restTemplate.exchange(completeUrl, HttpMethod.GET, HttpEntity.EMPTY, User.class, id);
    }

    public ResponseEntity getUserByUsername(String username) {
        final String completeUrl = baseUrl + "get_user_by_username?username={username}";
        return restTemplate.exchange(completeUrl, HttpMethod.GET, HttpEntity.EMPTY, User.class, username);
    }

    @PatchMapping("delete_user_by_username")
    public ResponseEntity deleteUserById(String username) {
        final String completeUrl = baseUrl + "delete_user_by_username?username={username}";
        return restTemplate.exchange(completeUrl, HttpMethod.DELETE, HttpEntity.EMPTY, String.class, username);
    }

}
