package be.fooda.frontend.models.basket;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BasketAddress {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String id;

    private BasketUser user;

    private Long externalAddressId;

    private String title;

    private String postcode;

    private String municipality;

    private Boolean isDelivery;

    private Boolean isBilling;

    public String getId() {
        return id;
    }

    public BasketAddress setId(String id) {
        this.id = id;
        return this;
    }

    public BasketUser getUser() {
        return user;
    }

    public BasketAddress setUser(BasketUser user) {
        this.user = user;
        return this;
    }

    public Long getExternalAddressId() {
        return externalAddressId;
    }

    public BasketAddress setExternalAddressId(Long externalAddressId) {
        this.externalAddressId = externalAddressId;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public BasketAddress setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getPostcode() {
        return postcode;
    }

    public BasketAddress setPostcode(String postcode) {
        this.postcode = postcode;
        return this;
    }

    public String getMunicipality() {
        return municipality;
    }

    public BasketAddress setMunicipality(String municipality) {
        this.municipality = municipality;
        return this;
    }

    public Boolean getDelivery() {
        return isDelivery;
    }

    public BasketAddress setDelivery(Boolean delivery) {
        isDelivery = delivery;
        return this;
    }

    public Boolean getBilling() {
        return isBilling;
    }

    public BasketAddress setBilling(Boolean billing) {
        isBilling = billing;
        return this;
    }
}
