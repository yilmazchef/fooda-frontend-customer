package be.fooda.frontend.service;

import be.fooda.frontend.models.basket.product.BasketProduct;
import com.vaadin.flow.server.VaadinSession;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class BasketService {

    private final RestTemplate restTemplate;

    @Value("${fooda.basket.service.url}")
    private String baseUrl;

    public BasketService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ResponseEntity<BasketProduct[]> getAllProductsByUser() {
        final String completeUrl = baseUrl +
                "getProductsByUserAndStore?" +
                "externalUserId={externalUserId}" +
                "&userSession={userSession}";
        return restTemplate.getForEntity(completeUrl, BasketProduct[].class,
                VaadinSession.getCurrent().getAttribute("externalUserId"),
                VaadinSession.getCurrent().getSession().getId());
    }

    public ResponseEntity<String> addProductToBasket(BasketProduct basketProduct) {
        final String completeUrl = "addProduct";
        return restTemplate.postForEntity(completeUrl, basketProduct, String.class);
    }

    public ResponseEntity<String> updateProductQuantity(
            Long externalProductId, Long externalUserId, String userSession, Integer newQuantity) {
        final String completeUrl = "updateProductQuantity";

        return restTemplate.exchange(completeUrl, HttpMethod.PATCH, HttpEntity.EMPTY, String.class,
                externalProductId, externalUserId, userSession, newQuantity);
    }
}
