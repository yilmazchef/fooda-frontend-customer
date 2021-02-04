package be.fooda.frontend.service;

import be.fooda.frontend.model.basket.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BasketService {

    private final RestTemplate restTemplate;

    @Value("${fooda.basket.service.url}")
    private String baseUrl;

    public BasketService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    private HttpHeaders createHttpHeaders(String user, String password) {
        String notEncoded = user + ":" + password;
        String encodedAuth = "Bearer " + Base64.getEncoder().encodeToString(notEncoded.getBytes());
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("Authorization", encodedAuth);
        return headers;
    }

    public ResponseEntity getProductById(String productId) {
        final String completeUrl = baseUrl + "product/get_product_by_id?productId={productId}";
        return restTemplate.exchange(completeUrl, HttpMethod.GET, HttpEntity.EMPTY, BasketProduct.class, productId);
    }

    public ResponseEntity getProductByUserAndExternalProductId(Long externalUserId, String userSession, Long externalProductId) {
        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("externalUserId", externalUserId);
        queryParams.put("userSession", userSession);
        queryParams.put("externalProductId", externalProductId);
        final String completeUrl = baseUrl + "product/get_product_by_user_and_external_product_id?" +
                "externalUserId={externalUserId}&userSession={userSession}&externalProductId={externalProductId}";
        return restTemplate.exchange(completeUrl, HttpMethod.GET, HttpEntity.EMPTY, BasketProduct.class, queryParams);
    }

    public ResponseEntity getProductsByUserAndStore(Long externalUserId, String userSession, Long externalStoreId) {
        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("externalUserId", externalUserId);
        queryParams.put("userSession", userSession);

        queryParams.put("externalStoreId", externalStoreId);
        final String completeUrl = baseUrl + "product/get_products_by_user_and_store?" +
                "externalUserId={externalUserId}&userSession={userSession}&externalStoreId={externalStoreId}";
        return restTemplate.exchange(completeUrl, HttpMethod.GET, HttpEntity.EMPTY, BasketProduct[].class, queryParams);
    }

    public ResponseEntity getProductsByUser(Long externalUserId, String userSession) {
        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("externalUserId", externalUserId);
        queryParams.put("userSession", userSession);

        final String completeUrl = baseUrl + "product/get_products_by_user_and_store?" +
                "externalUserId={externalUserId}&userSession={userSession}";
        return restTemplate.exchange(completeUrl, HttpMethod.GET, HttpEntity.EMPTY, BasketProduct[].class, queryParams);
    }

    public ResponseEntity addProduct(BasketProduct product) {
        final String completeUrl = baseUrl + "product/add_product";
        return restTemplate.exchange(completeUrl, HttpMethod.POST, new HttpEntity<>(product), String.class);
    }

    public ResponseEntity updateProductQuantity(Long externalProductId, Long externalUserId, String userSession, Integer newQuantity) {
        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("externalProductId", externalProductId);
        queryParams.put("externalUserId", externalUserId);
        queryParams.put("userSession", userSession);
        queryParams.put("newQuantity", newQuantity);
        final String completeUrl = baseUrl + "product/update_product_quantity?" +
                "externalProductId={externalProductId}&externalUserId={externalUserId}&" +
                "userSession={userSession}&newQuantity={newQuantity}";
        return restTemplate.exchange(completeUrl, HttpMethod.PATCH, HttpEntity.EMPTY, String.class, queryParams);
    }

    public ResponseEntity updateProductPrice(Long externalProductId, Long externalUserId, String userSession, BigDecimal newPrice) {
        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("externalProductId", externalProductId);
        queryParams.put("externalUserId", externalUserId);
        queryParams.put("userSession", userSession);
        queryParams.put("newPrice", newPrice);
        final String completeUrl = baseUrl + "product/update_product_price?" +
                "externalProductId={externalProductId}&externalUserId={externalUserId}&" +
                "userSession={userSession}&newPrice={newPrice}";
        return restTemplate.exchange(completeUrl, HttpMethod.PATCH, HttpEntity.EMPTY, String.class, queryParams);
    }

    public ResponseEntity deleteProductById(String id) {
        final String completeUrl = baseUrl + "product/delete_product_by_id?id={id}";
        return restTemplate.exchange(completeUrl, HttpMethod.DELETE, HttpEntity.EMPTY, String.class, id);
    }

    public ResponseEntity deleteProductByUserAndExternalProductId(Long externalProductId, Long externalUserId, String userSession) {
        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("externalProductId", externalProductId);
        queryParams.put("externalUserId", externalUserId);
        queryParams.put("userSession", userSession);
        final String completeUrl = baseUrl + "product/delete_product_by_user_and_external_product_id?" +
                "externalProductId={externalProductId}&externalUserId={externalUserId}&userSession={userSession}";
        return restTemplate.exchange(completeUrl, HttpMethod.DELETE, HttpEntity.EMPTY, String.class, queryParams);
    }

    public ResponseEntity deleteProducts(Long externalStoreId, Long externalUserId, String userSession) {
        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("externalStoreId", externalStoreId);
        queryParams.put("externalUserId", externalUserId);
        queryParams.put("userSession", userSession);
        final String completeUrl = baseUrl + "product/delete_products?" +
                "externalStoreId={externalStoreId}&externalUserId={externalUserId}&userSession={userSession}";
        return restTemplate.exchange(completeUrl, HttpMethod.DELETE, HttpEntity.EMPTY, String.class, queryParams);
    }

    public ResponseEntity productExistsById(String id) {
        final String completeUrl = baseUrl + "product/product_exists?id={id}";
        return restTemplate.exchange(completeUrl, HttpMethod.GET, HttpEntity.EMPTY, String.class, id);
    }

    //    ADDRESS END POINTS

    public ResponseEntity getAddressById(String addressId) {
        final String completeUrl = baseUrl + "address/get_address_by_id?addressId={addressId}";
        return restTemplate.exchange(completeUrl, HttpMethod.GET, HttpEntity.EMPTY, BasketAddress.class, addressId);
    }

    public ResponseEntity getAddressesByExternalUserId(Long externalUserId) {
        final String completeUrl = baseUrl + "address/get_addresses_by_external_user_id?externalUserId={externalUserId}";
        return restTemplate.exchange(completeUrl, HttpMethod.GET, HttpEntity.EMPTY, BasketAddress[].class, externalUserId);
    }

    public ResponseEntity createAddress(BasketAddress address) {
        final String completeUrl = baseUrl + "address/create_address";
        return restTemplate.exchange(completeUrl, HttpMethod.POST, new HttpEntity<>(address), String.class);
    }

    public ResponseEntity deleteAddressById(String id) {
        final String completeUrl = baseUrl + "address/delete_address_by_id?id={id}";
        return restTemplate.exchange(completeUrl, HttpMethod.DELETE, HttpEntity.EMPTY, String.class, id);
    }

    public ResponseEntity deleteAddress(Long externalUserId, String userSession, Long externalAddressId) {
        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("externalUserId", externalUserId);
        queryParams.put("userSession", userSession);
        queryParams.put("externalAddressId", externalAddressId);
        final String completeUrl = baseUrl + "address/delete_address?" +
                "externalUserId={externalUserId}&userSession={userSession}&externalAddressId={externalAddressId}";
        return restTemplate.exchange(completeUrl, HttpMethod.DELETE, HttpEntity.EMPTY, String.class, queryParams);
    }

    public ResponseEntity addressExistsById(String id) {
        final String completeUrl = baseUrl + "address/address_exists?id={id}";
        return restTemplate.exchange(completeUrl, HttpMethod.GET, HttpEntity.EMPTY, String.class, id);
    }

    //    CONTACT END POINTS

    public ResponseEntity getContactById(String contactId) {
        final String completeUrl = baseUrl + "contact/get_contact_by_id?contactId={contactId}";
        return restTemplate.exchange(completeUrl, HttpMethod.GET, HttpEntity.EMPTY, BasketContact.class, contactId);
    }

    public ResponseEntity getContactsByExternalUserId(Long externalUserId) {
        final String completeUrl = baseUrl + "contact/get_contacts_by_external_user_id?externalUserId={externalUserId}";
        return restTemplate.exchange(completeUrl, HttpMethod.GET, HttpEntity.EMPTY, BasketContact[].class, externalUserId);
    }

    public ResponseEntity createContact(BasketContact contact) {
        final String completeUrl = baseUrl + "contact/create_contact";
        return restTemplate.exchange(completeUrl, HttpMethod.POST, new HttpEntity<>(contact), String.class);
    }

    public ResponseEntity deleteContactById(String id) {
        final String completeUrl = baseUrl + "contact/delete_contact_by_id?id={id}";
        return restTemplate.exchange(completeUrl, HttpMethod.DELETE, HttpEntity.EMPTY, String.class, id);
    }

    public ResponseEntity deleteContact(Long externalUserId, String userSession, Long externalContactId) {
        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("externalUserId", externalUserId);
        queryParams.put("userSession", userSession);
        queryParams.put("externalContactId", externalContactId);
        final String completeUrl = baseUrl + "contact/delete_contact?" +
                "externalUserId={externalUserId}&userSession={userSession}&externalContactId={externalContactId}";
        return restTemplate.exchange(completeUrl, HttpMethod.DELETE, HttpEntity.EMPTY, String.class, queryParams);
    }

    public ResponseEntity contactExistsById(String id) {
        final String completeUrl = baseUrl + "contact/contact_exists?id={id}";
        return restTemplate.exchange(completeUrl, HttpMethod.GET, HttpEntity.EMPTY, String.class, id);
    }

    //    PAYMENT END POINTS

    public ResponseEntity getPaymentById(String paymentId) {
        final String completeUrl = baseUrl + "payment/get_payment_by_id?paymentId={paymentId}";
        return restTemplate.exchange(completeUrl, HttpMethod.GET, HttpEntity.EMPTY, BasketPayment.class, paymentId);
    }

    public ResponseEntity getPaymentsByExternalUserId(Long externalUserId) {
        final String completeUrl = baseUrl + "payment/get_payments_by_external_user_id?externalUserId={externalUserId}";
        return restTemplate.exchange(completeUrl, HttpMethod.GET, HttpEntity.EMPTY, BasketPayment[].class, externalUserId);
    }

    public ResponseEntity createPayment(BasketPayment payment) {
        final String completeUrl = baseUrl + "payment/create_payment";
        return restTemplate.exchange(completeUrl, HttpMethod.POST, new HttpEntity<>(payment), String.class);
    }

    public ResponseEntity deletePaymentById(String id) {
        final String completeUrl = baseUrl + "payment/delete_payment_by_id?id={id}";
        return restTemplate.exchange(completeUrl, HttpMethod.DELETE, HttpEntity.EMPTY, String.class, id);
    }

    public ResponseEntity paymentExistsById(String id) {
        final String completeUrl = baseUrl + "payment/payment_exists?id={id}";
        return restTemplate.exchange(completeUrl, HttpMethod.GET, HttpEntity.EMPTY, String.class, id);
    }

    //    ORDER END POINTS

    public ResponseEntity createOrders(List<BasketOrder> orders) {
        final String completeUrl = baseUrl + "order/create_orders";
        return restTemplate.exchange(completeUrl, HttpMethod.POST, new HttpEntity<>(orders), String.class);
    }

    public ResponseEntity deleteOrderById(String id) {
        final String completeUrl = baseUrl + "order/delete_order_by_id?id={id}";
        return restTemplate.exchange(completeUrl, HttpMethod.DELETE, HttpEntity.EMPTY, String.class, id);
    }

    public ResponseEntity deleteOrders(Long externalStoreId, Long externalUserId, String userSession) {
        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("externalStoreId", externalStoreId);
        queryParams.put("externalUserId", externalUserId);
        queryParams.put("userSession", userSession);
        final String completeUrl = baseUrl + "order/delete_orders?" +
                "externalStoreId={externalStoreId}&externalUserId={externalUserId}&userSession={userSession}";
        return restTemplate.exchange(completeUrl, HttpMethod.DELETE, HttpEntity.EMPTY, String.class, queryParams);
    }

    public ResponseEntity orderExistsById(String id) {
        final String completeUrl = baseUrl + "order/order_exists?id={id}";
        return restTemplate.exchange(completeUrl, HttpMethod.GET, HttpEntity.EMPTY, String.class, id);

    }

    public ResponseEntity getOrdersByUser(Long externalUserId, String userSession, Long externalStoreId) {
        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("externalUserId", externalUserId);
        queryParams.put("userSession", userSession);
        queryParams.put("externalStoreId", externalStoreId);
        final String completeUrl = baseUrl + "order/get_orders_by_user_and_store?" +
                "externalUserId={externalUserId}&userSession={userSession}&externalStoreId={externalStoreId}";
        return restTemplate.exchange(completeUrl, HttpMethod.GET, HttpEntity.EMPTY, BasketOrder[].class, queryParams);
    }
}
