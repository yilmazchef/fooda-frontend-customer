package be.fooda.frontend.model.store;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

public class Contact implements Serializable {

    private UUID id;

    private UUID eContactId;

    private String phone;

    private String email;

    private String firstName;

    private String lastName;

    public Contact() {
    }

    public Contact(UUID eContactId) {
        this.eContactId = eContactId;
    }

    public Contact(UUID eContactId, String phone, String email) {
        this.eContactId = eContactId;
        this.phone = phone;
        this.email = email;
    }

    public Contact(UUID eContactId, String phone, String email, String firstName, String lastName) {
        this.eContactId = eContactId;
        this.phone = phone;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID geteContactId() {
        return eContactId;
    }

    public void seteContactId(UUID eContactId) {
        this.eContactId = eContactId;
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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return Objects.equals(id, contact.id) && Objects.equals(eContactId, contact.eContactId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, eContactId);
    }
}
