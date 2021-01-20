package be.fooda.frontend.service;

import be.fooda.frontend.models.payment.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class PaymentService {

    private final RestTemplate restTemplate;

    @Value("${fooda.payment.service.url}")
    private String baseUrl;

    public PaymentService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

//    PAYMENT END POINTS

    public ResponseEntity getPaymentById(Long paymentId) {
        final String completeUrl = baseUrl + "get_payment_by_id?paymentId={paymentId}";
        return restTemplate.exchange(completeUrl, HttpMethod.GET, HttpEntity.EMPTY, Payment.class, paymentId);
    }

    public ResponseEntity getAllPayments(int pageNo, int pageSize) {
        final String completeUrl = baseUrl + "get_all_payments?pageNo={pageNo}&pageSize={pageSize}";
        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("pageNo", pageNo);
        queryParams.put("pageSize", pageSize);
        return restTemplate.exchange(completeUrl, HttpMethod.GET, HttpEntity.EMPTY, Payment[].class, queryParams);
    }

    public ResponseEntity getPaymentsByExternalStoreId(Long externalStoreId) {
        final String completeUrl = baseUrl + "get_payments_by_external_store_id?externalStoreId={externalStoreId}";
        return restTemplate.exchange(completeUrl, HttpMethod.GET, HttpEntity.EMPTY, Payment[].class, externalStoreId);
    }

    public ResponseEntity getPaymentsByExternalUserId(Long externalUserId) {
        final String completeUrl = baseUrl + "get_payments_by_external_user_id?externalUserId={externalUserId}";
        return restTemplate.exchange(completeUrl, HttpMethod.GET, HttpEntity.EMPTY, Payment[].class, externalUserId);
    }

    public ResponseEntity getPaymentByExternalOrderId(Long externalOrderId) {
        final String completeUrl = baseUrl + "get_payment_by_external_order_id?externalOrderId={externalOrderId}";
        return restTemplate.exchange(completeUrl, HttpMethod.GET, HttpEntity.EMPTY, Payment.class, externalOrderId);
    }

    public ResponseEntity createPayment(Payment payment) {
        final String completeUrl = baseUrl + "create_payment";
        return restTemplate.exchange(completeUrl, HttpMethod.POST, new HttpEntity<>(payment), String.class);
    }

    public ResponseEntity updatePaymentById(Long id, Payment payment) {
        final String completeUrl = baseUrl + "update_payment_by_id";
        return restTemplate.exchange(completeUrl,HttpMethod.PUT,new HttpEntity<>(payment),String.class,id);
    }

    public ResponseEntity deletePaymentById(Long id) {
        final String completeUrl = baseUrl + "delete_payment_by_id?id={id}";
        return restTemplate.exchange(completeUrl, HttpMethod.DELETE, HttpEntity.EMPTY, String.class, id);
    }

    public ResponseEntity deletePaymentByExternalOrderId(Long externalOrderId) {
        final String completeUrl = baseUrl + "delete_payment_by_external_order_id?externalOrderId={externalOrderId}";
        return restTemplate.exchange(completeUrl, HttpMethod.DELETE, HttpEntity.EMPTY, String.class, externalOrderId);
    }

    public ResponseEntity paymentExistsById(Long id) {
        final String completeUrl = baseUrl + "payment_exists?id={id}";
        return restTemplate.exchange(completeUrl, HttpMethod.GET, HttpEntity.EMPTY, String.class, id);
    }

    // PAYMENT ITEM SERVICE ENDPOINTS //

    public ResponseEntity getItemByItemId(Long itemId) {
        final String completeUrl = baseUrl + "get_item_by_id?itemId={itemId}";
        return restTemplate.exchange(completeUrl, HttpMethod.GET, HttpEntity.EMPTY, PaymentItem.class, itemId);
    }

    public ResponseEntity getItemsByPaymentId (Long paymentId) {
        final String completeUrl = baseUrl + "get_items_by_payment_id?paymentId={paymentId}";
        return restTemplate.exchange(completeUrl, HttpMethod.GET, HttpEntity.EMPTY, PaymentItem[].class, paymentId);
    }

    public ResponseEntity getAllItems(Integer pageNo, Integer pageSize) {
        final String completeUrl = baseUrl + "get_all_items?pageNo={pageNo}&pageSize={pageSize}";
        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("pageNo", pageNo);
        queryParams.put("pageSize", pageSize);
        return restTemplate.exchange(completeUrl, HttpMethod.GET, HttpEntity.EMPTY, PaymentItem[].class, queryParams);
    }

    public ResponseEntity createItem(PaymentItem item) {
        final String completeUrl = baseUrl + "create_item";
        return restTemplate.exchange(completeUrl, HttpMethod.POST, new HttpEntity<>(item), String.class);
    }

    public ResponseEntity updateItemByItemId(Long id, PaymentItem item) {
        final String completeUrl = baseUrl + "update_item_by_id";
        return restTemplate.exchange(completeUrl, HttpMethod.PUT, new HttpEntity<>(item), String.class, id);
    }

    public ResponseEntity deleteItemByItemId(Long id) {
        final String completeUrl = baseUrl + "delete_item_by_id?id={id}";
        return restTemplate.exchange(completeUrl, HttpMethod.DELETE, HttpEntity.EMPTY, String.class, id);
    }

    public ResponseEntity deleteItemsByPaymentId(Long paymentId) {
        final String completeUrl = baseUrl + "delete_items_by_payment_id?paymentId={paymentId}";
        return restTemplate.exchange(completeUrl, HttpMethod.DELETE, HttpEntity.EMPTY, String.class, paymentId);
    }

    public ResponseEntity itemExistsById(Long id) {
        final String completeUrl = baseUrl + "item_exits?id={id}";
        return restTemplate.exchange(completeUrl, HttpMethod.GET, HttpEntity.EMPTY, String.class, id);
    }

    // ORDER SERVICE ENDPOINTS //

    public ResponseEntity getOrderById(Long id) {
        final String completeUrl = baseUrl + "get_order_by_id?id={id}";
        return restTemplate.exchange(completeUrl, HttpMethod.GET, HttpEntity.EMPTY, PaymentOrder.class, id);
    }

    public ResponseEntity getOrderByPaymentId(Long paymentId) {
        final String completeUrl = baseUrl + "get_order_by_payment_id?paymentId={paymentId}";
        return restTemplate.exchange(completeUrl, HttpMethod.GET, HttpEntity.EMPTY, PaymentOrder.class, paymentId);
    }

    public ResponseEntity getAllOrders(Integer pageNo, Integer pageSize) {
        final String completeUrl = baseUrl + "get_all_orders?pageNo={pageNo}&pageSize={pageSize}";
        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("pageNo", pageNo);
        queryParams.put("pageSize", pageSize);
        return restTemplate.exchange(completeUrl, HttpMethod.GET, HttpEntity.EMPTY, PaymentOrder[].class, queryParams);
    }

    public ResponseEntity createOrder(PaymentOrder order) {
        final String completeUrl = baseUrl + "create_order";
        return restTemplate.exchange(completeUrl, HttpMethod.POST, new HttpEntity<>(order), String.class);
    }

    public ResponseEntity updateOrderByOrderId(Long id, PaymentOrder order) {
        final String completeUrl = baseUrl + "upate_order";
        return restTemplate.exchange(completeUrl, HttpMethod.PUT, new HttpEntity<>(order), String.class, id);
    }

    public ResponseEntity deleteOrderByOrderId(Long id) {
        final String completeUrl = baseUrl + "delete_order?id={id}";
        return restTemplate.exchange(completeUrl, HttpMethod.DELETE, HttpEntity.EMPTY, String.class, id);
    }

    public ResponseEntity deleteOrdersByPaymentId(Long paymentId) {
        final String completeUrl = baseUrl + "delete_orders_by_payment_id?paymentId={paymentId}";
        return restTemplate.exchange(completeUrl, HttpMethod.DELETE, HttpEntity.EMPTY, String.class, paymentId);
    }

    public ResponseEntity orderExistsByOrderId(Long id) {
        final String completeUrl = baseUrl + "order_exists?id={id}";
        return restTemplate.exchange(completeUrl, HttpMethod.GET, HttpEntity.EMPTY, String.class, id);
    }

    // STORE SERVICE ENDPOINTS //

    public ResponseEntity getStoreById(Long id) {
        final String completeUrl = baseUrl + "get_store?id={id}";
        return restTemplate.exchange(completeUrl, HttpMethod.GET, HttpEntity.EMPTY, PaymentStore.class, id);
    }

    public ResponseEntity getStoresByPaymentId(Long paymentId) {
        final String completeUrl = baseUrl + "get_stores_by_payment_id?paymentId={paymentId}";
        return restTemplate.exchange(completeUrl, HttpMethod.GET, HttpEntity.EMPTY, PaymentStore[].class, paymentId);
    }

    public ResponseEntity getStoresByExternalOrderId(Long externalOrderId) {
        final String completeUrl = baseUrl + "get_stores_by_external_order_id?externalOrderId={externalOrderId}";
        return restTemplate.exchange(completeUrl, HttpMethod.GET, HttpEntity.EMPTY, PaymentStore[].class, externalOrderId);
    }

    public ResponseEntity getAllStores(Integer pageNo, Integer pageSize) {
        final String completeUrl = baseUrl + "get_all_stores?pageNo={pageNo}&pageSize={pageSize}";
        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("pageNo", pageNo);
        queryParams.put("pageSize", pageSize);
        return restTemplate.exchange(completeUrl, HttpMethod.GET, HttpEntity.EMPTY, PaymentStore[].class, queryParams);
    }

    public ResponseEntity createStore(PaymentStore store) {
        final String completeUrl = baseUrl + "create_store";
        return restTemplate.exchange(completeUrl, HttpMethod.POST, new HttpEntity<>(store), String.class);
    }

    public ResponseEntity updateStoreByStoreId(Long id, PaymentStore store) {
        final String completeUrl = baseUrl + "update_store";
        return restTemplate.exchange(completeUrl, HttpMethod.PUT, new HttpEntity<>(store), String.class, id);
    }

    public ResponseEntity deleteStoreByStoreId(Long id) {
        final String completeUrl = baseUrl + "delete_store?id={id}";
        return restTemplate.exchange(completeUrl, HttpMethod.DELETE, HttpEntity.EMPTY, String.class, id);
    }
    public ResponseEntity deleteStoresByPaymentId(Long paymentId) {
        final String completeUrl = baseUrl + "delete_stores_by_payment_id?paymentId={paymentId}";
        return restTemplate.exchange(completeUrl, HttpMethod.DELETE, HttpEntity.EMPTY, String.class, paymentId);
    }

    public ResponseEntity deleteStoresByExternalOrderId(Long externalOrderId) {
        final String completeUrl = baseUrl + "delete_stores_by_external_order_id?externalOrderId={externalOrderId}";
        return restTemplate.exchange(completeUrl, HttpMethod.DELETE, HttpEntity.EMPTY, String.class, externalOrderId);
    }

    @GetMapping("store_exists")
    public ResponseEntity storeExistsByStoreId(Long id) {
        final String completeUrl = baseUrl + "store_exists?id={id}";
        return restTemplate.exchange(completeUrl, HttpMethod.GET, HttpEntity.EMPTY, String.class, id);
    }

    //USER SERVICE ENDPOINTS //

    public ResponseEntity getUserById(Long id) {
        final String completeUrl = baseUrl + "get_user?id={id}";
        return restTemplate.exchange(completeUrl, HttpMethod.GET, HttpEntity.EMPTY, PaymentUser.class, id);
    }

    public ResponseEntity getUserByPaymentId(Long paymentId) {
        final String completeUrl = baseUrl + "get_user_by_payment_id?paymentId={paymentId}";
        return restTemplate.exchange(completeUrl, HttpMethod.GET, HttpEntity.EMPTY, PaymentUser.class, paymentId);
    }

    public ResponseEntity getAllUsers(Integer pageNo, Integer pageSize) {
        final String completeUrl = baseUrl + "get_all_users?pageNo={pageNo}&pageSize={pageSize}";
        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("pageNo", pageNo);
        queryParams.put("pageSize", pageSize);
        return restTemplate.exchange(completeUrl, HttpMethod.GET, HttpEntity.EMPTY, PaymentUser[].class, queryParams);
    }

    public ResponseEntity createUser(PaymentUser user) {
        final String completeUrl = baseUrl + "create_user";
        return restTemplate.exchange(completeUrl, HttpMethod.POST, new HttpEntity<>(user), String.class);
    }

    public ResponseEntity updateUserByUserId(Long id, PaymentUser user) {
        final String completeUrl = baseUrl + "update_user";
        return restTemplate.exchange(completeUrl, HttpMethod.PUT, new HttpEntity<>(user), String.class, id);
    }

    public ResponseEntity deleteUserByUserId(Long id) {
        final String completeUrl = baseUrl + "delete_user?id={id}";
        return restTemplate.exchange(completeUrl, HttpMethod.DELETE, HttpEntity.EMPTY, String.class, id);
    }

    public ResponseEntity deleteUsersByPaymentId(Long paymentId) {
        final String completeUrl = baseUrl + "delete_user_by_payment_id?paymentId={paymentId}";
        return restTemplate.exchange(completeUrl, HttpMethod.DELETE, HttpEntity.EMPTY, String.class, paymentId);
    }

    public ResponseEntity userExistsByUserId(Long id) {
        final String completeUrl = baseUrl + "user_exists?id={id}";
        return restTemplate.exchange(completeUrl, HttpMethod.GET, HttpEntity.EMPTY, String.class, id);
    }
}
