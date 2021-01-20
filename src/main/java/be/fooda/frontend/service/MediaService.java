package be.fooda.frontend.service;

import be.fooda.frontend.models.Media.Media;
import be.fooda.frontend.models.product.Product;
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
public class MediaService {

    private final RestTemplate restTemplate;

    @Value("${fooda.media.service.url}")
    private String baseUrl;

    public MediaService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ResponseEntity getAll(int pageNo, int pageSize) {
        final String completeUrl = baseUrl + "getAllMedia?pageNo={pageNo}&pageSize={pageSize}";
        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("pageNo", pageNo);
        queryParams.put("pageSize", pageSize);
        return restTemplate.exchange(completeUrl, HttpMethod.GET, HttpEntity.EMPTY, Media[].class, queryParams);
    }

    public ResponseEntity create(Media media) {
        final String completeUrl = baseUrl + "addMedia";
        return restTemplate.exchange(completeUrl,HttpMethod.POST,new HttpEntity<>(media),String.class);

    }

    public ResponseEntity findById(Long id) {
        final String completeUrl = baseUrl + "findById?id={id}isActive={isActive}";
        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("id", id);
        return restTemplate.exchange(completeUrl, HttpMethod.GET, HttpEntity.EMPTY, Media[].class, queryParams);
    }

    public ResponseEntity searchByTitle(String title, int pageNo, int pageSize) {
        final String completeUrl = baseUrl + "searchByTitle?title={title}&pageNo={pageNo}&pageSize={pageSize}";
        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("title", title);
        queryParams.put("pageNo", pageNo);
        queryParams.put("pageSize", pageSize);
        return restTemplate.exchange(completeUrl, HttpMethod.GET, HttpEntity.EMPTY, Media[].class, queryParams);
    }
    public ResponseEntity searchMediaByUrl(String url, int pageNo, int pageSize) {
        final String completeUrl = baseUrl + "searchMediaByUrl?url={url}&pageNo={pageNo}&pageSize={pageSize}";
        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("url", url);
        queryParams.put("pageNo", pageNo);
        queryParams.put("pageSize", pageSize);
        return restTemplate.exchange(completeUrl, HttpMethod.GET, HttpEntity.EMPTY, Media[].class, queryParams);
    }
    public ResponseEntity search(Set<String> keywords, int pageNo, int pageSize) {
        final String completeUrl = baseUrl + "search?keywords={keywords}&pageNo={pageNo}&pageSize={pageSize}";
        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("keywords", keywords);
        queryParams.put("pageNo", pageNo);
        queryParams.put("pageSize", pageSize);
        return restTemplate.exchange(completeUrl, HttpMethod.GET,HttpEntity.EMPTY,Media[].class, queryParams);
    }
    public ResponseEntity existById(Long id) {
        final String completeUrl = baseUrl + "existsById?id={id}&isActive={isActive}";
        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("id", id);
        return restTemplate.exchange(completeUrl, HttpMethod.GET,HttpEntity.EMPTY,String.class, queryParams);
    }

    public ResponseEntity updateMedia(Long id, Media media) {
        final String completeUrl = baseUrl + "updateMedia/id=" + id;
        HttpEntity<Media> requestEntity = new HttpEntity<>(media);
        return restTemplate.exchange(completeUrl, HttpMethod.PUT, requestEntity, String.class);
    }
    public ResponseEntity deleteMedia(Long id) {
        final String completeUrl = baseUrl + "deleteMedia/id=" + id;
        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("id", id);
        return restTemplate.exchange(completeUrl, HttpMethod.PATCH, HttpEntity.EMPTY, String.class,queryParams);
    }
}
