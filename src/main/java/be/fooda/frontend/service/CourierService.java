package be.fooda.frontend.service;

import be.fooda.frontend.model.courier.Courier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class CourierService {

    private final RestTemplate restTemplate;

    @Value("${fooda.courier.service.url}")
    private String baseUrl;

    public CourierService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ResponseEntity create(Courier courier) {
        final String completeUrl = baseUrl + "createCourier";
        return restTemplate.exchange(completeUrl, HttpMethod.POST, new HttpEntity<>(courier), String.class);

    }

    public ResponseEntity search(Set<String> keywords, int pageNo, int pageSize) {
        final String completeUrl = baseUrl + "search?keywords={keywords}&pageNo={pageNo}&pageSize={pageSize}";
        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("keywords", keywords);
        queryParams.put("pageNo", pageNo);
        queryParams.put("pageSize", pageSize);
        return restTemplate.exchange(completeUrl, HttpMethod.GET, HttpEntity.EMPTY, Courier[].class, queryParams);
    }

    public ResponseEntity searchByCourierName(String firstName, String familyName, int pageNo, int pageSize) {
        final String completeUrl = baseUrl + "searchByCourierName?firstName={firstName}&familyName={familyName}&pageNo={pageNo}&pageSize={pageSize}";
        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("firstName", firstName);
        queryParams.put("familyName", familyName);
        queryParams.put("pageNo", pageNo);
        queryParams.put("pageSize", pageSize);
        return restTemplate.exchange(completeUrl, HttpMethod.GET, HttpEntity.EMPTY, Courier[].class, queryParams);
    }

    public ResponseEntity searchCourierDateOfBirth(LocalDate dateOfBirth, int pageNo, int pageSize) {
        final String completeUrl = baseUrl + "searchCourierDateOfBirth?dateOfBirth={dateOfBirth}&pageNo={pageNo}&pageSize={pageSize}";
        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("dateOfBirth", dateOfBirth);
        queryParams.put("pageNo", pageNo);
        queryParams.put("pageSize", pageSize);
        return restTemplate.exchange(completeUrl, HttpMethod.GET, HttpEntity.EMPTY, Courier[].class, queryParams);
    }

    public ResponseEntity findCourierById(Long id) {
        final String completeUrl = baseUrl + "findCourierById?id={id}isActive={isActive}";
        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("id", id);
        return restTemplate.exchange(completeUrl, HttpMethod.GET, HttpEntity.EMPTY, Courier[].class, queryParams);
    }
    public ResponseEntity getAllCourier(int pageNo, int pageSize) {
        final String completeUrl = baseUrl + "getAllCourier?pageNo={pageNo}&pageSize={pageSize}";
        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("pageNo", pageNo);
        queryParams.put("pageSize", pageSize);
        return restTemplate.exchange(completeUrl, HttpMethod.GET, HttpEntity.EMPTY, Courier[].class, queryParams);
    }

    public ResponseEntity deleteCourier(Long id) {
        final String completeUrl = baseUrl + "deleteCourier/id=" + id;
        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("id", id);
        return restTemplate.exchange(completeUrl, HttpMethod.PATCH, HttpEntity.EMPTY, String.class,queryParams);
    }

    public ResponseEntity existById(Long id) {
        final String completeUrl = baseUrl + "existCourierById?id={id}&isActive={isActive}";
        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("id", id);
        return restTemplate.exchange(completeUrl, HttpMethod.GET,HttpEntity.EMPTY,String.class, queryParams);
    }
}
