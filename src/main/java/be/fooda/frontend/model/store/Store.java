package be.fooda.frontend.model.store;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class Store {

    public Store() {
    }

    public Store(String name, Address address, Contact contact) {
        this.name = name;
        this.address = address;
        this.contact = contact;
    }

    public Store(String name, String eTrackingId) {
        this.name = name;
        this.eTrackingId = eTrackingId;
    }

    public Store(String name, Image bgImage, Address address, Contact contact, List<Product> products, List<Payment> payments, List<Delivery> deliveries, List<Schedule> schedules) {
        this.name = name;
        this.bgImage = bgImage;
        this.address = address;
        this.contact = contact;
        this.products = products;
        this.payments = payments;
        this.deliveries = deliveries;
        this.schedules = schedules;
    }

    public Store(UUID id, String name, String slogan, String type, UUID parentId, String about, Boolean isActive, String eTrackingId, String createdBy, String lastModifiedBy, LocalDateTime registeredAt, LocalDateTime updatedAt, Image bgImage, Address address, Contact contact, List<Product> products, Auth auth, List<Payment> payments, List<Delivery> deliveries, List<Schedule> schedules) {
        this.id = id;
        this.name = name;
        this.slogan = slogan;
        this.type = type;
        this.parentId = parentId;
        this.about = about;
        this.isActive = isActive;
        this.eTrackingId = eTrackingId;
        this.createdBy = createdBy;
        this.lastModifiedBy = lastModifiedBy;
        this.registeredAt = registeredAt;
        this.updatedAt = updatedAt;
        this.bgImage = bgImage;
        this.address = address;
        this.contact = contact;
        this.products = products;
        this.auth = auth;
        this.payments = payments;
        this.deliveries = deliveries;
        this.schedules = schedules;
    }

    private UUID id;

    private String name;

    private String slogan;

    private String type;

    private UUID parentId;

    private String about;

    private Boolean isActive;

    private String eTrackingId;

    private String createdBy;

    private String lastModifiedBy;

    private LocalDateTime registeredAt;

    private LocalDateTime updatedAt;

    private Image bgImage;

    private Address address;

    private Contact contact;

    private List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        this.products.add(product);
    }

    public void removeProduct(Product product) {
        this.products.remove(product);
    }

    private Auth auth;

    private List<Payment> payments = new ArrayList<>();

    public void addPayment(Payment payment) {
        this.payments.add(payment);
    }

    public void removePayment(Payment payment) {
        this.payments.remove(payment);
    }

    private List<Delivery> deliveries = new ArrayList<>();

    public void addDelivery(Delivery delivery) {
        this.deliveries.add(delivery);
    }

    public void removeDelivery(Delivery delivery) {
        this.deliveries.remove(delivery);
    }

    private List<Schedule> schedules = new ArrayList<>();

    public void addSchedule(Schedule schedule) {
        this.schedules.add(schedule);
    }

    public void removeSchedule(Schedule schedule) {
        this.schedules.remove(schedule);
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public UUID getParentId() {
        return parentId;
    }

    public void setParentId(UUID parentId) {
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

    public String geteTrackingId() {
        return eTrackingId;
    }

    public void seteTrackingId(String eTrackingId) {
        this.eTrackingId = eTrackingId;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public LocalDateTime getRegisteredAt() {
        return registeredAt;
    }

    public void setRegisteredAt(LocalDateTime registeredAt) {
        this.registeredAt = registeredAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Image getBgImage() {
        return bgImage;
    }

    public void setBgImage(Image bgImage) {
        this.bgImage = bgImage;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Auth getAuth() {
        return auth;
    }

    public void setAuth(Auth auth) {
        this.auth = auth;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }

    public List<Delivery> getDeliveries() {
        return deliveries;
    }

    public void setDeliveries(List<Delivery> deliveries) {
        this.deliveries = deliveries;
    }

    public List<Schedule> getSchedules() {
        return schedules;
    }

    public void setSchedules(List<Schedule> schedules) {
        this.schedules = schedules;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Store store = (Store) o;
        return Objects.equals(id, store.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
