package be.fooda.frontend.service;

import be.fooda.frontend.models.product.Product;
import be.fooda.frontend.models.product.ProductCategory;
import be.fooda.frontend.models.product.ProductIngredient;
import be.fooda.frontend.models.product.ProductTag;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class ProductService {

    private final RestTemplate restTemplate;

    @Value("${fooda.product.service.url}")
    private String baseUrl;

    public ProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ResponseEntity getAll(int pageNo, int pageSize) {
        final String completeUrl = baseUrl + "getAllProducts?pageNo={pageNo}&pageSize={pageSize}";
        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("pageNo", pageNo);
        queryParams.put("pageSize", pageSize);
        return restTemplate.exchange(completeUrl, HttpMethod.GET, HttpEntity.EMPTY, Product[].class, queryParams);
    }

    public ResponseEntity getAllCategories() {
        final String completeUrl = baseUrl + "getAllCategories";
        return restTemplate.exchange(completeUrl, HttpMethod.GET, HttpEntity.EMPTY, ProductCategory[].class);
    }

    public ResponseEntity getAllTags() {
        final String completeUrl = baseUrl + "getAllTags";
        return restTemplate.exchange(completeUrl, HttpMethod.GET, HttpEntity.EMPTY, ProductTag[].class);
    }

    public ResponseEntity searchByName(String productName, int pageNo, int pageSize) {
        final String completeUrl = baseUrl + "productName?productName={productName}&pageNo={pageNo}&pageSize={pageSize}";
        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("productName",productName);
        queryParams.put("pageNo", pageNo);
        queryParams.put("pageSize", pageSize);
        return restTemplate.exchange(completeUrl,HttpMethod.GET,HttpEntity.EMPTY,Product[].class,queryParams);
    }

    public ResponseEntity searchByDescription(String description, int pageNo, int pageSize) {
        final String completeUrl = baseUrl + "description?description={description}&pageNo={pageNo}&pageSize={pageSize}";
        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("description",description);
        queryParams.put("pageNo", pageNo);
        queryParams.put("pageSize", pageSize);
        return restTemplate.exchange(completeUrl,HttpMethod.GET,HttpEntity.EMPTY, Product[].class, queryParams);
    }

    public ResponseEntity searchByIngredients(Set<String> ingredients, int pageNo, int pageSize) {
        final String completeUrl = baseUrl + "ingredients?ingredients={ingredients}&pageNo={pageNo}&pageSize={pageSize}";
        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("ingredients",ingredients);
        queryParams.put("pageNo", pageNo);
        queryParams.put("pageSize", pageSize);
        return restTemplate.exchange(completeUrl,HttpMethod.GET,HttpEntity.EMPTY, Product[].class, queryParams);
    }

    public ResponseEntity searchByCategories(Set<String> categories, int pageNo, int pageSize) {
        final String completeUrl = baseUrl + "categories?categories={categories}&pageNo={pageNo}&pageSize={pageSize}";
        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("categories",categories);
        queryParams.put("pageNo", pageNo);
        queryParams.put("pageSize", pageSize);
        return restTemplate.exchange(completeUrl,HttpMethod.GET,HttpEntity.EMPTY, Product[].class, queryParams);
    }

    public ResponseEntity searchByTags(Set<String> tags, int pageNo, int pageSize) {
        final String completeUrl = baseUrl + "tags?tags={tags}&pageNo={pageNo}&pageSize={pageSize}";
        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("tags",tags);
        queryParams.put("pageNo", pageNo);
        queryParams.put("pageSize", pageSize);
        return restTemplate.exchange(completeUrl,HttpMethod.GET,HttpEntity.EMPTY, Product[].class,queryParams);
    }

    public ResponseEntity searchByPriceRange(BigDecimal minPrice, BigDecimal maxPrice, int pageNo, int pageSize) {
        final String completeUrl = baseUrl + "priceRange?minPrice={minPrice}&maxPrice={maxPrice}&pageNo={pageNo}&pageSize={pageSize}&isActive={isActive}";
        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("minPrice",minPrice);
        queryParams.put("maxPrice",maxPrice);
        queryParams.put("pageNo", pageNo);
        queryParams.put("pageSize", pageSize);
        return restTemplate.exchange(completeUrl,HttpMethod.GET,HttpEntity.EMPTY, Product[].class, queryParams);
    }

    public ResponseEntity searchByStoreName(String storeName, int pageNo, int pageSize) {
        final String completeUrl = baseUrl + "searchByStoreName?storeName={storeName}&pageNo={pageNo}&pageSize={pageSize}";
        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("storeName",storeName);
        queryParams.put("pageNo", pageNo);
        queryParams.put("pageSize", pageSize);
        return restTemplate.exchange(completeUrl,HttpMethod.GET,HttpEntity.EMPTY, Product[].class, queryParams);
    }

    public ResponseEntity filterByFeature(int pageNo, int pageSize) {
        final String completeUrl = baseUrl + "isFeatured?isFeatured={isFeatured}&pageNo={pageNo}&pageSize={pageSize}";
        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("pageNo", pageNo);
        queryParams.put("pageSize", pageSize);
        return restTemplate.exchange(completeUrl,HttpMethod.GET,HttpEntity.EMPTY, Product[].class, queryParams);
    }

    public ResponseEntity create(Product product) {
        final String completeUrl = baseUrl + "createProduct";
        return restTemplate.exchange(completeUrl,HttpMethod.POST,new HttpEntity<>(product), String.class);
    }

    public ResponseEntity create(List<Product> products) {
        final String completeUrl = baseUrl + "createListOfProducts";
        return restTemplate.exchange(completeUrl,HttpMethod.POST,new HttpEntity<>(products), String.class);
    }

    public ResponseEntity findById(Long id,boolean isActive) {
        final String completeUrl = baseUrl + "findProductById?id={id}&isActive={isActive}";
        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("id", id);
        queryParams.put("isActive", isActive);
        return restTemplate.exchange(completeUrl,HttpMethod.GET,HttpEntity.EMPTY, Product.class, queryParams);
    }

    public ResponseEntity existById(Long id) {
        final String completeUrl = baseUrl + "existProductById?id={id}&isActive={isActive}";
        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("id", id);
        return restTemplate.exchange(completeUrl,HttpMethod.GET,HttpEntity.EMPTY, String.class, queryParams);
    }

    public ResponseEntity search(Set<String> keywords, int pageNo, int pageSize) {
        final String completeUrl = baseUrl + "search?keywords={keywords}&pageNo={pageNo}&pageSize={pageSize}";
        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("keywords", keywords);
        queryParams.put("pageNo", pageNo);
        queryParams.put("pageSize", pageSize);
        return restTemplate.exchange(completeUrl,HttpMethod.GET,HttpEntity.EMPTY, Product[].class, queryParams);
    }

    public ResponseEntity getIngredientsByProductId(Long productId) {
        final String completeUrl = baseUrl + "getAllIngredientsByProductId?productId={productId}";
        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("productId", productId);
        return restTemplate.exchange(completeUrl,HttpMethod.GET,HttpEntity.EMPTY, ProductIngredient[].class, queryParams);
    }

    public ResponseEntity updateProductInfo(Long id, String productName, String productDescription,
                                            Integer limitPerOrder, Boolean isFeatured, String type) {
        final String completeUrl = baseUrl + "updateProductInfo?" +
                "id={id}&" +
                "productName={productName}&" +
                "productDescription={productDescription}&" +
                "limitPerOrder={limitPerOrder}&" +
                "isFeatured={isFeatured}&" +
                "type={type}";

        Map<String, Object> params = new HashMap<>();
        params.put("id", id);
        params.put("productName", productName);
        params.put("productDescription", productDescription);
        params.put("limitPerOrder", limitPerOrder);
        params.put("isFeatured", isFeatured);
        params.put("type", type);

        return restTemplate.exchange(completeUrl, HttpMethod.PUT, HttpEntity.EMPTY, String.class, params);
    }

    public ResponseEntity updateProduct(Long id, Product product) {
        final String completeUrl = baseUrl + "updateProduct/id=" + id;
        HttpEntity<Product> requestEntity = new HttpEntity<>(product);
        return restTemplate.exchange(completeUrl, HttpMethod.PATCH, requestEntity, String.class);
    }

    public ResponseEntity deleteProduct(Long id) {
        final String completeUrl = baseUrl + "deleteProduct/id=" + id;
        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("id", id);
        return restTemplate.exchange(completeUrl, HttpMethod.PATCH, HttpEntity.EMPTY, String.class,queryParams);
    }

}
