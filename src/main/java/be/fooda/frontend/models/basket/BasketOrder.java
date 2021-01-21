package be.fooda.frontend.models.basket;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalTime;

@Document
public class BasketOrder {

    @Id
    private String id;

    private BasketUser user;

    private BasketStore store;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
    private LocalTime requiredTime;

    private String note;

    public BasketOrder() {
    }

    public String getId() {
        return this.id;
    }

    public BasketUser getUser() {
        return this.user;
    }

    public BasketStore getStore() {
        return this.store;
    }

    public LocalTime getRequiredTime() {
        return this.requiredTime;
    }

    public String getNote() {
        return this.note;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setUser(BasketUser user) {
        this.user = user;
    }

    public void setStore(BasketStore store) {
        this.store = store;
    }

    public void setRequiredTime(LocalTime requiredTime) {
        this.requiredTime = requiredTime;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof BasketOrder)) return false;
        final BasketOrder other = (BasketOrder) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$user = this.getUser();
        final Object other$user = other.getUser();
        if (this$user == null ? other$user != null : !this$user.equals(other$user)) return false;
        final Object this$store = this.getStore();
        final Object other$store = other.getStore();
        if (this$store == null ? other$store != null : !this$store.equals(other$store)) return false;
        final Object this$requiredTime = this.getRequiredTime();
        final Object other$requiredTime = other.getRequiredTime();
        if (this$requiredTime == null ? other$requiredTime != null : !this$requiredTime.equals(other$requiredTime))
            return false;
        final Object this$note = this.getNote();
        final Object other$note = other.getNote();
        if (this$note == null ? other$note != null : !this$note.equals(other$note)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof BasketOrder;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $user = this.getUser();
        result = result * PRIME + ($user == null ? 43 : $user.hashCode());
        final Object $store = this.getStore();
        result = result * PRIME + ($store == null ? 43 : $store.hashCode());
        final Object $requiredTime = this.getRequiredTime();
        result = result * PRIME + ($requiredTime == null ? 43 : $requiredTime.hashCode());
        final Object $note = this.getNote();
        result = result * PRIME + ($note == null ? 43 : $note.hashCode());
        return result;
    }

    public String toString() {
        return "FoodaBasketOrder(id=" + this.getId() + ", user=" + this.getUser() + ", store=" + this.getStore() + ", requiredTime=" + this.getRequiredTime() + ", note=" + this.getNote() + ")";
    }
}
