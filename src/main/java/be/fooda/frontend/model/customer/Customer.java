package be.fooda.frontend.model.customer;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class Customer {

    @JsonIgnore
    private Long id;

    private Boolean isActive = Boolean.TRUE;

    private String validation;

    private String firstName;

    private String familyName;

    private LocalDate dateOfBirth;

    private LocalDateTime registryDateTime;

    private LocalDateTime updateDateTime;

    private String note;

    private CustomerUser user;

    private CustomerAddress currentAddress;

    private CustomerContact currentContact;

    private List<CustomerPayment> paymentOptions;

    private List<CustomerProduct> favoriteProducts;

    private List<CustomerOrder> favoriteOrders;

    private List<CustomerStore> favoriteStores;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public String getValidation() {
        return validation;
    }

    public void setValidation(String validation) {
        this.validation = validation;
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

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public LocalDateTime getRegistryDateTime() {
        return registryDateTime;
    }

    public void setRegistryDateTime(LocalDateTime registryDateTime) {
        this.registryDateTime = registryDateTime;
    }

    public LocalDateTime getUpdateDateTime() {
        return updateDateTime;
    }

    public void setUpdateDateTime(LocalDateTime updateDateTime) {
        this.updateDateTime = updateDateTime;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public CustomerUser getUser() {
        return user;
    }

    public void setUser(CustomerUser user) {
        this.user = user;
    }

    public CustomerAddress getCurrentAddress() {
        return currentAddress;
    }

    public void setCurrentAddress(CustomerAddress currentAddress) {
        this.currentAddress = currentAddress;
    }

    public CustomerContact getCurrentContact() {
        return currentContact;
    }

    public void setCurrentContact(CustomerContact currentContact) {
        this.currentContact = currentContact;
    }

    public List<CustomerPayment> getPaymentOptions() {
        return paymentOptions;
    }

    public void setPaymentOptions(List<CustomerPayment> paymentOptions) {
        this.paymentOptions = paymentOptions;
    }

    public List<CustomerProduct> getFavoriteProducts() {
        return favoriteProducts;
    }

    public void setFavoriteProducts(List<CustomerProduct> favoriteProducts) {
        this.favoriteProducts = favoriteProducts;
    }

    public List<CustomerOrder> getFavoriteOrders() {
        return favoriteOrders;
    }

    public void setFavoriteOrders(List<CustomerOrder> favoriteOrders) {
        this.favoriteOrders = favoriteOrders;
    }

    public List<CustomerStore> getFavoriteStores() {
        return favoriteStores;
    }

    public void setFavoriteStores(List<CustomerStore> favoriteStores) {
        this.favoriteStores = favoriteStores;
    }
}
