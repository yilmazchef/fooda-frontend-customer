package be.fooda.frontend.models.delivery;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class DeliveryCourier {

    @JsonIgnore
    private Long id;

    private Long externalCourierId;

    private String firstName;

    private String familyName;

    private String profilePhotoUrl;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getExternalCourierId() {
        return externalCourierId;
    }

    public void setExternalCourierId(Long externalCourierId) {
        this.externalCourierId = externalCourierId;
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

    public String getProfilePhotoUrl() {
        return profilePhotoUrl;
    }

    public void setProfilePhotoUrl(String profilePhotoUrl) {
        this.profilePhotoUrl = profilePhotoUrl;
    }
}
