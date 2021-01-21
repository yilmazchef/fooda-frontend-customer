package be.fooda.frontend.service;

import be.fooda.frontend.models.product.Product;
import be.fooda.frontend.models.store.Store;
import be.fooda.frontend.models.store.StoreMenuItem;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Service
public class StoreService {
    private final RestTemplate restTemplate;

    @Value("${fooda.store.service.url}")
    private String baseUrl;

    public StoreService(RestTemplate restTemplate) {
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
        final String completeUrl = baseUrl + "get_all_stores?pageNo={pageNo}&pageSize={pageSize}";
        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("pageNo", pageNo);
        queryParams.put("pageSize", pageSize);
        return restTemplate.exchange(completeUrl, HttpMethod.GET, HttpEntity.EMPTY, Store[].class, queryParams);
    }

    public ResponseEntity searchByStoreName(String name,int pageNo, int pageSize){
        final String completeUrl = baseUrl + "search_by_store_name?name={name}&pageNo={pageNo}&pageSize={pageSize}";
        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("name",name);
        queryParams.put("pageNo", pageNo);
        queryParams.put("pageSize", pageSize);
        return restTemplate.exchange(completeUrl, HttpMethod.GET, HttpEntity.EMPTY, Store[].class, queryParams);
    }
    public ResponseEntity search(String name,int pageNo, int pageSize){
        final String completeUrl = baseUrl + "search?pageNo={pageNo}&pageSize={pageSize}";
        return restTemplate.exchange(completeUrl, HttpMethod.GET, HttpEntity.EMPTY, Store[].class);
    }
    public ResponseEntity storeExistsById(Long id){
        final String completeUrl = baseUrl + "store_exists_by-id?id={id}";
        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("id",id);
        return restTemplate.exchange(completeUrl, HttpMethod.GET, HttpEntity.EMPTY, String.class, queryParams);
    }
    public ResponseEntity storeExists(Store store){
        final String completeUrl = baseUrl + "store_Exists";
        return restTemplate.exchange(completeUrl, HttpMethod.GET, new HttpEntity<>(store), String.class);
    }
    public ResponseEntity searchByAddress(String postcode,String municipality,int pageNo, int pageSize){
        final String completeUrl = baseUrl + "search_by-address?postcode={postcode}&municipality={municipality}&pageNo={pageNo}&pageSize={pageSize}";
        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("postcode",postcode);
        queryParams.put("municipality",municipality);
        queryParams.put("pageNo", pageNo);
        queryParams.put("pageSize", pageSize);

        return restTemplate.exchange(completeUrl, HttpMethod.GET, HttpEntity.EMPTY, Store[].class, queryParams);
    }
    public ResponseEntity filterByDeliveryCosts(BigDecimal minPrice,BigDecimal maxPrice,int pageNo, int pageSize) {
        final String completeUrl = baseUrl + "filter_by_delivery_costs?minPrice={minPrice}&maxPrice={maxPrice}&pageNo={pageNo}&pageSize={pageSize}";
        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("maxPrice", maxPrice);
        queryParams.put("minPrice", minPrice);
        queryParams.put("pageNo", pageNo);
        queryParams.put("pageSize", pageSize);
        return restTemplate.exchange(completeUrl, HttpMethod.GET, HttpEntity.EMPTY, Store[].class, queryParams);
    }
//todo/ahmet
    public ResponseEntity filterByDeliveryLocations(Set<String> postcode, int pageNo,int pageSize ){
        final String completeUrl = baseUrl + " filter_by_deliveryLocation?postcode=[{postcode}]&pageNo={pageNo}&pageSize={pageSize}";
        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("postcode", postcode);
        queryParams.put("pageNo", pageNo);
        queryParams.put("pageSize", pageSize);
        return restTemplate.exchange(completeUrl, HttpMethod.GET, HttpEntity.EMPTY, Store[].class, queryParams);

    }

    public ResponseEntity filterByDeliveryDuration(Double minDuration, Double maxDuration, Integer pageNo, Integer pageSize){
        final String completeUrl = baseUrl + " filter_by_delivery_duration?minDuration={minDuration}&minDuration={minDuration}&pageNo={pageNo}&pageSize={pageSize";
        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("minDuration", minDuration);
        queryParams.put("maxDuration", maxDuration);
        queryParams.put("pageNo", pageNo);
        queryParams.put("pageSize", pageSize);
        return restTemplate.exchange(completeUrl, HttpMethod.GET, HttpEntity.EMPTY, Store[].class, queryParams);
    }

    public ResponseEntity searchByMenuItemsName( String menuItem,  Integer pageNo,  Integer pageSize){
        final String completeUrl = baseUrl +"search_by_menuItem_name?menuItem={menuItem}&pageNo={pageNo}&pageSize={pageSize";
        Map<String, Object> queryParams = new HashMap<>();

        queryParams.put("menuItem", menuItem);
        queryParams.put("pageNo", pageNo);
        queryParams.put("pageSize", pageSize);
        return restTemplate.exchange(completeUrl, HttpMethod.GET, HttpEntity.EMPTY, Store[].class, queryParams);
    }

    public ResponseEntity searchByCuisine(String cuisine,Integer pageNo,  Integer pageSize){
        final String completeUrl = baseUrl + "search_by_cuisine?cuisine={cuisine}&pageNo={pageNo}&pageSize={pageSize}";
        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("cuisine", cuisine);
        queryParams.put("pageNo", pageNo);
        queryParams.put("pageSize", pageSize);
        return restTemplate.exchange(completeUrl, HttpMethod.GET, HttpEntity.EMPTY, Store[].class, queryParams);
    }
    public ResponseEntity getByMenuItemsPrice(BigDecimal maxPrice) {
        final String completeUrl = baseUrl + "get_by_menuItems_price?maxPrice={maxPrice}";
        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("maxPrice", maxPrice);
        return restTemplate.exchange(completeUrl, HttpMethod.GET, HttpEntity.EMPTY, Store[].class, queryParams);
    }

    public ResponseEntity searchByDietary(String dietary, Integer pageNo, Integer pageSize) {
        final String completeUrl = baseUrl + "search_by_dietary?dietary={dietary}&pageNo={pageNo}&pageSize={pageSize}";
        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("dietary", dietary);
        queryParams.put("pageNo", pageNo);
        queryParams.put("pageSize", pageSize);
        return restTemplate.exchange(completeUrl, HttpMethod.GET, HttpEntity.EMPTY, Store[].class, queryParams);
    }

    public ResponseEntity addStore(Store store) {
        final String completeUrl = baseUrl + "add_store";
        return restTemplate.exchange(completeUrl, HttpMethod.POST, new HttpEntity<>(store), String.class);
    }

    public ResponseEntity addMenuItem(Long storeId, StoreMenuItem menuItem) {
        final String completeUrl = baseUrl + "add_menuItem?storeId=" + storeId;
        return restTemplate.exchange(completeUrl, HttpMethod.PATCH, new HttpEntity<>(menuItem), String.class);
    }

    public ResponseEntity removeMenuItem(Long menuItemId) {
        final String completeUrl = baseUrl + "remove_menuItem?menuItemId={menuItemId}";
        return restTemplate.exchange(completeUrl, HttpMethod.DELETE, HttpEntity.EMPTY, String.class, menuItemId);
    }

    public ResponseEntity deleteStoreById(Long id) {
            final String completeUrl = baseUrl + "delete_store?id={id}";
            return restTemplate.exchange(completeUrl, HttpMethod.DELETE, HttpEntity.EMPTY, String.class, id);
    }
}
