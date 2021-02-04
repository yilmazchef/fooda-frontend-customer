package be.fooda.frontend.service;

import be.fooda.frontend.model.store.Store;
import be.fooda.frontend.model.store.StoreMenuItem;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
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

    private static final String GET_ALL = "get_all_stores";
    private static final String SEARCH_BY_STORE_NAME = "search_by_store_name";
    private static final String SEARCH = "search";
    private static final String STORE_EXISTS_BY_ID = "store_exists_by_id";
    private static final String STORE_EXISTS = "store_exists";
    private static final String SEARCH_BY_ADDRESS = "search_by_address";
    private static final String FILTER_BY_DELIVERY_COSTS = "filter_by_delivery_costs";
    private static final String FILTER_BY_DELIVERY_LOCATIONS = "filter_by_delivery_locations";
    private static final String FILTER_BY_DELIVERY_DURATION = "filter_by_delivery_duration";
    private static final String SEARCH_BY_MENU_ITEM_NAME = "search_by_menu_item_name";
    private static final String SEARCH_BY_CUISINE = "search_by_cuisine";
    private static final String GET_BY_MENU_ITEMS_PRICE = "get_by_menu_item_price";
    private static final String SEARCH_BY_DIETERY = "search_by_dietary";
    private static final String ADD_STORE = "add_store";
    private static final String ADD_MENU_ITEM = "add_menu_item";
    private static final String REMOVE_MENU_ITEM = "remove_menu_item";
    private static final String DELETE_STORE = "delete_store";
    private static final String SEARCH_BY_RANGE = "search_by_range";

    public ResponseEntity getAllStores(int pageNo, int pageSize) {
        final String completeUrl = baseUrl + GET_ALL + "?pageNo={pageNo}&pageSize={pageSize}";
        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("pageNo", pageNo);
        queryParams.put("pageSize", pageSize);
        return restTemplate.exchange(completeUrl, HttpMethod.GET, HttpEntity.EMPTY, Store[].class, queryParams);
    }

    public ResponseEntity searchByStoreName(String name, int pageNo, int pageSize) {
        final String completeUrl = baseUrl + SEARCH_BY_STORE_NAME + "?name={name}&pageNo={pageNo}&pageSize={pageSize}";
        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("name", name);
        queryParams.put("pageNo", pageNo);
        queryParams.put("pageSize", pageSize);
        return restTemplate.exchange(completeUrl, HttpMethod.GET, HttpEntity.EMPTY, Store[].class, queryParams);
    }

    public ResponseEntity search(String keyword) {
        final String completeUrl = baseUrl + SEARCH + "?keyword={keyword}";
        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("keyword", keyword);
        return restTemplate.exchange(completeUrl, HttpMethod.GET, HttpEntity.EMPTY, Store[].class, queryParams);
    }

    public ResponseEntity searchByRange(String keyword) {
        final String completeUrl = baseUrl + SEARCH_BY_RANGE + "?keyword={keyword}";
        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("keyword", keyword);

        return restTemplate.exchange(completeUrl, HttpMethod.GET, HttpEntity.EMPTY, Store[].class, queryParams);
    }


    public ResponseEntity storeExistsById(Long id) {
        final String completeUrl = baseUrl + STORE_EXISTS_BY_ID + "?id={id}";
        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("id", id);
        return restTemplate.exchange(completeUrl, HttpMethod.GET, HttpEntity.EMPTY, String.class, queryParams);
    }

    public ResponseEntity storeExists(Store store) {
        final String completeUrl = baseUrl + STORE_EXISTS;
        return restTemplate.exchange(completeUrl, HttpMethod.GET, new HttpEntity<>(store), String.class);
    }

    public ResponseEntity searchByAddress(String postcode, String municipality, int pageNo, int pageSize) {
        final String completeUrl = baseUrl + SEARCH_BY_ADDRESS + "?postcode={postcode}&municipality={municipality}&pageNo={pageNo}&pageSize={pageSize}";
        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("postcode", postcode);
        queryParams.put("municipality", municipality);
        queryParams.put("pageNo", pageNo);
        queryParams.put("pageSize", pageSize);

        return restTemplate.exchange(completeUrl, HttpMethod.GET, HttpEntity.EMPTY, Store[].class, queryParams);
    }

    public ResponseEntity filterByDeliveryCosts(BigDecimal minPrice, BigDecimal maxPrice, int pageNo, int pageSize) {
        final String completeUrl = baseUrl + FILTER_BY_DELIVERY_COSTS + "?minPrice={minPrice}&maxPrice={maxPrice}&pageNo={pageNo}&pageSize={pageSize}";
        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("maxPrice", maxPrice);
        queryParams.put("minPrice", minPrice);
        queryParams.put("pageNo", pageNo);
        queryParams.put("pageSize", pageSize);
        return restTemplate.exchange(completeUrl, HttpMethod.GET, HttpEntity.EMPTY, Store[].class, queryParams);
    }

    public ResponseEntity filterByDeliveryLocations(Set<String> postcode, int pageNo, int pageSize) {
        final String completeUrl = baseUrl + FILTER_BY_DELIVERY_LOCATIONS + " ?postcode={postcodes}&pageNo={pageNo}&pageSize={pageSize}";
        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("postcode", postcode);
        queryParams.put("pageNo", pageNo);
        queryParams.put("pageSize", pageSize);
        return restTemplate.exchange(completeUrl, HttpMethod.GET, HttpEntity.EMPTY, Store[].class, queryParams);

    }

    public ResponseEntity filterByDeliveryDuration(Double minDuration, Double maxDuration, Integer pageNo, Integer pageSize) {
        final String completeUrl = baseUrl + FILTER_BY_DELIVERY_DURATION + " ?minDuration={minDuration}&maxDuration={maxDuration}&pageNo={pageNo}&pageSize={pageSize";
        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("minDuration", minDuration);
        queryParams.put("maxDuration", maxDuration);
        queryParams.put("pageNo", pageNo);
        queryParams.put("pageSize", pageSize);
        return restTemplate.exchange(completeUrl, HttpMethod.GET, HttpEntity.EMPTY, Store[].class, queryParams);
    }

    public ResponseEntity searchByMenuItemsName(String menuItem, Integer pageNo, Integer pageSize) {
        final String completeUrl = baseUrl + SEARCH_BY_MENU_ITEM_NAME + "?menuItem={menuItem}&pageNo={pageNo}&pageSize={pageSize}";
        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("menuItem", menuItem);
        queryParams.put("pageNo", pageNo);
        queryParams.put("pageSize", pageSize);
        return restTemplate.exchange(completeUrl, HttpMethod.GET, HttpEntity.EMPTY, Store[].class, queryParams);
    }

    public ResponseEntity searchByCuisine(String cuisine, Integer pageNo, Integer pageSize) {
        final String completeUrl = baseUrl + SEARCH_BY_CUISINE + "?cuisine={cuisine}&pageNo={pageNo}&pageSize={pageSize}";
        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("cuisine", cuisine);
        queryParams.put("pageNo", pageNo);
        queryParams.put("pageSize", pageSize);
        return restTemplate.exchange(completeUrl, HttpMethod.GET, HttpEntity.EMPTY, Store[].class, queryParams);
    }

    public ResponseEntity getByMenuItemsPrice(BigDecimal maxPrice) {
        final String completeUrl = baseUrl + GET_BY_MENU_ITEMS_PRICE + "?maxPrice={maxPrice}";
        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("maxPrice", maxPrice);
        return restTemplate.exchange(completeUrl, HttpMethod.GET, HttpEntity.EMPTY, Store[].class, queryParams);
    }

    public ResponseEntity searchByDietary(String dietary, Integer pageNo, Integer pageSize) {
        final String completeUrl = baseUrl + SEARCH_BY_DIETERY + "?dietary={dietary}&pageNo={pageNo}&pageSize={pageSize}";
        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("dietary", dietary);
        queryParams.put("pageNo", pageNo);
        queryParams.put("pageSize", pageSize);
        return restTemplate.exchange(completeUrl, HttpMethod.GET, HttpEntity.EMPTY, Store[].class, queryParams);
    }

    public ResponseEntity addStore(Store store) {
        final String completeUrl = baseUrl + ADD_STORE;
        return restTemplate.exchange(completeUrl, HttpMethod.POST, new HttpEntity<>(store), String.class);
    }

    public ResponseEntity addMenuItem(Long storeId, StoreMenuItem menuItem) {
        final String completeUrl = baseUrl + ADD_MENU_ITEM + "?storeId={storeId}";
        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("storeId", storeId);
        return restTemplate.exchange(completeUrl, HttpMethod.PATCH, new HttpEntity<>(menuItem), String.class, queryParams);
    }

    public ResponseEntity removeMenuItem(Long menuItemId) {
        final String completeUrl = baseUrl + REMOVE_MENU_ITEM + "?menuItemId={menuItemId}";
        return restTemplate.exchange(completeUrl, HttpMethod.DELETE, HttpEntity.EMPTY, String.class, menuItemId);
    }

    public ResponseEntity deleteStoreById(Long id) {
        final String completeUrl = baseUrl + DELETE_STORE + "?id={id}";
        return restTemplate.exchange(completeUrl, HttpMethod.DELETE, HttpEntity.EMPTY, String.class, id);
    }
}
