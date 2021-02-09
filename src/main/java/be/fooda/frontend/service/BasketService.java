package be.fooda.frontend.service;

import be.fooda.frontend.model.basket.Product;
import be.fooda.frontend.model.basket.ProductQuantityUpdateRequest;
import be.fooda.frontend.model.basket.User;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class BasketService {

    private final RestTemplate restTemplate;

    //    @Value("${fooda.basket.service.url}")
    private final String baseUrl = "https://fooda-backend-basket.herokuapp.com/";

    public BasketService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    private HttpHeaders headers() {
        HttpHeaders authHeaders = new HttpHeaders();
        authHeaders.add("Authorization", "true");
        return authHeaders;
    }

    public ResponseEntity getAllProducts() {
        final String completeUrl = baseUrl + "product/all";
        Map<String, Object> queryParams = new HashMap<>();
        return restTemplate.exchange(completeUrl, HttpMethod.GET, new HttpEntity<>(headers()), Product[].class, queryParams);
    }

    public ResponseEntity getAllProducts(User user) {
        final String completeUrl = baseUrl + "/product/user/{eUserId}/session/{session}";
        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("eUserId", user.geteUserId());
        queryParams.put("session", user.getSession());
        return restTemplate.exchange(completeUrl, HttpMethod.GET, new HttpEntity<>(headers()), Product[].class, queryParams);
    }

    public ResponseEntity addProduct(Product request) {
        final String completeUrl = baseUrl + "product";
        Map<String, Object> queryParams = new HashMap<>();
        return restTemplate.exchange(completeUrl, HttpMethod.POST, new HttpEntity<>(request, headers()), String.class, queryParams);
    }

    public ResponseEntity updateQuantity(ProductQuantityUpdateRequest request) {
        final String completeUrl = baseUrl + "product/quantity";
        Map<String, Object> queryParams = new HashMap<>();
        return restTemplate.exchange(completeUrl, HttpMethod.PATCH, new HttpEntity<>(request, headers()), String.class, queryParams);
    }

}
