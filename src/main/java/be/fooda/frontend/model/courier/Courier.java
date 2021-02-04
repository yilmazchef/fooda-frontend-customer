package be.fooda.frontend.model.courier;


import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class Courier {

    @JsonIgnore
    private Long id;

    private String firstName;

    private String familyName;

    private CourierUser user;

    private CourierCompany company;

    private CourierSettings settings;

    private List<CourierAddress> addresses;

    private List<CourierContact> contacts;

    private LocalDate dateOfBirth;

    private Boolean isActive = Boolean.TRUE;

    private LocalDateTime registryTime;

    private LocalDateTime updateTime;

    private  List<CourierMedia> medias;

    private String note;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public CourierUser getUser() {
        return user;
    }

    public void setUser(CourierUser user) {
        this.user = user;
    }

    public CourierCompany getCompany() {
        return company;
    }

    public void setCompany(CourierCompany company) {
        this.company = company;
    }

    public CourierSettings getSettings() {
        return settings;
    }

    public void setSettings(CourierSettings settings) {
        this.settings = settings;
    }

    public List<CourierAddress> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<CourierAddress> addresses) {
        this.addresses = addresses;
    }

    public List<CourierContact> getContacts() {
        return contacts;
    }

    public void setContacts(List<CourierContact> contacts) {
        this.contacts = contacts;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
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

    public List<CourierMedia> getMedias() {
        return medias;
    }

    public void setMedias(List<CourierMedia> medias) {
        this.medias = medias;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
