package be.fooda.frontend.models.basket.product;

public class BasketAddress {

    BasketUser user;

    private Long externalAddressId;

    private String title;

    private String postcode;

    private String municipality;

    private Boolean isDelivery;

    private Boolean isBilling;

    public BasketUser getUser() {
        return user;
    }

    public void setUser(BasketUser user) {
        this.user = user;
    }

    public Long getExternalAddressId() {
        return externalAddressId;
    }

    public void setExternalAddressId(Long externalAddressId) {
        this.externalAddressId = externalAddressId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getMunicipality() {
        return municipality;
    }

    public void setMunicipality(String municipality) {
        this.municipality = municipality;
    }

    public Boolean getDelivery() {
        return isDelivery;
    }

    public void setDelivery(Boolean delivery) {
        isDelivery = delivery;
    }

    public Boolean getBilling() {
        return isBilling;
    }

    public void setBilling(Boolean billing) {
        isBilling = billing;
    }
}
