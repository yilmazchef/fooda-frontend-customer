package be.fooda.frontend.models;

public enum UserRole {
    STATUS01("");


    private String value;

    UserRole(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
