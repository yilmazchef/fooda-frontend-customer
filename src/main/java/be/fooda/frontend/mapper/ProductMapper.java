package be.fooda.frontend.mapper;

import be.fooda.frontend.model.product.Category;
import be.fooda.frontend.model.product.Image;
import be.fooda.frontend.model.product.Price;
import be.fooda.frontend.model.product.Product;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.stream.Collectors;

@Component
public class ProductMapper {

    public Product toProduct(be.fooda.frontend.model.store.Product source) {

        Product target = new Product();
        target.setId(source.geteProductId());
        target.setName(source.getName());
        target.setPrices(Collections.singletonList(new Price(source.getPrice())));
        target.setCategories(source.getCategories().stream().map(Category::new).collect(Collectors.toList()));
        target.setDefaultImage(new Image(null, source.getImageUrl(), true));

        return target;
    }
}
