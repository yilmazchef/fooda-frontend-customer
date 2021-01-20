package be.fooda.frontend.models.store;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.LocalDate;
import java.time.LocalTime;

public class storeWorkingHours {

    private Long id;

    private LocalDate workingDate;


    private LocalTime openTime;

    private LocalTime closeTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getWorkingDate() {
        return workingDate;
    }

    public void setWorkingDate(LocalDate workingDate) {
        this.workingDate = workingDate;
    }

    public LocalTime getOpenTime() {
        return openTime;
    }

    public void setOpenTime(LocalTime openTime) {
        this.openTime = openTime;
    }

    public LocalTime getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(LocalTime closeTime) {
        this.closeTime = closeTime;
    }




}
