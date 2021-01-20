package be.fooda.frontend.service;

import be.fooda.frontend.models.product.Product;
import be.fooda.frontend.models.store.store;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class storeService {
    private final RestTemplate restTemplate;

    @Value("${fooda.store.service.url}")
    private String baseUrl;

    public storeService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    /*
    public ResponseEntity getAll(int pageNo, int pageSize) {
        final String completeUrl = baseUrl + "getAllProducts?pageNo={pageNo}&pageSize={pageSize}";
        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("pageNo", pageNo);
        queryParams.put("pageSize", pageSize);
        // 1st param -> COMPLETE URL OF THE ENDPOINT -> http://localhost:8001/api/v1/product/getAllProducts?pageNo={pageNo}&pageSize={pageSize}
        // 2nd param -> GET, PUT, POST, PATCH ..
        // 3rd param -> request body -> if there is @RequestBody you set body as 3rd param, if not set it to EMPTY
        // 4th param -> return type of the body .. if return is list : Product[].class, if single item : Product.class, if it is only http message :  String.class
        // 5th param -> not mandatory, it is query params .. if you @RequestParam then you create a map with Map<String, Object>, then you put the map as the 5th parameter..
        return restTemplate.exchange(completeUrl, HttpMethod.GET, HttpEntity.EMPTY, Product[].class, queryParams);
    }
     */

    public ResponseEntity getAllStores(int pageNo, int pageSize) {
        final String completeUrl = baseUrl + "get_All?pageNo={pageNo}&pageSize={pageSize}";
        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("pageNo", pageNo);
        queryParams.put("pageSize", pageSize);
        return restTemplate.exchange(completeUrl, HttpMethod.GET, HttpEntity.EMPTY, Product[].class, queryParams);
    }

    public ResponseEntity searchByStoreName(String name,int pageNo, int pageSize){
        final String completeUrl = baseUrl + "search_By_Store_Name?name={name}&pageNo={pageNo}&pageSize={pageSize}";
        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("name",name);
        queryParams.put("pageNo", pageNo);
        queryParams.put("pageSize", pageSize);
        return restTemplate.exchange(completeUrl, HttpMethod.GET, HttpEntity.EMPTY, Product[].class, queryParams);
    }
    public ResponseEntity search(String name,int pageNo, int pageSize){
        final String completeUrl = baseUrl + "search";
        return restTemplate.exchange(completeUrl, HttpMethod.GET, HttpEntity.EMPTY, Product[].class);
    }
    public ResponseEntity storeExistsById(Long id){
        final String completeUrl = baseUrl + "store_Exists_By-Id?id={id}";
        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("id",id);
        return restTemplate.exchange(completeUrl, HttpMethod.GET, HttpEntity.EMPTY, String.class, queryParams);
    }












}
