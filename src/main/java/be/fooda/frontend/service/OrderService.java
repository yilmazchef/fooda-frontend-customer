package be.fooda.frontend.service;


import be.fooda.frontend.model.OrderStatus;
import be.fooda.frontend.model.order.Order;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Service
public class OrderService {
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
        return restTemplate.exchange(completeUrl, HttpMethod.GET, HttpEntity.EMPTY, Order[].class, queryParams);
    }

    public ResponseEntity getOrderById(long id, boolean isActive) {
        final String completeUrl = baseUrl + "get-order-by-id?id={id}&isActive={isActive}";
        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("id", id);
        queryParams.put("isActive", isActive);

        return restTemplate.exchange(completeUrl, HttpMethod.GET, HttpEntity.EMPTY, Order.class, queryParams);
    }

    public ResponseEntity getOrdersByStatus(String status, boolean isActive) {
        final String completeUrl = baseUrl + "get_orders_by_status?status={status}&isActive={isActive}";
        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("status", status);
        queryParams.put("isActive", isActive);

        return restTemplate.exchange(completeUrl, HttpMethod.GET, HttpEntity.EMPTY, Order[].class, queryParams);
    }

    public ResponseEntity getCompletedOrders() {
        final String completeUrl = baseUrl + "get_completed_orders";
        return restTemplate.exchange(completeUrl, HttpMethod.GET, HttpEntity.EMPTY, Order[].class);
    }

    public ResponseEntity getCanceledOrders() {
        final String completeUrl = baseUrl + "get_canceled_orders";
        return restTemplate.exchange(completeUrl, HttpMethod.GET, HttpEntity.EMPTY, Order[].class);
    }

    public ResponseEntity getAllOrderStatuses() {
        final String completeUrl = baseUrl + "get_all_order_statuses";
        return restTemplate.exchange(completeUrl, HttpMethod.GET, HttpEntity.EMPTY, OrderStatus[].class);
    }

    public ResponseEntity getByRequiredTime(LocalTime requiredTime, boolean isActive) {
        final String completeUrl = baseUrl + "get_by_required_time?requiredTime={requiredTime}&isActive={isActive}";
        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("requiredTime", requiredTime);
        queryParams.put("isActive", isActive);

        return restTemplate.exchange(completeUrl, HttpMethod.GET, HttpEntity.EMPTY, Order[].class, queryParams);
    }

    public ResponseEntity getByDeliveryTime(LocalTime deliveryTime, boolean isActive) {
        final String completeUrl = baseUrl + "get_by_delivery_time?deliveryTime={deliveryTime}&isActive={isActive}";
        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("deliveryTime", deliveryTime);
        queryParams.put("isActive", isActive);

        return restTemplate.exchange(completeUrl, HttpMethod.GET, HttpEntity.EMPTY, Order[].class, queryParams);
    }

    public ResponseEntity getByDeliveryDate(LocalDate deliveryDate, boolean isActive) {
        final String completeUrl = baseUrl + "get_by_delivery_date?deliveryDate={deliveryDate}&isActive={isActive}";
        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("deliveryDate", deliveryDate);
        queryParams.put("isActive", isActive);

        return restTemplate.exchange(completeUrl, HttpMethod.GET, HttpEntity.EMPTY, Order[].class, queryParams);
    }

    public ResponseEntity getByPaymentDateTime(LocalDateTime paymentDateTime, boolean isActive) {
        final String completeUrl = baseUrl + "get_by_payment_date_time?paymentDateTime={paymentDateTime}&isActive={isActive}";
        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("paymentDateTime", paymentDateTime);
        queryParams.put("isActive", isActive);

        return restTemplate.exchange(completeUrl, HttpMethod.GET, HttpEntity.EMPTY, Order[].class, queryParams);
    }

    public ResponseEntity getByPaymentAmount(BigDecimal min, boolean isActive) {
        final String completeUrl = baseUrl + "get_by_payment_amount?min={min}&isActive={isActive}";
        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("min", min);
        queryParams.put("isActive", isActive);

        return restTemplate.exchange(completeUrl, HttpMethod.GET, HttpEntity.EMPTY, Order[].class, queryParams);
    }

    public ResponseEntity getByPaymentRange(BigDecimal min, BigDecimal max, boolean isActive) {
        final String completeUrl = baseUrl + "get_by_payment_range?min={min}&max={max}&isActive={isActive}";
        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("min", min);
        queryParams.put("max", max);
        queryParams.put("isActive", isActive);

        return restTemplate.exchange(completeUrl, HttpMethod.GET, HttpEntity.EMPTY, Order[].class, queryParams);
    }

    public ResponseEntity getByStoreId(Long externalStoreId, boolean isActive) {
        final String completeUrl = baseUrl + "get_by_store_id?externalStoreId={externalStoreId}&isActive={isActive}";
        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("externalStoreId", externalStoreId);
        queryParams.put("isActive", isActive);

        return restTemplate.exchange(completeUrl, HttpMethod.GET, HttpEntity.EMPTY, Order[].class, queryParams);
    }

    public ResponseEntity getByCustomerPhone(Long phone, boolean isActive) {
        final String completeUrl = baseUrl + "get_by_customer_phone?phone={phone}&isActive={isActive}";
        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("phone", phone);
        queryParams.put("isActive", isActive);

        return restTemplate.exchange(completeUrl, HttpMethod.GET, HttpEntity.EMPTY, Order[].class, queryParams);
    }

    public ResponseEntity getByPaymentId(Long externalCustomerId,Long externalPaymentId, boolean isActive) {
        final String completeUrl = baseUrl + "get_by_payment_id?externalCustomerId={externalCustomerId}&externalPaymentId={externalPaymentId}&isActive={isActive}";
        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("externalCustomerId", externalCustomerId);
        queryParams.put("externalPaymentId", externalPaymentId);
        queryParams.put("isActive", isActive);

        return restTemplate.exchange(completeUrl, HttpMethod.GET, HttpEntity.EMPTY, Order[].class, queryParams);
    }

    public ResponseEntity getByCustomerId(Long externalCustomerId, boolean isActive) {
        final String completeUrl = baseUrl + "get_by_customer_id?externalCustomerId={externalCustomerId}&isActive={isActive}";
        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("externalCustomerId", externalCustomerId);
        queryParams.put("isActive", isActive);

        return restTemplate.exchange(completeUrl, HttpMethod.GET, HttpEntity.EMPTY, Order[].class, queryParams);
    }

    public ResponseEntity searchByCustomer(String firstName,String familyName,int pageNo, int pageSize, boolean isActive) {
        final String completeUrl = baseUrl + "search_by_customer?firstName={firstName}&familyName={familyName}&pageNo={pageNo}&pageSize={pageSize}&isActive={isActive}";
        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("firstName", firstName);
        queryParams.put("familyName", familyName);
        queryParams.put("pageNo", pageNo);
        queryParams.put("pageSize", pageSize);
        queryParams.put("isActive", isActive);

        return restTemplate.exchange(completeUrl, HttpMethod.GET, HttpEntity.EMPTY, Order[].class, queryParams);
    }

    public ResponseEntity searchByStore(String storeName, int pageNo, int pageSize, boolean isActive) {
        final String completeUrl = baseUrl + "search_by_store?storeName={storeName}&pageNo={pageNo}&pageSize={pageSize}&isActive={isActive}";
        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("storeName", storeName);
        queryParams.put("pageNo", pageNo);
        queryParams.put("pageSize", pageSize);
        queryParams.put("isActive", isActive);

        return restTemplate.exchange(completeUrl, HttpMethod.GET, HttpEntity.EMPTY, Order[].class, queryParams);
    }

    public ResponseEntity searchByProduct(String productName, int pageNo, int pageSize, boolean isActive) {
        final String completeUrl = baseUrl + "search_by_product?productName={productName}&pageNo={pageNo}&pageSize={pageSize}&isActive={isActive}";
        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("productName", productName);
        queryParams.put("pageNo", pageNo);
        queryParams.put("pageSize", pageSize);
        queryParams.put("isActive", isActive);

        return restTemplate.exchange(completeUrl, HttpMethod.GET, HttpEntity.EMPTY, Order[].class, queryParams);
    }

    public ResponseEntity create (Order order) {
        final String completeUrl = baseUrl + "create_order";
        return restTemplate.exchange(completeUrl, HttpMethod.POST, new HttpEntity<>(order), String.class);
    }

    public ResponseEntity updateOrderStatusById(Long id, String orderStatus) {
        final String completeUrl = baseUrl + "update_order_status_by_id?id={id}&orderStatus={orderStatus}";
        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("id", id);
        queryParams.put("orderStatus", orderStatus);

        return restTemplate.exchange(completeUrl, HttpMethod.PATCH, HttpEntity.EMPTY,  String.class, queryParams);
    }

    public ResponseEntity updateOrderPaymentStatusById(Long id, String paymentStatus) {
        final String completeUrl = baseUrl + "update_order_payment_status_by_id?id={id}&paymentStatus={paymentStatus}";
        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("id", id);
        queryParams.put("paymentStatus", paymentStatus);

        return restTemplate.exchange(completeUrl, HttpMethod.PATCH, HttpEntity.EMPTY,  String.class, queryParams);
    }

    public ResponseEntity deleteByCustomerId (Long id){
        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("id", id);

        final String completeUrl = baseUrl + "delete_by_customer_id?id={id}";
        return restTemplate.exchange(completeUrl, HttpMethod.DELETE, HttpEntity.EMPTY, String.class, queryParams);
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

    public ResponseEntity existsByExample(Order order) {
        final String completeUrl = baseUrl + "exists";
        return restTemplate.exchange(completeUrl, HttpMethod.POST, new HttpEntity<>(order), String.class);
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

}
