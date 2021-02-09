package be.fooda.frontend.model.basket;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;
import java.util.Objects;

public class Contact implements Serializable {

    private String id;

    private User user;

    private String eContactId;

    private String title;

    private String familyName;

    private String firstName;

    private String companyName;

    private String phone;

    private String email;

    private Boolean isDelivery;

    private Boolean isBilling;

    public Contact() {
    }

    public Contact(String id, User user, String eContactId, String title, String familyName, String firstName, String companyName, String phone, String email, Boolean isDelivery, Boolean isBilling) {
        this.id = id;
        this.user = user;
        this.eContactId = eContactId;
        this.title = title;
        this.familyName = familyName;
        this.firstName = firstName;
        this.companyName = companyName;
        this.phone = phone;
        this.email = email;
        this.isDelivery = isDelivery;
        this.isBilling = isBilling;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String geteContactId() {
        return eContactId;
    }

    public void seteContactId(String eContactId) {
        this.eContactId = eContactId;
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

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return Objects.equals(id, contact.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("title", title)
                .toString();
    }
}
