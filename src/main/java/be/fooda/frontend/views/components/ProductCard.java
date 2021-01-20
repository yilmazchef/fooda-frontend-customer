package be.fooda.frontend.views.components;

import be.fooda.frontend.models.product.Product;
import be.fooda.frontend.models.product.ProductIngredient;
import com.github.appreciated.card.Card;
import com.github.appreciated.card.action.ActionButton;
import com.github.appreciated.card.action.Actions;
import com.github.appreciated.card.content.IconItem;
import com.github.appreciated.card.label.TitleLabel;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import java.util.stream.Collectors;

public class ProductCard extends VerticalLayout {
    public ProductCard(Product productData) {

        setId("product-card-" + productData.getId());

        setPadding(false);
        setMargin(false);
        setAlignItems(Alignment.CENTER);

        Image productImageData = new Image(productData.getImages().get(0).getUrl(), productData.getProductName());
        productImageData.setWidth("40vw");
        productImageData.setHeight("auto");

        final String productPricesData = productData.getPrices().stream().map(productPrice -> productPrice.getTitle() + ":" + productPrice.getAmount().toPlainString() + productPrice.getCurrency()).collect(Collectors.joining());
        final String productIngredientsData = productData.getIngredients().stream().map(ProductIngredient::getIngredientName).collect(Collectors.joining());
        Card card = new Card(
                new TitleLabel(productData.getProductName()),
                new IconItem(productImageData, productPricesData, productIngredientsData),
                new Actions(
                        new ActionButton(VaadinIcon.MINUS_CIRCLE.create(), event -> {/* Handle Action*/}),
                        new ActionButton(VaadinIcon.PLUS_CIRCLE.create(), event -> {/* Handle Action*/})
                )
        );
        card.setWidth("100vw");
        add(card);
    }
}