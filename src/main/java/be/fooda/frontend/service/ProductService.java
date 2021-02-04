package be.fooda.frontend.service;

import be.fooda.frontend.model.product.Category;
import be.fooda.frontend.model.product.Ingredient;
import be.fooda.frontend.model.product.Product;
import be.fooda.frontend.model.product.Tag;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class ProductService {

    private static final String GET_ALL_CATEGORIES = "category/get_all_categories";
    private static final String GET_ALL_CATEGORIES_BY_PRODUCT_ID = "category/get_all_categories_by_product_id";
    private static final String ADD_CATEGORY_TO_PRODUCT = "category/add_category_to_product";
    private static final String DELETE_CATEGORY_BY_ID = "category/delete_category_by_id";
    private static final String DELETE_CATEGORY_BY_PRODUCT_ID = "category/delete_category_by_product_id";

    private static final String GET_ALL_PRODUCTS = "get_all_products";
    private static final String GET_ALL_TAGS = "get_all_tags";
    private static final String GET_ALL_TAGS_BY_PRODUCT_ID = "get_all_tags_by_product_id";
    private static final String SEARCH_BY_PRODUCT_NAME = "search_by_product_name";
    private static final String SEARCH_BY_DESCRIPTION = "search_by_description";
    private static final String SEARCH_BY_INGREDIENTS = "search_by_ingredients";
    private static final String SEARCH_BY_CATEGORIES = "search_by_categories";
    private static final String SEARCH_BY_TAGS = "search_by_tags";
    private static final String FILTER_BY_PRICE_RANGE = "filter_by_price_range";
    private static final String SEARCH_BY_STORE_NAME = "search_by_store_name";
    private static final String FILTER_BY_FEATURED = "filter_by_featured";
    private static final String CREATE_SINGLE_PRODUCT = "create_single_product";
    private static final String CREATE_LIST_OF_PRODUCTS = "create_list_of_products";
    private static final String GET_BY_PRODUCT_ID = "get_by_product_id";
    private static final String COMBINED_SEARCH = "combined_search";
    private static final String EXISTS_BY_PRODUCT_ID = "exists_by_product_id";
    private static final String GET_ALL_INGREDIENTS_BY_PRODUCT_ID = "get_all_ingredients_by_product_id";
    private static final String UPDATE_PRODUCT_INFO = "update_product_info";
    private static final String UPDATE_PRODUCT_BY_ID = "update_product_by_id";
    private static final String DELETE_PRODUCT_BY_ID = "delete_product_by_id";
    private static final Integer DEFAULT_PAGE_NO = 1;
    private static final Integer RESULTS_PER_PAGE = 10;


    private final RestTemplate restTemplate;

    @Value("${fooda.product.service.url}")
    private String baseUrl;

    public ProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ResponseEntity getAll(int pageNo, int pageSize) {
        final String completeUrl = "https://fooda-backend-product.herokuapp.com/get_all_products?pageNo={pageNo}&pageSize={pageSize}";
        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("pageNo", pageNo);
        queryParams.put("pageSize", pageSize);

        UriComponentsBuilder.fromHttpUrl(completeUrl);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Authorization", "true");

        return restTemplate.exchange(completeUrl, HttpMethod.GET, new HttpEntity<>(httpHeaders), Product[].class, queryParams);
    }

    public ResponseEntity getAllCategories() {
        final String completeUrl = baseUrl + GET_ALL_CATEGORIES;
        return restTemplate.exchange(completeUrl, HttpMethod.GET, HttpEntity.EMPTY, Category[].class);
    }

    public ResponseEntity getAllTags() {
        final String completeUrl = baseUrl + GET_ALL_TAGS;
        return restTemplate.exchange(completeUrl, HttpMethod.GET, HttpEntity.EMPTY, Tag[].class);
    }

    public ResponseEntity searchByName(String productName, int pageNo, int pageSize) {
        final String completeUrl = baseUrl + SEARCH_BY_PRODUCT_NAME + "?productName={productName}&pageNo={pageNo}&pageSize={pageSize}";
        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("productName", productName);
        queryParams.put("pageNo", pageNo);
        queryParams.put("pageSize", pageSize);
        return restTemplate.exchange(completeUrl, HttpMethod.GET, HttpEntity.EMPTY, Product[].class, queryParams);
    }

    public ResponseEntity searchByDescription(String description, int pageNo, int pageSize) {
        final String completeUrl = baseUrl + SEARCH_BY_DESCRIPTION + "?description={description}&pageNo={pageNo}&pageSize={pageSize}";
        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("description", description);
        queryParams.put("pageNo", pageNo);
        queryParams.put("pageSize", pageSize);
        return restTemplate.exchange(completeUrl, HttpMethod.GET, HttpEntity.EMPTY, Product[].class, queryParams);
    }

    public ResponseEntity searchByIngredients(Set<String> ingredients, int pageNo, int pageSize) {
        final String completeUrl = baseUrl + SEARCH_BY_INGREDIENTS + "?ingredients={ingredients}&pageNo={pageNo}&pageSize={pageSize}";
        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("ingredients", ingredients);
        queryParams.put("pageNo", pageNo);
        queryParams.put("pageSize", pageSize);
        return restTemplate.exchange(completeUrl, HttpMethod.GET, HttpEntity.EMPTY, Product[].class, queryParams);
    }

    public ResponseEntity searchByCategories(Set<String> categories, int pageNo, int pageSize) {
        final String completeUrl = baseUrl + SEARCH_BY_CATEGORIES + "?categories={categories}&pageNo={pageNo}&pageSize={pageSize}";
        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("categories", categories);
        queryParams.put("pageNo", pageNo);
        queryParams.put("pageSize", pageSize);
        return restTemplate.exchange(completeUrl, HttpMethod.GET, HttpEntity.EMPTY, Product[].class, queryParams);
    }

    public ResponseEntity searchByTags(Set<String> tags, int pageNo, int pageSize) {
        final String completeUrl = baseUrl + SEARCH_BY_TAGS + "?tags={tags}&pageNo={pageNo}&pageSize={pageSize}";
        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("tags", tags);
        queryParams.put("pageNo", pageNo);
        queryParams.put("pageSize", pageSize);
        return restTemplate.exchange(completeUrl, HttpMethod.GET, HttpEntity.EMPTY, Product[].class, queryParams);
    }

    public ResponseEntity searchByPriceRange(BigDecimal minPrice, BigDecimal maxPrice, int pageNo, int pageSize) {
        final String completeUrl = baseUrl + FILTER_BY_PRICE_RANGE + "?minPrice={minPrice}&maxPrice={maxPrice}&pageNo={pageNo}&pageSize={pageSize}&isActive={isActive}";
        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("minPrice", minPrice);
        queryParams.put("maxPrice", maxPrice);
        queryParams.put("pageNo", pageNo);
        queryParams.put("pageSize", pageSize);
        return restTemplate.exchange(completeUrl, HttpMethod.GET, HttpEntity.EMPTY, Product[].class, queryParams);
    }

    public ResponseEntity searchByStoreName(String storeName, int pageNo, int pageSize) {
        final String completeUrl = baseUrl + SEARCH_BY_STORE_NAME + "?storeName={storeName}&pageNo={pageNo}&pageSize={pageSize}";
        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("storeName", storeName);
        queryParams.put("pageNo", pageNo);
        queryParams.put("pageSize", pageSize);
        return restTemplate.exchange(completeUrl, HttpMethod.GET, HttpEntity.EMPTY, Product[].class, queryParams);
    }

    public ResponseEntity filterByFeature(int pageNo, int pageSize) {
        final String completeUrl = baseUrl + FILTER_BY_FEATURED + "?isFeatured={isFeatured}&pageNo={pageNo}&pageSize={pageSize}";
        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("pageNo", pageNo);
        queryParams.put("pageSize", pageSize);
        return restTemplate.exchange(completeUrl, HttpMethod.GET, HttpEntity.EMPTY, Product[].class, queryParams);
    }

    public ResponseEntity create(Product product) {
        final String completeUrl = baseUrl + CREATE_SINGLE_PRODUCT;
        return restTemplate.exchange(completeUrl, HttpMethod.POST, new HttpEntity<>(product), String.class);
    }

    public ResponseEntity create(List<Product> products) {
        final String completeUrl = baseUrl + CREATE_LIST_OF_PRODUCTS;
        return restTemplate.exchange(completeUrl, HttpMethod.POST, new HttpEntity<>(products), String.class);
    }

    public ResponseEntity findById(Long id, boolean isActive) {
        final String completeUrl = baseUrl + GET_BY_PRODUCT_ID + "?id={id}&isActive={isActive}";
        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("id", id);
        queryParams.put("isActive", isActive);
        return restTemplate.exchange(completeUrl, HttpMethod.GET, HttpEntity.EMPTY, Product.class, queryParams);
    }

    public ResponseEntity existById(Long id) {
        final String completeUrl = baseUrl + EXISTS_BY_PRODUCT_ID + "?id={id}&isActive={isActive}";
        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("id", id);
        return restTemplate.exchange(completeUrl, HttpMethod.GET, HttpEntity.EMPTY, String.class, queryParams);
    }

    public ResponseEntity search(Set<String> keywords, int pageNo, int pageSize) {
        final String completeUrl = baseUrl + COMBINED_SEARCH + "?keywords={keywords}&pageNo={pageNo}&pageSize={pageSize}";
        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("keywords", keywords);
        queryParams.put("pageNo", pageNo);
        queryParams.put("pageSize", pageSize);
        return restTemplate.exchange(completeUrl, HttpMethod.GET, HttpEntity.EMPTY, Product[].class, queryParams);
    }

    public ResponseEntity getIngredientsByProductId(Long productId) {
        final String completeUrl = baseUrl + GET_ALL_INGREDIENTS_BY_PRODUCT_ID + "?productId={productId}";
        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("productId", productId);
        return restTemplate.exchange(completeUrl, HttpMethod.GET, HttpEntity.EMPTY, Ingredient[].class, queryParams);
    }

    public ResponseEntity updateProductInfo(Long id, String productName, String productDescription,
                                            Integer limitPerOrder, Boolean isFeatured, String type) {
        final String completeUrl = baseUrl + UPDATE_PRODUCT_INFO +
                "?id={id}&" +
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


    public ResponseEntity deleteProduct(Long id) {
        final String completeUrl = baseUrl + DELETE_PRODUCT_BY_ID + "/id=" + id;
        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("id", id);
        return restTemplate.exchange(completeUrl, HttpMethod.PATCH, HttpEntity.EMPTY, String.class, queryParams);
    }

}
