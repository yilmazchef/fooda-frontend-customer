package be.fooda.frontend.mapper;

import be.fooda.frontend.model.product.Price;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class ProductMapper {

    public be.fooda.frontend.model.product.Product map(be.fooda.frontend.model.store.Product source) {

        be.fooda.frontend.model.product.Product target = new be.fooda.frontend.model.product.Product();
        target.setId(source.geteProductId());
        target.setName(source.getName());
        target.setPrices(Collections.singletonList(new be.fooda.frontend.model.product.Price(source.getPrice())));
        target.setCategories(source.getCategories().stream().map(be.fooda.frontend.model.product.Category::new).collect(Collectors.toList()));
        target.setDefaultImage(new be.fooda.frontend.model.product.Image(null, source.getImageUrl(), true));

        return target;
    }

    public be.fooda.frontend.model.basket.Product map(be.fooda.frontend.model.product.Product source, be.fooda.frontend.model.basket.User targetUser) {
        be.fooda.frontend.model.basket.Product target = new be.fooda.frontend.model.basket.Product();

        if (source == null) return null;

        if (source.getName() != null && source.getName().isEmpty())
            target.setName(source.getName());

        if (source.getId() != null && !source.getId().toString().isEmpty())
            target.seteProductId(source.getId().toString());

        if (source.getDescription() != null && source.getDescription().isEmpty())
            target.setDescription(source.getDescription());

        if (source.getDefaultImage() != null && !source.getDefaultImage().getUrl().isEmpty())
            target.setImageUrl(source.getDefaultImage().getUrl());

        if (source.getPrices() != null && !source.getPrices().isEmpty()) {
            for (Price sourcePrice : source.getPrices()) {
                if (sourcePrice.getDefault().equals(Boolean.TRUE))
                    target.setPrice(sourcePrice.getAmount());
            }
        }

        target.setQuantity(1);
        target.setUser(targetUser);
        be.fooda.frontend.model.basket.Store targetStore = new be.fooda.frontend.model.basket.Store();
        if (source.getStore() != null) {
            if (source.getStore().geteStoreId() != null && !source.getStore().geteStoreId().toString().isEmpty())
                targetStore.seteStoreId(source.getStore().geteStoreId().toString());

            if (source.getStore().getName() != null && !source.getStore().getName().isEmpty())
                targetStore.setName(source.getStore().getName());
        }
        target.setStore(targetStore);

        Set<be.fooda.frontend.model.basket.Ingredient> targetIngredients = new HashSet<>();
        if (source.getIngredients() != null && !source.getIngredients().isEmpty()) {
            for (be.fooda.frontend.model.product.Ingredient sourceIngredient : source.getIngredients()) {
                be.fooda.frontend.model.basket.Ingredient targetIngredient = new be.fooda.frontend.model.basket.Ingredient();
                if (sourceIngredient.getId() != null && !sourceIngredient.getId().toString().isEmpty()) {
                    targetIngredient.seteIngredientId(sourceIngredient.getId().toString());
                }
                if (sourceIngredient.getPrice() != null && sourceIngredient.getPrice().doubleValue() > 0.00) {
                    targetIngredient.setCost(sourceIngredient.getPrice());
                }
                targetIngredients.add(targetIngredient);
            }
        }
        target.setIngredients(targetIngredients);

        return target;
    }

}
