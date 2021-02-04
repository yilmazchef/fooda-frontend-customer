package be.fooda.frontend.model.courier;


import com.fasterxml.jackson.annotation.JsonIgnore;

public class CourierAddress {

    @JsonIgnore
    private Long id;

    private Long externalAddressId;

    private String postcode;

    private String municipality;

    private Boolean isDefault;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getExternalAddressId() {
        return externalAddressId;
    }

    public void setExternalAddressId(Long externalAddressId) {
        this.externalAddressId = externalAddressId;
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

    public Boolean getDefault() {
        return isDefault;
    }

    public void setDefault(Boolean aDefault) {
        isDefault = aDefault;
    }

}