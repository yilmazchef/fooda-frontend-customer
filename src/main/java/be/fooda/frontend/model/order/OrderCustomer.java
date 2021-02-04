package be.fooda.frontend.model.order;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class OrderCustomer {

    @JsonIgnore private Long id;
    private Long externalCustomerId;

    private String firstName;

    private String familyName;

    private String phone;

    public Long getId() {
        return id;
    }

    public Long getExternalCustomerId() {
        return externalCustomerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setExternalCustomerId(Long externalCustomerId) {
        this.externalCustomerId = externalCustomerId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}