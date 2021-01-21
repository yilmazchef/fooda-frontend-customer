package be.fooda.frontend.service;

import be.fooda.frontend.models.DeliveryStatus;
import be.fooda.frontend.models.OrderStatus;
import be.fooda.frontend.models.delivery.Delivery;
import be.fooda.frontend.models.order.Order;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Service
public class DeliveryService {
    private final RestTemplate restTemplate;

    @Value("${fooda.delivery.service.url}")
    private String baseUrl;

    public DeliveryService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ResponseEntity getAllDeliveries(int pageNo, int pageSize, boolean isActive) {
        final String completeUrl = baseUrl + "get_all_deliveries?pageNo={pageNo}&pageSize={pageSize}&isActive={isActive}";
        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("pageNo", pageNo);
        queryParams.put("pageSize", pageSize);
        queryParams.put("isActive", isActive);
        return restTemplate.exchange(completeUrl, HttpMethod.GET, HttpEntity.EMPTY, Delivery[].class, queryParams);
    }

    public ResponseEntity getDeliveryById(long id, boolean isActive) {
        final String completeUrl = baseUrl + "get_delivery_by_id?id={id}&isActive={isActive}";
        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("id", id);
        queryParams.put("isActive", isActive);

        return restTemplate.exchange(completeUrl, HttpMethod.GET, HttpEntity.EMPTY, Delivery.class, queryParams);
    }

    public ResponseEntity getDeliveriesByStatus(String status, boolean isActive) {
        final String completeUrl = baseUrl + "get_deliveries_by_status?status={status}&isActive={isActive}";
        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("status", status);
        queryParams.put("isActive", isActive);

        return restTemplate.exchange(completeUrl, HttpMethod.GET, HttpEntity.EMPTY, Delivery[].class, queryParams);
    }

    public ResponseEntity getAllDeliveryStatuses() {
        final String completeUrl = baseUrl + "get_all_delivery_statuses";
        return restTemplate.exchange(completeUrl, HttpMethod.GET, HttpEntity.EMPTY, DeliveryStatus[].class);
    }

    public ResponseEntity getByRequiredTime(LocalDateTime requestedDateTime, boolean isActive) {
        final String completeUrl = baseUrl + "get_by_requested_date_time?requestedDateTime={requestedDateTime}&isActive={isActive}";
        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("requestedDateTime", requestedDateTime);
        queryParams.put("isActive", isActive);

        return restTemplate.exchange(completeUrl, HttpMethod.GET, HttpEntity.EMPTY, Delivery[].class, queryParams);
    }

    public ResponseEntity searchByCustomer(String firstName,String familyName,int pageNo, int pageSize, boolean isActive) {
        final String completeUrl = baseUrl + "search_by_customer?firstName={firstName}&familyName={familyName}&pageNo={pageNo}&pageSize={pageSize}&isActive={isActive}";
        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("firstName", firstName);
        queryParams.put("familyName", familyName);
        queryParams.put("pageNo", pageNo);
        queryParams.put("pageSize", pageSize);
        queryParams.put("isActive", isActive);

        return restTemplate.exchange(completeUrl, HttpMethod.GET, HttpEntity.EMPTY, Delivery[].class, queryParams);
    }

    public ResponseEntity searchByCourier(String firstName,String familyName,int pageNo, int pageSize, boolean isActive) {
        final String completeUrl = baseUrl + "search_by_courier?firstName={firstName}&familyName={familyName}&pageNo={pageNo}&pageSize={pageSize}&isActive={isActive}";
        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("firstName", firstName);
        queryParams.put("familyName", familyName);
        queryParams.put("pageNo", pageNo);
        queryParams.put("pageSize", pageSize);
        queryParams.put("isActive", isActive);

        return restTemplate.exchange(completeUrl, HttpMethod.GET, HttpEntity.EMPTY, Delivery[].class, queryParams);
    }

    public ResponseEntity searchByStore(String storeName, int pageNo, int pageSize, boolean isActive) {
        final String completeUrl = baseUrl + "search_by_store?storeName={storeName}&pageNo={pageNo}&pageSize={pageSize}&isActive={isActive}";
        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("storeName", storeName);
        queryParams.put("pageNo", pageNo);
        queryParams.put("pageSize", pageSize);
        queryParams.put("isActive", isActive);

        return restTemplate.exchange(completeUrl, HttpMethod.GET, HttpEntity.EMPTY, Delivery[].class, queryParams);
    }

    public ResponseEntity searchByProduct(String productName, int pageNo, int pageSize, boolean isActive) {
        final String completeUrl = baseUrl + "search_by_product?productName={productName}&pageNo={pageNo}&pageSize={pageSize}&isActive={isActive}";
        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("productName", productName);
        queryParams.put("pageNo", pageNo);
        queryParams.put("pageSize", pageSize);
        queryParams.put("isActive", isActive);

        return restTemplate.exchange(completeUrl, HttpMethod.GET, HttpEntity.EMPTY, Delivery[].class, queryParams);
    }

    public ResponseEntity search(Set<String> keyword, int pageNo, int pageSize, boolean isActive) {
        final String completeUrl = baseUrl + "search?keyword={keyword}&pageNo={pageNo}&pageSize={pageSize}&isActive={isActive}";
        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("keyword", keyword);
        queryParams.put("pageNo", pageNo);
        queryParams.put("pageSize", pageSize);
        queryParams.put("isActive", isActive);

        return restTemplate.exchange(completeUrl, HttpMethod.GET, HttpEntity.EMPTY, Order[].class, queryParams);
    }

    public ResponseEntity create (Delivery delivery) {
        final String completeUrl = baseUrl + "create_delivery";
        return restTemplate.exchange(completeUrl, HttpMethod.POST, new HttpEntity<>(delivery), String.class);
    }

    public ResponseEntity updateDeliveryStatusById(Long id, String deliveryStatus) {
        final String completeUrl = baseUrl + "update_delivery_status_by_id?id={id}&deliveryStatus={deliveryStatus}";
        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("id", id);
        queryParams.put("deliveryStatus", deliveryStatus);

        return restTemplate.exchange(completeUrl, HttpMethod.PATCH, HttpEntity.EMPTY,  String.class, queryParams);
    }

    public ResponseEntity deleteById (Long id){
        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("id", id);

        final String completeUrl = baseUrl + "delete_by_id?id={id}";
        return restTemplate.exchange(completeUrl, HttpMethod.DELETE, HttpEntity.EMPTY, String.class, queryParams);
    }

    public ResponseEntity existsById(Long id) {
        final String completeUrl = baseUrl + "exists_by_id?id={id}";
        return restTemplate.exchange(completeUrl, HttpMethod.GET, HttpEntity.EMPTY, String.class, id);
    }

    public ResponseEntity existsByExample(Delivery delivery) {
        final String completeUrl = baseUrl + "exists";
        return restTemplate.exchange(completeUrl, HttpMethod.POST, new HttpEntity<>(delivery), String.class);
    }
}
