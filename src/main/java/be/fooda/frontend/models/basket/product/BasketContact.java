package be.fooda.frontend.models.basket.product;

public class BasketContact {

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

    public BasketUser getUser() {
        return user;
    }

    public void setUser(BasketUser user) {
        this.user = user;
    }

    public Long getExternalContactId() {
        return externalContactId;
    }

    public void setExternalContactId(Long externalContactId) {
        this.externalContactId = externalContactId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
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
