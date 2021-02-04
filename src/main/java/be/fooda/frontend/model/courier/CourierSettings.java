package be.fooda.frontend.model.courier;


import com.fasterxml.jackson.annotation.JsonIgnore;

public class CourierSettings {

    @JsonIgnore
    private Long id;

    private String language;

    private String currency;

    private Boolean sendStatistics;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Boolean getSendStatistics() {
        return sendStatistics;
    }

    public void setSendStatistics(Boolean sendStatistics) {
        this.sendStatistics = sendStatistics;
    }

}