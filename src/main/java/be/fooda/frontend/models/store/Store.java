package be.fooda.frontend.models.store;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;
import java.util.List;

public class Store {
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;

    private String storeName;

    private String slogan;

    private String type;

    private Long parentId;

    private String about;

    private Boolean isActive = Boolean.TRUE;


    private LocalDateTime registryTime;


    private LocalDateTime updateTime;

    private StoreAuth auth;

    private StoreUser user;

    private List<StoreImage> images;

    private StoreAddress address;

    private StoreContact contact;

    private List<StoreMenuItem> menuItems;

    private List<StoreAcceptedPaymentMethod> acceptedPaymentMethods;

    private List<StoreDeliveryLocation> deliveryLocations;


    private List<StoreWorkingHours> workingHours;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getSlogan() {
        return slogan;
    }

    public void setSlogan(String slogan) {
        this.slogan = slogan;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public LocalDateTime getRegistryTime() {
        return registryTime;
    }

    public void setRegistryTime(LocalDateTime registryTime) {
        this.registryTime = registryTime;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    public StoreAuth getAuth() {
        return auth;
    }

    public void setAuth(StoreAuth auth) {
        this.auth = auth;
    }

    public StoreUser getUser() {
        return user;
    }

    public void setUser(StoreUser user) {
        this.user = user;
    }

    public List<StoreImage> getImages() {
        return images;
    }

    public void setImages(List<StoreImage> images) {
        this.images = images;
    }

    public StoreAddress getAddress() {
        return address;
    }

    public void setAddress(StoreAddress address) {
        this.address = address;
    }

    public StoreContact getContact() {
        return contact;
    }

    public void setContact(StoreContact contact) {
        this.contact = contact;
    }

    public List<StoreMenuItem> getMenuItems() {
        return menuItems;
    }

    public void setMenuItems(List<StoreMenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    public List<StoreAcceptedPaymentMethod> getAcceptedPaymentMethods() {
        return acceptedPaymentMethods;
    }

    public void setAcceptedPaymentMethods(List<StoreAcceptedPaymentMethod> acceptedPaymentMethods) {
        this.acceptedPaymentMethods = acceptedPaymentMethods;
    }

    public List<StoreDeliveryLocation> getDeliveryLocations() {
        return deliveryLocations;
    }

    public void setDeliveryLocations(List<StoreDeliveryLocation> deliveryLocations) {
        this.deliveryLocations = deliveryLocations;
    }

    public List<StoreWorkingHours> getWorkingHours() {
        return workingHours;
    }

    public void setWorkingHours(List<StoreWorkingHours> workingHours) {
        this.workingHours = workingHours;
    }




}
