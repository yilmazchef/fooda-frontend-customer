package be.fooda.frontend.model.courier;


import com.fasterxml.jackson.annotation.JsonIgnore;

public class CourierContact {

    @JsonIgnore
    private Long id;

    private Long externalContactId;

    private String phone;

    private String email;

    private Boolean canCall;

    private Boolean isDefault;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getExternalContactId() {
        return externalContactId;
    }

    public void setExternalContactId(Long externalContactId) {
        this.externalContactId = externalContactId;
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

    public Boolean getDefault() {
        return isDefault;
    }

    public void setDefault(Boolean aDefault) {
        isDefault = aDefault;
    }
}