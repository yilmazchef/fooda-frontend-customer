package be.fooda.frontend.service;

import be.fooda.frontend.models.product.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ProductService {

    private final RestTemplate restTemplate;
    private static final String baseUrl = "http://localhost:8001/api/v1/product/";

    public ProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ResponseEntity<Product[]> getAll(int page, int size) {
        final String completeUrl = baseUrl + "getAllProducts?page={page}&size={size}";
        return restTemplate.getForEntity(completeUrl, Product[].class, page, size);
    }
}
