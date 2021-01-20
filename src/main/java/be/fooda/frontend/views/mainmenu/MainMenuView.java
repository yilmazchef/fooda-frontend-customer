package be.fooda.frontend.views.mainmenu;

import be.fooda.frontend.models.product.Product;
import be.fooda.frontend.models.product.ProductCategory;
import be.fooda.frontend.service.ProductService;
import be.fooda.frontend.views.main.MainView;
import com.github.appreciated.card.Card;
import com.github.appreciated.card.action.ActionButton;
import com.github.appreciated.card.action.Actions;
import com.github.appreciated.card.content.IconItem;
import com.github.appreciated.card.content.Item;
import com.github.appreciated.card.label.PrimaryLabel;
import com.github.appreciated.card.label.SecondaryLabel;
import com.github.appreciated.card.label.TitleLabel;
import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.accordion.Accordion;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.BigDecimalField;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextFieldVariant;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;

import static be.fooda.frontend.views.main.MainView.DEFAULT_PAGE_NUMBER;

@Route(value = "main", layout = MainView.class)
@PageTitle("Fooda | Main Menu")
public class MainMenuView extends VerticalLayout {

    private ProductService productService;

    public MainMenuView(ProductService productService) {
        this.productService = productService;
        setId("main-menu-view");

        getProductCategories();
        getProducts();
    }

    private void getProductCategories() {
        final ResponseEntity<ProductCategory[]> categories = productService.getAllCategories();
        initProductCategoriesFromResponse(categories);
    }

    private void getProducts() {
        final ResponseEntity<Product[]> responseEntity = productService.getAll(DEFAULT_PAGE_NUMBER, 2);
        initProductsFromResponse(responseEntity);
    }

    private void initProductsFromResponse(ResponseEntity<Product[]> responseEntity) {
        if (!responseEntity.getStatusCode().equals(HttpStatus.SERVICE_UNAVAILABLE) && responseEntity.getBody() != null) {
            final Product[] products = responseEntity.getBody();
            for (Product product : products) {
                newDetailedProductCard(product);
            }
        }
    }

    private void newDetailedProductCard(Product product) {

        NumberField qty = new NumberField();
        qty.setValue(1d);
        qty.setHasControls(true);
        qty.setMin(1);
        qty.setMax(product.getLimitPerOrder());

        BigDecimalField price = new BigDecimalField("Total:");
        price.addThemeVariants(TextFieldVariant.LUMO_ALIGN_RIGHT);
        price.setPrefixComponent(new Icon(VaadinIcon.EURO));

        Paragraph tax = new Paragraph();

        qty.addValueChangeListener(onQuantityChange -> {
            price.setValue(product.getPrices().get(0).getAmount().multiply(BigDecimal.valueOf(qty.getValue())).setScale(2));
        });

        price.addValueChangeListener(e -> {
            BigDecimal taxValue;
            if (e.getValue() == null) {
                taxValue = BigDecimal.ZERO;
            } else {
                taxValue = e.getValue().multiply(new BigDecimal(product.getTaxes().get(0).getPercentage())).setScale(2, RoundingMode.HALF_EVEN);
            }
            tax.setText("VAT " + product.getTaxes().get(0).getPercentage() + "%: " + taxValue + product.getPrices().get(0).getCurrency());
        });

        SimpleCard simpleCard = new SimpleCard(
                product.getImages().get(0).getUrl(),
                product.getProductName(),
                product.getDescription(),
                qty, price, tax,
                new ActionButton(VaadinIcon.CHECK.create(), onClick -> {
                    new Notification(product.getProductName() + " is added.. ");
                })
        );

        add(simpleCard);
    }

    private void initProductCategoriesFromResponse(ResponseEntity<ProductCategory[]> responseEntity) {
        if (!responseEntity.getStatusCode().equals(HttpStatus.SERVICE_UNAVAILABLE) && responseEntity.getBody() != null) {
            List<ProductCategory> categories = Arrays.asList(responseEntity.getBody());

            Accordion accordion = new Accordion();

            FormLayout categoriesSelectionForm = new FormLayout();
            categoriesSelectionForm.addClassName("product-categories");
            categories.forEach(c -> {
                final Checkbox categoryCheckBox = new Checkbox(c.getTitle(), false);
                categoryCheckBox.addValueChangeListener(onCheck -> {
                    final Boolean checked = onCheck.getValue();

                });
                categoriesSelectionForm.add(categoryCheckBox);
            });

            accordion.setWidthFull();
            accordion.add("Categories", categoriesSelectionForm);
            accordion.close();
            add(accordion);
        }
    }

    public class DetailedCard extends VerticalLayout {

        public DetailedCard(String titleLabel, String primaryLabel, String secondaryLabel,
                            Image icon, String iconTitle,
                            String iconDescription, String item, String itemDescription,
                            String imageUrl, String imageAlt,
                            String action1Text, String action2Text, ComponentEventListener<ClickEvent<Button>> action01Event, ComponentEventListener<ClickEvent<Button>> action02Event) {
            Card card = new Card(
                    // if you don't want the title to wrap you can set the whitespace = nowrap
                    new TitleLabel(titleLabel).withWhiteSpaceNoWrap(),
                    new PrimaryLabel(primaryLabel),
                    new SecondaryLabel(secondaryLabel),
                    new IconItem(icon, iconTitle, iconDescription),
                    new Item(item, itemDescription),
                    new Image(imageUrl, imageAlt),
                    new Actions(
                            new ActionButton(action1Text, action01Event),
                            new ActionButton(action2Text, action02Event)
                    )
            );

            add(card);
        }
    }

    public class SimpleCard extends VerticalLayout {
        public SimpleCard(String imagePath, String title, String description,
                          String action1Text, ComponentEventListener<ClickEvent<Button>> action01Event) {
            Image img = new Image(imagePath, title);
            img.setWidth("50px");
            img.setHeight("50px");
            Card card = new Card(
                    new IconItem(img, title, description),
                    new Actions(
                            new ActionButton(action1Text, action01Event)
                    )
            );
            card.setWidth("100%");
            add(card);
        }

        public SimpleCard(String imagePath, String title, String description, Component... components) {
            Image img = new Image(imagePath, title);
            img.setWidth("50px");
            img.setHeight("50px");
            Card card = new Card(
                    new IconItem(img, title, description),
                    new Actions(components)
            );
            card.setWidth("100%");
            add(card);
        }
    }


}
