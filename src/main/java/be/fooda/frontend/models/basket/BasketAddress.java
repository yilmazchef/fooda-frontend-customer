package be.fooda.frontend.models.basket;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class BasketAddress {

    @Id
    private String id;

    private BasketUser user;

    private Long externalAddressId;

    private String title;

    private String postcode;

    private String municipality;

    private Boolean isDelivery;

    private Boolean isBilling;

    public BasketAddress() {
    }

    public String getId() {
        return this.id;
    }

    public BasketUser getUser() {
        return this.user;
    }

    public Long getExternalAddressId() {
        return this.externalAddressId;
    }

    public String getTitle() {
        return this.title;
    }

    public String getPostcode() {
        return this.postcode;
    }

    public String getMunicipality() {
        return this.municipality;
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

    public void setExternalAddressId(Long externalAddressId) {
        this.externalAddressId = externalAddressId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public void setMunicipality(String municipality) {
        this.municipality = municipality;
    }

    public void setIsDelivery(Boolean isDelivery) {
        this.isDelivery = isDelivery;
    }

    public void setIsBilling(Boolean isBilling) {
        this.isBilling = isBilling;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof BasketAddress)) return false;
        final BasketAddress other = (BasketAddress) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$user = this.getUser();
        final Object other$user = other.getUser();
        if (this$user == null ? other$user != null : !this$user.equals(other$user)) return false;
        final Object this$externalAddressId = this.getExternalAddressId();
        final Object other$externalAddressId = other.getExternalAddressId();
        if (this$externalAddressId == null ? other$externalAddressId != null : !this$externalAddressId.equals(other$externalAddressId))
            return false;
        final Object this$title = this.getTitle();
        final Object other$title = other.getTitle();
        if (this$title == null ? other$title != null : !this$title.equals(other$title)) return false;
        final Object this$postcode = this.getPostcode();
        final Object other$postcode = other.getPostcode();
        if (this$postcode == null ? other$postcode != null : !this$postcode.equals(other$postcode)) return false;
        final Object this$municipality = this.getMunicipality();
        final Object other$municipality = other.getMunicipality();
        if (this$municipality == null ? other$municipality != null : !this$municipality.equals(other$municipality))
            return false;
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
        return other instanceof BasketAddress;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $user = this.getUser();
        result = result * PRIME + ($user == null ? 43 : $user.hashCode());
        final Object $externalAddressId = this.getExternalAddressId();
        result = result * PRIME + ($externalAddressId == null ? 43 : $externalAddressId.hashCode());
        final Object $title = this.getTitle();
        result = result * PRIME + ($title == null ? 43 : $title.hashCode());
        final Object $postcode = this.getPostcode();
        result = result * PRIME + ($postcode == null ? 43 : $postcode.hashCode());
        final Object $municipality = this.getMunicipality();
        result = result * PRIME + ($municipality == null ? 43 : $municipality.hashCode());
        final Object $isDelivery = this.getIsDelivery();
        result = result * PRIME + ($isDelivery == null ? 43 : $isDelivery.hashCode());
        final Object $isBilling = this.getIsBilling();
        result = result * PRIME + ($isBilling == null ? 43 : $isBilling.hashCode());
        return result;
    }

    public String toString() {
        return "FoodaBasketAddress(id=" + this.getId() + ", user=" + this.getUser() + ", externalAddressId=" + this.getExternalAddressId() + ", title=" + this.getTitle() + ", postcode=" + this.getPostcode() + ", municipality=" + this.getMunicipality() + ", isDelivery=" + this.getIsDelivery() + ", isBilling=" + this.getIsBilling() + ")";
    }
}
