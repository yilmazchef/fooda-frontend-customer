package be.fooda.frontend.models;

public enum UserRole {
    ROLE_FOODA_PARENT("Fooda Application Customer"),
    ROLE_RESTA_PARENT("Restaurant Managers"),
    ROLE_DELLA_PARENT("Couriers");

    private String value;

    UserRole(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
