package be.fooda.frontend.service;


import be.fooda.frontend.models.order.Order;
import be.fooda.frontend.models.product.Product;
import be.fooda.frontend.models.product.ProductCategory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service public class OrderService {
    private final RestTemplate restTemplate;

    @Value("${fooda.order.service.url}")
    private String baseUrl;

    public OrderService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ResponseEntity getAllOrders(int pageNo, int pageSize, boolean isActive) {
        final String completeUrl = baseUrl + "get_All_Orders?pageNo={pageNo}&pageSize={pageSize}&isActive={isActive}";
        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("pageNo", pageNo);
        queryParams.put("pageSize", pageSize);
        queryParams.put("isActive", isActive);

        // 1st param -> COMPLETE URL OF THE ENDPOINT -> http://localhost:8001/api/v1/product/getAllProducts?pageNo={pageNo}&pageSize={pageSize}
        // 2nd param -> GET, PUT, POST, PATCH ..
        // 3rd param -> request body -> if there is @RequestBody you set body as 3rd param, if not set it to EMPTY
        // 4th param -> return type of the body .. if return is list : Product[].class, if single item : Product.class, if it is only http message :  String.class
        // 5th param -> not mandatory, it is query params .. if you @RequestParam then you create a map with Map<String, Object>, then you put the map as the 5th parameter..
        return restTemplate.exchange(completeUrl, HttpMethod.GET, HttpEntity.EMPTY, Order[].class, queryParams);
    }

    public ResponseEntity getOrderById(long id, boolean isActive) {
        final String completeUrl = baseUrl + "get-order-by-id?id={id}&isActive={isActive}";
        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("id", id);
        queryParams.put("isActive", isActive);

        return restTemplate.exchange(completeUrl, HttpMethod.GET, HttpEntity.EMPTY, Order.class, queryParams);
    }
}
