package be.fooda.frontend.model.basket;

public class BasketContact {

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

    public BasketContact() {
    }

    public String getId() {
        return this.id;
    }

    public BasketUser getUser() {
        return this.user;
    }

    public Long getExternalContactId() {
        return this.externalContactId;
    }

    public String getTitle() {
        return this.title;
    }

    public String getFamilyName() {
        return this.familyName;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getCompanyName() {
        return this.companyName;
    }

    public String getPhone() {
        return this.phone;
    }

    public String getEmail() {
        return this.email;
    }

    public Boolean getIsDelivery() {
        return this.isDelivery;
    }

    public Boolean getIsBilling() {
        return this.isBilling;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setUser(BasketUser user) {
        this.user = user;
    }

    public void setExternalContactId(Long externalContactId) {
        this.externalContactId = externalContactId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setIsDelivery(Boolean isDelivery) {
        this.isDelivery = isDelivery;
    }

    public void setIsBilling(Boolean isBilling) {
        this.isBilling = isBilling;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof BasketContact)) return false;
        final BasketContact other = (BasketContact) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$user = this.getUser();
        final Object other$user = other.getUser();
        if (this$user == null ? other$user != null : !this$user.equals(other$user)) return false;
        final Object this$externalContactId = this.getExternalContactId();
        final Object other$externalContactId = other.getExternalContactId();
        if (this$externalContactId == null ? other$externalContactId != null : !this$externalContactId.equals(other$externalContactId))
            return false;
        final Object this$title = this.getTitle();
        final Object other$title = other.getTitle();
        if (this$title == null ? other$title != null : !this$title.equals(other$title)) return false;
        final Object this$familyName = this.getFamilyName();
        final Object other$familyName = other.getFamilyName();
        if (this$familyName == null ? other$familyName != null : !this$familyName.equals(other$familyName))
            return false;
        final Object this$firstName = this.getFirstName();
        final Object other$firstName = other.getFirstName();
        if (this$firstName == null ? other$firstName != null : !this$firstName.equals(other$firstName)) return false;
        final Object this$companyName = this.getCompanyName();
        final Object other$companyName = other.getCompanyName();
        if (this$companyName == null ? other$companyName != null : !this$companyName.equals(other$companyName))
            return false;
        final Object this$phone = this.getPhone();
        final Object other$phone = other.getPhone();
        if (this$phone == null ? other$phone != null : !this$phone.equals(other$phone)) return false;
        final Object this$email = this.getEmail();
        final Object other$email = other.getEmail();
        if (this$email == null ? other$email != null : !this$email.equals(other$email)) return false;
        final Object this$isDelivery = this.getIsDelivery();
        final Object other$isDelivery = other.getIsDelivery();
        if (this$isDelivery == null ? other$isDelivery != null : !this$isDelivery.equals(other$isDelivery))
            return false;
        final Object this$isBilling = this.getIsBilling();
        final Object other$isBilling = other.getIsBilling();
        if (this$isBilling == null ? other$isBilling != null : !this$isBilling.equals(other$isBilling)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof BasketContact;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $user = this.getUser();
        result = result * PRIME + ($user == null ? 43 : $user.hashCode());
        final Object $externalContactId = this.getExternalContactId();
        result = result * PRIME + ($externalContactId == null ? 43 : $externalContactId.hashCode());
        final Object $title = this.getTitle();
        result = result * PRIME + ($title == null ? 43 : $title.hashCode());
        final Object $familyName = this.getFamilyName();
        result = result * PRIME + ($familyName == null ? 43 : $familyName.hashCode());
        final Object $firstName = this.getFirstName();
        result = result * PRIME + ($firstName == null ? 43 : $firstName.hashCode());
        final Object $companyName = this.getCompanyName();
        result = result * PRIME + ($companyName == null ? 43 : $companyName.hashCode());
        final Object $phone = this.getPhone();
        result = result * PRIME + ($phone == null ? 43 : $phone.hashCode());
        final Object $email = this.getEmail();
        result = result * PRIME + ($email == null ? 43 : $email.hashCode());
        final Object $isDelivery = this.getIsDelivery();
        result = result * PRIME + ($isDelivery == null ? 43 : $isDelivery.hashCode());
        final Object $isBilling = this.getIsBilling();
        result = result * PRIME + ($isBilling == null ? 43 : $isBilling.hashCode());
        return result;
    }

    public String toString() {
        return "FoodaBasketContact(id=" + this.getId() + ", user=" + this.getUser() + ", externalContactId=" + this.getExternalContactId() + ", title=" + this.getTitle() + ", familyName=" + this.getFamilyName() + ", firstName=" + this.getFirstName() + ", companyName=" + this.getCompanyName() + ", phone=" + this.getPhone() + ", email=" + this.getEmail() + ", isDelivery=" + this.getIsDelivery() + ", isBilling=" + this.getIsBilling() + ")";
    }
}
