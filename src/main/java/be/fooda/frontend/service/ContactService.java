package be.fooda.frontend.service;

import be.fooda.frontend.models.contact.Contact;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import javax.validation.constraints.Positive;
import java.util.HashMap;
import java.util.Map;

@Service
public class ContactService {

    private final RestTemplate restTemplate;

    @Value("${fooda.contact.service.url}")
    private String baseUrl;

    public ContactService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ResponseEntity getAllContacts(int pageNo, int pageSize) {
        final String completeUrl = baseUrl + "get_All_Contacts?pageNo={pageNo}&pageSize={pageSize}";
        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("pageNo", pageNo);
        queryParams.put("pageSize", pageSize);
        return restTemplate.exchange(completeUrl, HttpMethod.GET, HttpEntity.EMPTY, Contact[].class, queryParams);
    }

    public ResponseEntity contactExistsById(Long id) {
        final String completeUrl = baseUrl + "contact_Exists_By_Id?id={id}";
        return restTemplate.exchange(completeUrl, HttpMethod.GET, HttpEntity.EMPTY, String.class, id);
    }

    public ResponseEntity getContactById(Long id) {
        final String completeUrl = baseUrl + "get_Contact_By_Id?id={id}";
        return restTemplate.exchange(completeUrl, HttpMethod.GET, HttpEntity.EMPTY, Contact.class, id);
    }

    @GetMapping("get_Contact_details_By_user_Id")
    public ResponseEntity getContactByUserId(@RequestParam @Positive Long externalUserId) {
        final String completeUrl = baseUrl + "get_Contact_details_By_user_Id?externalUserId={externalUserId}";
        return restTemplate.exchange(completeUrl, HttpMethod.GET, HttpEntity.EMPTY, Contact[].class, externalUserId);
    }

    @PostMapping("add_Contact")
    public ResponseEntity addContact(Contact contact) {
        final String completeUrl = baseUrl + "add_Contact";
        return restTemplate.exchange(completeUrl, HttpMethod.POST, new HttpEntity<>(contact), String.class);
    }
}
