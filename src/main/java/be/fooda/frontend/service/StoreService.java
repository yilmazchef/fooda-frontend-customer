package be.fooda.frontend.service;

import be.fooda.frontend.model.store.Product;
import be.fooda.frontend.model.store.Store;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

@Service
public class StoreService {

    private final RestTemplate restTemplate;

    //    @Value("${fooda.store.service.url}")
    private final String baseUrl = "https://fooda-backend-store.herokuapp.com/";

    public StoreService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    private static final String GET_ALL = "get_all_stores";
    private static final String SEARCH_BY_STORE_NAME = "search_by_store_name";
    private static final String SEARCH = "search";
    private static final String STORE_EXISTS_BY_ID = "store_exists_by_id";
    private static final String STORE_EXISTS = "store_exists";
    private static final String SEARCH_BY_ADDRESS = "search_by_address";
    private static final String FILTER_BY_DELIVERY_COSTS = "filter_by_delivery_costs";
    private static final String FILTER_BY_DELIVERY_LOCATIONS = "filter_by_delivery_locations";
    private static final String FILTER_BY_DELIVERY_DURATION = "filter_by_delivery_duration";
    private static final String SEARCH_BY_PRODUCT_NAME = "search_by_product_name";
    private static final String SEARCH_BY_CUISINE = "search_by_cuisine";
    private static final String GET_BY_MENU_ITEMS_PRICE = "get_by_menu_item_price";
    private static final String SEARCH_BY_DIETERY = "search_by_dietary";
    private static final String ADD_STORE = "add_store";
    private static final String ADD_PRODUCT = "add_product";
    private static final String REMOVE_PRODUCT = "remove_product";
    private static final String DELETE_STORE = "delete_store";
    private static final String SEARCH_BY_RANGE = "search_by_range";
    private static final String GET_PRODUCTS_BY_STORE_ID = "get_all_products_by_store_id";

    private HttpHeaders headers() {
        HttpHeaders authHeaders = new HttpHeaders();
        authHeaders.add("Authorization", "true");
        return authHeaders;
    }

    public ResponseEntity getAllStores(int pageNo, int pageSize) {
        final String completeUrl = baseUrl + GET_ALL + "?pageNo={pageNo}&pageSize={pageSize}";
        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("pageNo", pageNo);
        queryParams.put("pageSize", pageSize);
        return restTemplate.exchange(completeUrl, HttpMethod.GET, new HttpEntity<>(headers()), Store[].class, queryParams);
    }

    public ResponseEntity searchByStoreName(String name, int pageNo, int pageSize) {
        final String completeUrl = baseUrl + SEARCH_BY_STORE_NAME + "?name={name}&pageNo={pageNo}&pageSize={pageSize}";
        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("name", name);
        queryParams.put("pageNo", pageNo);
        queryParams.put("pageSize", pageSize);
        return restTemplate.exchange(completeUrl, HttpMethod.GET, new HttpEntity<>(headers()), Store[].class, queryParams);
    }

    public ResponseEntity search(String keyword) {
        final String completeUrl = baseUrl + SEARCH + "?keyword={keyword}";
        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("keyword", keyword);
        return restTemplate.exchange(completeUrl, HttpMethod.GET, new HttpEntity<>(headers()), Store[].class, queryParams);
    }

    public ResponseEntity searchByRange(String keyword) {
        final String completeUrl = baseUrl + SEARCH_BY_RANGE + "?keyword={keyword}";
        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("keyword", keyword);

        return restTemplate.exchange(completeUrl, HttpMethod.GET, new HttpEntity<>(headers()), Store[].class, queryParams);
    }


    public ResponseEntity storeExistsById(UUID id) {
        final String completeUrl = baseUrl + STORE_EXISTS_BY_ID + "?id={id}";
        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("id", id);
        return restTemplate.exchange(completeUrl, HttpMethod.GET, new HttpEntity<>(headers()), String.class, queryParams);
    }

    public ResponseEntity storeExists(Store store) {
        final String completeUrl = baseUrl + STORE_EXISTS;
        return restTemplate.exchange(completeUrl, HttpMethod.GET, new HttpEntity<>(store, headers()), String.class);
    }

    public ResponseEntity searchByAddress(String postcode, String municipality, int pageNo, int pageSize) {
        final String completeUrl = baseUrl + SEARCH_BY_ADDRESS + "?postcode={postcode}&municipality={municipality}&pageNo={pageNo}&pageSize={pageSize}";
        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("postcode", postcode);
        queryParams.put("municipality", municipality);
        queryParams.put("pageNo", pageNo);
        queryParams.put("pageSize", pageSize);

        return restTemplate.exchange(completeUrl, HttpMethod.GET, new HttpEntity<>(headers()), Store[].class, queryParams);
    }

    public ResponseEntity filterByDeliveryCosts(BigDecimal minPrice, BigDecimal maxPrice, int pageNo, int pageSize) {
        final String completeUrl = baseUrl + FILTER_BY_DELIVERY_COSTS + "?minPrice={minPrice}&maxPrice={maxPrice}&pageNo={pageNo}&pageSize={pageSize}";
        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("maxPrice", maxPrice);
        queryParams.put("minPrice", minPrice);
        queryParams.put("pageNo", pageNo);
        queryParams.put("pageSize", pageSize);
        return restTemplate.exchange(completeUrl, HttpMethod.GET, new HttpEntity<>(headers()), Store[].class, queryParams);
    }

    public ResponseEntity filterByDeliveryLocations(Set<String> postcode, int pageNo, int pageSize) {
        final String completeUrl = baseUrl + FILTER_BY_DELIVERY_LOCATIONS + " ?postcode={postcodes}&pageNo={pageNo}&pageSize={pageSize}";
        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("postcode", postcode);
        queryParams.put("pageNo", pageNo);
        queryParams.put("pageSize", pageSize);
        return restTemplate.exchange(completeUrl, HttpMethod.GET, new HttpEntity<>(headers()), Store[].class, queryParams);

    }

    public ResponseEntity filterByDeliveryDuration(Double minDuration, Double maxDuration, Integer pageNo, Integer pageSize) {
        final String completeUrl = baseUrl + FILTER_BY_DELIVERY_DURATION + " ?minDuration={minDuration}&maxDuration={maxDuration}&pageNo={pageNo}&pageSize={pageSize";
        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("minDuration", minDuration);
        queryParams.put("maxDuration", maxDuration);
        queryParams.put("pageNo", pageNo);
        queryParams.put("pageSize", pageSize);
        return restTemplate.exchange(completeUrl, HttpMethod.GET, new HttpEntity<>(headers()), Store[].class, queryParams);
    }

    public ResponseEntity searchByMenuItemsName(String productName, Integer pageNo, Integer pageSize) {
        final String completeUrl = baseUrl + SEARCH_BY_PRODUCT_NAME + "?menuItem={menuItem}&pageNo={pageNo}&pageSize={pageSize}";
        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("menuItem", productName);
        queryParams.put("pageNo", pageNo);
        queryParams.put("pageSize", pageSize);
        return restTemplate.exchange(completeUrl, HttpMethod.GET, new HttpEntity<>(headers()), Store[].class, queryParams);
    }

    public ResponseEntity searchByCuisine(String cuisine, Integer pageNo, Integer pageSize) {
        final String completeUrl = baseUrl + SEARCH_BY_CUISINE + "?cuisine={cuisine}&pageNo={pageNo}&pageSize={pageSize}";
        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("cuisine", cuisine);
        queryParams.put("pageNo", pageNo);
        queryParams.put("pageSize", pageSize);
        return restTemplate.exchange(completeUrl, HttpMethod.GET, new HttpEntity<>(headers()), Store[].class, queryParams);
    }

    public ResponseEntity getByMenuItemsPrice(BigDecimal maxPrice) {
        final String completeUrl = baseUrl + GET_BY_MENU_ITEMS_PRICE + "?maxPrice={maxPrice}";
        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("maxPrice", maxPrice);
        return restTemplate.exchange(completeUrl, HttpMethod.GET, new HttpEntity<>(headers()), Store[].class, queryParams);
    }

    public ResponseEntity searchByDietary(String dietary, Integer pageNo, Integer pageSize) {
        final String completeUrl = baseUrl + SEARCH_BY_DIETERY + "?dietary={dietary}&pageNo={pageNo}&pageSize={pageSize}";
        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("dietary", dietary);
        queryParams.put("pageNo", pageNo);
        queryParams.put("pageSize", pageSize);
        return restTemplate.exchange(completeUrl, HttpMethod.GET, new HttpEntity<>(headers()), Store[].class, queryParams);
    }

    public ResponseEntity addStore(Store store) {
        final String completeUrl = baseUrl + ADD_STORE;
        return restTemplate.exchange(completeUrl, HttpMethod.POST, new HttpEntity<>(store), String.class);
    }

    public ResponseEntity addMenuItem(UUID storeId, Product product) {
        final String completeUrl = baseUrl + ADD_PRODUCT + "?storeId={storeId}";
        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("storeId", storeId);
        return restTemplate.exchange(completeUrl, HttpMethod.PATCH, new HttpEntity<>(product), String.class, queryParams);
    }

    public ResponseEntity removeMenuItem(UUID menuItemId) {
        final String completeUrl = baseUrl + REMOVE_PRODUCT + "?menuItemId={menuItemId}";
        return restTemplate.exchange(completeUrl, HttpMethod.DELETE, new HttpEntity<>(headers()), String.class, menuItemId);
    }

    public ResponseEntity deleteStoreById(UUID id) {
        final String completeUrl = baseUrl + DELETE_STORE + "?id={id}";
        return restTemplate.exchange(completeUrl, HttpMethod.DELETE, new HttpEntity<>(headers()), String.class, id);
    }
}
