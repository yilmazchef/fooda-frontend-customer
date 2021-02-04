package be.fooda.frontend.service;

import be.fooda.frontend.model.customer.Customer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Service
public class CustomerService {
    private final RestTemplate restTemplate;

    @Value("${fooda.customer.service.url}")
    private String baseUrl;

    public CustomerService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ResponseEntity getAllCustomers(int pageNo, int pageSize, boolean isActive) {
        final String completeUrl = baseUrl + "get_all_customers?pageNo={pageNo}&pageSize={pageSize}&isActive={isActive}";
        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("pageNo", pageNo);
        queryParams.put("pageSize", pageSize);
        queryParams.put("isActive", isActive);
        return restTemplate.exchange(completeUrl, HttpMethod.GET, HttpEntity.EMPTY, Customer[].class, queryParams);
    }

    public ResponseEntity getCustomerById(long id, boolean isActive) {
        final String completeUrl = baseUrl + "get_customer_by_id?id={id}&isActive={isActive}";
        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("id", id);
        queryParams.put("isActive", isActive);

        return restTemplate.exchange(completeUrl, HttpMethod.GET, HttpEntity.EMPTY, Customer.class, queryParams);
    }

    public ResponseEntity validate(long customerId, String validationCode) {
        final String completeUrl = baseUrl + "validate_customer?customerId={customerId}&validationCode={validationCode}";
        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("customerId", customerId);
        queryParams.put("validationCode", validationCode);

        return restTemplate.exchange(completeUrl, HttpMethod.GET, HttpEntity.EMPTY, Customer.class, queryParams);
    }

    public ResponseEntity create (Customer customer) {
        final String completeUrl = baseUrl + "create_customer";
        return restTemplate.exchange(completeUrl, HttpMethod.POST, new HttpEntity<>(customer), String.class);
    }

    public ResponseEntity searchByPhone(String phone, int pageNo, int pageSize, boolean isActive) {
        final String completeUrl = baseUrl + "search_by_phone?phone={phone}&pageNo={pageNo}&pageSize={pageSize}&isActive={isActive}";
        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("phone", phone);
        queryParams.put("pageNo", pageNo);
        queryParams.put("pageSize", pageSize);
        queryParams.put("isActive", isActive);

        return restTemplate.exchange(completeUrl, HttpMethod.GET, HttpEntity.EMPTY, Customer[].class, queryParams);
    }

    public ResponseEntity searchByCustomerFullyName(String firstName,String familyName,int pageNo, int pageSize, boolean isActive) {
        final String completeUrl = baseUrl + "search_by_customer_fully_name?firstName={firstName}&familyName={familyName}&pageNo={pageNo}&pageSize={pageSize}&isActive={isActive}";
        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("firstName", firstName);
        queryParams.put("familyName", familyName);
        queryParams.put("pageNo", pageNo);
        queryParams.put("pageSize", pageSize);
        queryParams.put("isActive", isActive);

        return restTemplate.exchange(completeUrl, HttpMethod.GET, HttpEntity.EMPTY, Customer[].class, queryParams);
    }

    public ResponseEntity searchByEmail(String email,int pageNo, int pageSize, boolean isActive) {
        final String completeUrl = baseUrl + "search_by_email?email={email}&pageNo={pageNo}&pageSize={pageSize}&isActive={isActive}";
        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("email", email);
        queryParams.put("pageNo", pageNo);
        queryParams.put("pageSize", pageSize);
        queryParams.put("isActive", isActive);

        return restTemplate.exchange(completeUrl, HttpMethod.GET, HttpEntity.EMPTY, Customer[].class, queryParams);
    }

    public ResponseEntity searchByMunicipality(String municipality,int pageNo, int pageSize, boolean isActive) {
        final String completeUrl = baseUrl + "search_by_municipality?municipality={municipality}&pageNo={pageNo}&pageSize={pageSize}&isActive={isActive}";
        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("municipality", municipality);
        queryParams.put("pageNo", pageNo);
        queryParams.put("pageSize", pageSize);
        queryParams.put("isActive", isActive);

        return restTemplate.exchange(completeUrl, HttpMethod.GET, HttpEntity.EMPTY, Customer[].class, queryParams);
    }

    public ResponseEntity searchByPostcode(String postcode, int pageNo, int pageSize, boolean isActive) {
        final String completeUrl = baseUrl + "search_by_postcode?postcode={postcode}&pageNo={pageNo}&pageSize={pageSize}&isActive={isActive}";
        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("postcode", postcode);
        queryParams.put("pageNo", pageNo);
        queryParams.put("pageSize", pageSize);
        queryParams.put("isActive", isActive);

        return restTemplate.exchange(completeUrl, HttpMethod.GET, HttpEntity.EMPTY, Customer[].class, queryParams);
    }

    public ResponseEntity search(Set<String> keyword, int pageNo, int pageSize, boolean isActive) {
        final String completeUrl = baseUrl + "search?keyword={keyword}&pageNo={pageNo}&pageSize={pageSize}&isActive={isActive}";
        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("keyword", keyword);
        queryParams.put("pageNo", pageNo);
        queryParams.put("pageSize", pageSize);
        queryParams.put("isActive", isActive);

        return restTemplate.exchange(completeUrl, HttpMethod.GET, HttpEntity.EMPTY, Customer[].class, queryParams);
    }

    public ResponseEntity existsByExample(Customer customer) {
        final String completeUrl = baseUrl + "exists";
        return restTemplate.exchange(completeUrl, HttpMethod.POST, new HttpEntity<>(customer), String.class);
    }

    public ResponseEntity existsById(Long id) {
        final String completeUrl = baseUrl + "exists_by_id?id={id}";
        return restTemplate.exchange(completeUrl, HttpMethod.GET, HttpEntity.EMPTY, String.class, id);
    }

    public ResponseEntity deleteById (Long id){
        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("id", id);

        final String completeUrl = baseUrl + "delete_by_id?id={id}";
        return restTemplate.exchange(completeUrl, HttpMethod.DELETE, HttpEntity.EMPTY, String.class, queryParams);
    }
}
