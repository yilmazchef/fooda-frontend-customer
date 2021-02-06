package be.fooda.frontend.model.store;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

public class Address implements Serializable {

    private UUID id;

    private UUID eAddressId;

    private String postcode;

    private String municipality;

    private String city;

    public Address() {
    }

    public Address(UUID eAddressId) {
        this.eAddressId = eAddressId;
    }

    public Address(UUID eAddressId, String postcode, String municipality, String city) {
        this.eAddressId = eAddressId;
        this.postcode = postcode;
        this.municipality = municipality;
        this.city = city;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID geteAddressId() {
        return eAddressId;
    }

    public void seteAddressId(UUID eAddressId) {
        this.eAddressId = eAddressId;
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(id, address.id) && Objects.equals(eAddressId, address.eAddressId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, eAddressId);
    }
}
