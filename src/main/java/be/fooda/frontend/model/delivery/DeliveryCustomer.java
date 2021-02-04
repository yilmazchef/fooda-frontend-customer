package be.fooda.frontend.model.delivery;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class DeliveryCustomer {

    @JsonIgnore
    private Long id;

    private Long externalCustomerId;

    private String firstName;

    private String familyName;

     private String phone;

    private String email;

    private Boolean canCall;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getExternalCustomerId() {
        return externalCustomerId;
    }

    public void setExternalCustomerId(Long externalCustomerId) {
        this.externalCustomerId = externalCustomerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFamilyName() {
        return familyName;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getCanCall() {
        return canCall;
    }

    public void setCanCall(Boolean canCall) {
        this.canCall = canCall;
    }
}
