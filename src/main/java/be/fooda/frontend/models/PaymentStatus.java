package be.fooda.frontend.models;

public enum PaymentStatus {
    STATUS01("");


    private String value;

    PaymentStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
