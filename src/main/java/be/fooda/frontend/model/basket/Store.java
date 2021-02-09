package be.fooda.frontend.model.basket;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Objects;

public class Store {

    private String id;

    private String eStoreId;

    private String name;

    public Store() {
    }

    public Store(String id, String eStoreId, String name) {
        this.id = id;
        this.eStoreId = eStoreId;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String geteStoreId() {
        return eStoreId;
    }

    public void seteStoreId(String eStoreId) {
        this.eStoreId = eStoreId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("name", name)
                .toString();
    }
}
