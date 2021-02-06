package be.fooda.frontend.model.store;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

public class Schedule implements Serializable {

    private UUID id;

    private LocalDateTime openTime;

    private LocalDateTime closeTime;

    public Schedule() {
    }

    public Schedule(LocalDateTime openTime, LocalDateTime closeTime) {
        this.openTime = openTime;
        this.closeTime = closeTime;
    }

    public Schedule(UUID id, LocalDateTime openTime, LocalDateTime closeTime) {
        this.id = id;
        this.openTime = openTime;
        this.closeTime = closeTime;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public LocalDateTime getOpenTime() {
        return openTime;
    }

    public void setOpenTime(LocalDateTime openTime) {
        this.openTime = openTime;
    }

    public LocalDateTime getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(LocalDateTime closeTime) {
        this.closeTime = closeTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Schedule schedule = (Schedule) o;
        return Objects.equals(id, schedule.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

