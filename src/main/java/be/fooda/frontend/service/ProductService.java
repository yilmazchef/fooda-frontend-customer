package be.fooda.frontend.service;

import be.fooda.frontend.models.product.Product;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ProductService {

    private final RestTemplate restTemplate;

    @Value("${fooda.product.service.url}")
    private String baseUrl;

    public ProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

//    @HystrixCommand(fallbackMethod = "fallBackGetAll")
    public ResponseEntity getAll(int page, int size) {
        final String completeUrl = baseUrl + "getAllProducts?page={page}&size={size}";
        return restTemplate.getForEntity(completeUrl, Product[].class, page, size);
    }

    public ResponseEntity fallBackGetAll() {
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body("SERVER_DOWN");
    }
}
