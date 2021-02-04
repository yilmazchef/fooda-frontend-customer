package be.fooda.frontend.model.product;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.UUID;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Tax implements Serializable {

    private UUID id;

    private String title;

    private Double percentage;

    private Boolean isDefault;

    public Tax() {
    }

    public Tax(String title, Double percentage) {
        this.title = title;
        this.percentage = percentage;
    }

    public Tax(String title, Double percentage, Boolean isDefault) {
        this.title = title;
        this.percentage = percentage;
        this.isDefault = isDefault;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getPercentage() {
        return percentage;
    }

    public void setPercentage(Double percentage) {
        this.percentage = percentage;
    }

    public Boolean getDefault() {
        return isDefault;
    }

    public void setDefault(Boolean aDefault) {
        isDefault = aDefault;
    }
}
