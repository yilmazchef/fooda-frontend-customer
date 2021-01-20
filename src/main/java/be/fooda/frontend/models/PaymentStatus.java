package be.fooda.frontend.models;

public enum PaymentStatus {
    ALL_PAID ("All amount paid already"),
    PARTIALLY_PAID ("Waiting partial payment"),
    NOT_PAID("Not paid yet"),
    CANCELLED ("Payment cancelled");

    private String value;

    PaymentStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
