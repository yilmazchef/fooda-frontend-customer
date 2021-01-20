package be.fooda.frontend.models.store;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class store {
    public class FoodaStore {


        private Long id;


        private String storeName;


        private String slogan;


        private String type;

        private Long parentId;


        private String about;

        private Boolean isActive = Boolean.TRUE;


        private LocalDateTime registryTime;


        private LocalDateTime updateTime;

        private storeAuth auth;

        private storeUser user;


        private List<storeImage> images;


        private storeAddress address;


        private storeContact contact;


        private List<storeMenuItem> menuItems;


        private List<storeAcceptedPaymentMethod> acceptedPaymentMethods;

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

        public storeAuth getAuth() {
            return auth;
        }

        public void setAuth(storeAuth auth) {
            this.auth = auth;
        }

        public storeUser getUser() {
            return user;
        }

        public void setUser(storeUser user) {
            this.user = user;
        }

        public List<storeImage> getImages() {
            return images;
        }

        public void setImages(List<storeImage> images) {
            this.images = images;
        }

        public storeAddress getAddress() {
            return address;
        }

        public void setAddress(storeAddress address) {
            this.address = address;
        }

        public storeContact getContact() {
            return contact;
        }

        public void setContact(storeContact contact) {
            this.contact = contact;
        }

        public List<storeMenuItem> getMenuItems() {
            return menuItems;
        }

        public void setMenuItems(List<storeMenuItem> menuItems) {
            this.menuItems = menuItems;
        }

        public List<storeAcceptedPaymentMethod> getAcceptedPaymentMethods() {
            return acceptedPaymentMethods;
        }

        public void setAcceptedPaymentMethods(List<storeAcceptedPaymentMethod> acceptedPaymentMethods) {
            this.acceptedPaymentMethods = acceptedPaymentMethods;
        }

        public List<storeDeliveryLocation> getDeliveryLocations() {
            return deliveryLocations;
        }

        public void setDeliveryLocations(List<storeDeliveryLocation> deliveryLocations) {
            this.deliveryLocations = deliveryLocations;
        }

        public List<storeWorkingHours> getWorkingHours() {
            return workingHours;
        }

        public void setWorkingHours(List<storeWorkingHours> workingHours) {
            this.workingHours = workingHours;
        }

        private List<storeDeliveryLocation> deliveryLocations;


        private List<storeWorkingHours> workingHours;


    }

}
