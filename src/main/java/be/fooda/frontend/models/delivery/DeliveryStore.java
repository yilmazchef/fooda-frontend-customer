package be.fooda.frontend.models.delivery;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class DeliveryStore {

    @JsonIgnore
    private Long id;

    private Long externalStoreId;

    private String address;

    private String storeName;

    private String phone;

    private String email;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getExternalStoreId() {
        return externalStoreId;
    }

    public void setExternalStoreId(Long externalStoreId) {
        this.externalStoreId = externalStoreId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
