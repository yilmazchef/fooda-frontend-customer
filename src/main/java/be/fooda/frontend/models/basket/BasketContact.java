package be.fooda.frontend.models.basket;

import com.fasterxml.jackson.annotation.JsonProperty;


public class BasketContact {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String id;

    private BasketUser user;

    private Long externalContactId;

    private String title;

    private String familyName;

    private String firstName;

    private String companyName;

    private String phone;

    private String email;

    private Boolean isDelivery;

    private Boolean isBilling;

    public String getId() {
        return id;
    }

    public BasketContact setId(String id) {
        this.id = id;
        return this;
    }

    public BasketUser getUser() {
        return user;
    }

    public BasketContact setUser(BasketUser user) {
        this.user = user;
        return this;
    }

    public Long getExternalContactId() {
        return externalContactId;
    }

    public BasketContact setExternalContactId(Long externalContactId) {
        this.externalContactId = externalContactId;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public BasketContact setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getFamilyName() {
        return familyName;
    }

    public BasketContact setFamilyName(String familyName) {
        this.familyName = familyName;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public BasketContact setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getCompanyName() {
        return companyName;
    }

    public BasketContact setCompanyName(String companyName) {
        this.companyName = companyName;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public BasketContact setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public BasketContact setEmail(String email) {
        this.email = email;
        return this;
    }

    public Boolean getDelivery() {
        return isDelivery;
    }

    public BasketContact setDelivery(Boolean delivery) {
        isDelivery = delivery;
        return this;
    }

    public Boolean getBilling() {
        return isBilling;
    }

    public BasketContact setBilling(Boolean billing) {
        isBilling = billing;
        return this;
    }
}
