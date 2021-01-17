package be.fooda.frontend.models.basket.product;

public class BasketStore {

    private Long externalStoreId;

    private String name;

    public Long getExternalStoreId() {
        return externalStoreId;
    }

    public void setExternalStoreId(Long externalStoreId) {
        this.externalStoreId = externalStoreId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
