package be.fooda.frontend.service;

import be.fooda.frontend.models.address.Address;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AddressService {

    private final RestTemplate restTemplate;

    @Value("${fooda.address.service.url}")
    private String baseUrl;

    public AddressService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ResponseEntity addAddress(Address address) {
        final String completeUrl = baseUrl + "add_address";
        return restTemplate.exchange(completeUrl, HttpMethod.POST, new HttpEntity<>(address), String.class);
    }

    public ResponseEntity getAll() {
        final String completeUrl = baseUrl + "get_all_addresses";
        return restTemplate.exchange(completeUrl, HttpMethod.GET, HttpEntity.EMPTY, Address[].class);
    }

    public ResponseEntity getAddressById(Long id) {
        final String completeUrl = baseUrl + "get_address_by_id?id={id}";
        return restTemplate.exchange(completeUrl, HttpMethod.GET, HttpEntity.EMPTY, Address.class, id);
    }

    public ResponseEntity getAddressByUserId(Long externalUserId){
        final String completeUrl = baseUrl + "get_by_external_user_id?externalUserId={externalUserId}";
        return restTemplate.exchange(completeUrl, HttpMethod.GET, HttpEntity.EMPTY, Address[].class, externalUserId);
    }

//    @GetMapping("filter_By_Geolocation")
//    public ResponseEntity filterByGeolocation(@RequestParam String latitude, @RequestParam String longitude) {
//        return ResponseEntity.status(HttpStatus.FOUND).body(indexRepository.filterByGeolocation(latitude, longitude));
//    }

    public ResponseEntity deleteAddressById(Long id){
        final String completeUrl = baseUrl + "delete_address?id={id}";
        return restTemplate.exchange(completeUrl, HttpMethod.DELETE, HttpEntity.EMPTY, String.class, id);
    }

}
