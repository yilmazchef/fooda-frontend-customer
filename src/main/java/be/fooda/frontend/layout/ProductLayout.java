package be.fooda.frontend.layout;

import be.fooda.frontend.model.product.Ingredient;
import be.fooda.frontend.model.product.Price;
import be.fooda.frontend.model.product.Product;
import be.fooda.frontend.model.product.Tax;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.HasStyle;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.checkbox.CheckboxGroup;
import com.vaadin.flow.component.checkbox.CheckboxGroupVariant;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.BigDecimalField;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextFieldVariant;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashSet;
import java.util.List;

@Tag("vaadin-product-layout")
public class ProductLayout extends Component implements HasComponents, HasStyle, Serializable {

    private final VerticalLayout imageLayout = new VerticalLayout();
    private final Image productImg = new Image();

    private final VerticalLayout infoLayout = new VerticalLayout();
    private final H2 productNameH2 = new H2();
    private final Paragraph productDescriptionP = new Paragraph();

    private final HorizontalLayout priceLayout = new HorizontalLayout();
    private final BigDecimalField productPriceField = new BigDecimalField("Price");
    private final BigDecimalField productTaxField = new BigDecimalField("Tax");
    private final BigDecimalField totalPriceField = new BigDecimalField("Total");

    private final VerticalLayout quantityLayout = new VerticalLayout();
    private final NumberField quantityField = new NumberField("Quantity");

    private final HorizontalLayout detailsLayout = new HorizontalLayout();
    private final CheckboxGroup<Ingredient> ingredientsCheckBoxGroup = new CheckboxGroup<>();
    private final CheckboxGroup<Ingredient> extraIngredientsCheckBoxGroup = new CheckboxGroup<>();

    private final HorizontalLayout actionsLayout = new HorizontalLayout();
    private final Button basketButton = new Button("Add to Basket");
    private final Button detailsButton = new Button("View Details");


    public ProductLayout(Product data) {

        addClassName("card");

//        START -> PRODUCT IMAGE LAYOUT COMPONENTS
        productImg.setSrc(data.getDefaultImage().getUrl());
        productImg.setAlt(data.getName());
        productImg.addClassName("card-image");
        imageLayout.add(productImg);

//        END -> PRODUCT IMAGE LAYOUT COMPONENTS


//        START -> PRODUCT INFO LAYOUT COMPONENTS
        productNameH2.setText(data.getName());
        productNameH2.addClassName("card-title");
        final String descriptionValue = data.getDescription();
        productDescriptionP.setText(descriptionValue.length() > 50 ? descriptionValue.substring(0, 49) + "..." : descriptionValue);
        productDescriptionP.addClassName("card-description");
        productDescriptionP.addClickListener(onClick -> {
            productDescriptionP.setText(data.getDescription());
        });
        infoLayout.add(productNameH2, productDescriptionP);

//        END -> PRODUCT INFO LAYOUT COMPONENTS

//        START -> PRODUCT QUANTITY LAYOUT COMPONENTS

        quantityField.setValue(1d);
        quantityField.setHasControls(true);
        quantityField.setMin(1);
        quantityField.addClassName("card-number");
        final Integer limitPerOrderValue = data.getLimitPerOrder();
        quantityField.setMax(limitPerOrderValue != null && limitPerOrderValue > 0 ? limitPerOrderValue : Integer.MAX_VALUE);

//        PARTIAL_END -> PRODUCT QUANTITY LAYOUT COMPONENTS

//        START -> PRODUCT PRICE LAYOUT COMPONENTS

        final Price defaultPrice = data.getPrices().get(0);
        final Tax defaultTax = data.getTaxes().get(0);

        final BigDecimal productPriceValue = defaultPrice.getAmount();
        productPriceField.addThemeVariants(TextFieldVariant.LUMO_ALIGN_RIGHT);
        productPriceField.setPrefixComponent(new Icon(VaadinIcon.EURO));
        productPriceField.setValue(productPriceValue.setScale(2, RoundingMode.HALF_EVEN));
        productPriceField.setReadOnly(true);
        productPriceField.addClassName("card-number");
        final BigDecimal productTaxValue = productPriceValue.multiply(BigDecimal.valueOf(defaultTax.getPercentage()));
        productTaxField.addThemeVariants(TextFieldVariant.LUMO_ALIGN_RIGHT);
        productTaxField.setPrefixComponent(new Icon(VaadinIcon.EURO));
        productTaxField.setValue(productTaxValue.setScale(2, RoundingMode.HALF_EVEN));
        productTaxField.setReadOnly(true);
        productTaxField.addClassName("card-number");
        totalPriceField.addThemeVariants(TextFieldVariant.LUMO_ALIGN_RIGHT);
        totalPriceField.setPrefixComponent(new Icon(VaadinIcon.EURO));
        totalPriceField.setValue(productPriceValue.setScale(2, RoundingMode.HALF_EVEN));
        totalPriceField.setReadOnly(true);
        totalPriceField.addClassName("card-number");

        priceLayout.add(productPriceField, productTaxField, totalPriceField);

//        END -> PRODUCT PRICE LAYOUT COMPONENTS

//        START -> DETAILS LAYOUT COMPONENTS

        ingredientsCheckBoxGroup.setLabel("Ingredients");
        List<Ingredient> ingredients = data.getIngredients();
        ingredientsCheckBoxGroup.setItems(ingredients);
        ingredientsCheckBoxGroup.setValue(new HashSet<>(ingredients));
        ingredientsCheckBoxGroup.addThemeVariants(CheckboxGroupVariant.LUMO_VERTICAL);
        ingredientsCheckBoxGroup.addClassName("card-checks");

        extraIngredientsCheckBoxGroup.setLabel("Extras");
        List<Ingredient> extraIngredients = data.getIngredients();
        extraIngredientsCheckBoxGroup.setItems(extraIngredients);
        extraIngredientsCheckBoxGroup.addThemeVariants(CheckboxGroupVariant.LUMO_VERTICAL);
        extraIngredientsCheckBoxGroup.addClassName("card-checks");

        Checkbox selectAllExtraIngredients = new Checkbox("Select all");
        extraIngredientsCheckBoxGroup.addValueChangeListener(onCheckChange -> {
            if (onCheckChange.getValue().size() == extraIngredients.size()) {
                selectAllExtraIngredients.setValue(true);
                selectAllExtraIngredients.setIndeterminate(false);
            } else if (onCheckChange.getValue().isEmpty()) {
                selectAllExtraIngredients.setValue(false);
                selectAllExtraIngredients.setIndeterminate(false);
            } else
                selectAllExtraIngredients.setIndeterminate(true);
        });

        detailsLayout.add(ingredientsCheckBoxGroup, extraIngredientsCheckBoxGroup);
        detailsLayout.setVisible(false);

//        END -> DETAILS LAYOUT COMPONENTS

//        CONTINUE -> PRODUCT QUANTITY LAYOUT COMPONENTS

        quantityField.addValueChangeListener(onQuantityChange -> {
            double subTotalOfExtraIngredients = extraIngredientsCheckBoxGroup.getSelectedItems().stream().mapToDouble(ingredient -> ingredient.getPrice().doubleValue()).sum();
            double totalCostOfExistingIngredients = ingredientsCheckBoxGroup.getSelectedItems().stream().mapToDouble(ingredient -> ingredient.getPrice().doubleValue()).sum();
            double totalCostOfAllExistingIngredients = ingredients.stream().mapToDouble(ingredient -> ingredient.getPrice().doubleValue()).sum();
            double reductionCostFromIngredients = totalCostOfAllExistingIngredients - totalCostOfExistingIngredients;

            final BigDecimal newPriceValue = productPriceValue
                    .multiply(BigDecimal.valueOf(onQuantityChange.getValue()))
                    .add(BigDecimal.valueOf(subTotalOfExtraIngredients))
                    .subtract(BigDecimal.valueOf(reductionCostFromIngredients));

            productPriceField.setValue(newPriceValue.setScale(2, RoundingMode.HALF_EVEN));
            productTaxField.setValue(newPriceValue.multiply(BigDecimal.valueOf(defaultTax.getPercentage())).setScale(2, RoundingMode.HALF_EVEN));
            totalPriceField.setValue(newPriceValue.setScale(2, RoundingMode.HALF_EVEN));
        });
        quantityLayout.add(quantityField);

//        END -> PRODUCT QUANTITY LAYOUT COMPONENTS

        basketButton.addClickListener(onClick -> {
            new Notification(data.getName() + " is added.", 1000, Notification.Position.BOTTOM_CENTER).open();
        });
        basketButton.addClassName("card-button");

        detailsButton.addClickListener(onClick -> {
            final boolean layoutVisible = detailsLayout.isVisible();
            detailsLayout.setVisible(!layoutVisible);
        });
        detailsButton.addClassName("card-button");

//        START -> ACTIONS  LAYOUT COMPONENTS

        actionsLayout.add(detailsButton, basketButton);

//        END -> ACTIONS LAYOUT COMPONENTS

        add(imageLayout, infoLayout, quantityLayout, priceLayout, detailsLayout, actionsLayout);
    }
}
