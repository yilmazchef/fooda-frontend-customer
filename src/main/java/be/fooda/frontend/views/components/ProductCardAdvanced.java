package be.fooda.frontend.views.components;

import be.fooda.frontend.models.product.Product;
import be.fooda.frontend.models.product.ProductCategory;
import com.github.appreciated.card.Card;
import com.github.appreciated.card.action.ActionButton;
import com.github.appreciated.card.action.Actions;
import com.github.appreciated.card.content.IconItem;
import com.github.appreciated.card.content.Item;
import com.github.appreciated.card.label.PrimaryLabel;
import com.github.appreciated.card.label.SecondaryLabel;
import com.github.appreciated.card.label.TitleLabel;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import java.util.stream.Collectors;

public class ProductCardAdvanced extends VerticalLayout {

    public ProductCardAdvanced(Product product) {
        final TitleLabel titleLabel = new TitleLabel(product.getProductName());
        final PrimaryLabel primaryLabel = new PrimaryLabel(product.getDescription());
        final SecondaryLabel secondaryLabel = new SecondaryLabel(product.getCategories().stream().map(ProductCategory::getTitle).collect(Collectors.joining()));
        final IconItem iconItem = new IconItem(VaadinIcon.CART.create(), "Icon Item title", "Icon Item description");
        final Item item = new Item("Item title", "Item description");
        final Image image = new Image(product.getImages().get(0).getUrl(), product.getProductName());
        image.setWidth("25%");
        image.setHeight("auto");

        Card card = new Card(
                // if you don't want the title to wrap you can set the whitespace = nowrap
                titleLabel.withWhiteSpaceNoWrap(),
                primaryLabel,
                secondaryLabel,
                iconItem,
                item,
                image,
                new Actions(
                        new ActionButton("Action 1", event -> {/* Handle Action*/}),
                        new ActionButton("Action 2", event -> {/* Handle Action*/})
                )
        );
        card.setWidth("100%");
        add(card);
    }
}