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
import com.vaadin.flow.component.details.Details;
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

    private final Details detailsSection = new Details();

    private final HorizontalLayout detailsLayout = new HorizontalLayout();
    private final CheckboxGroup<Ingredient> ingredientsCheckBoxGroup = new CheckboxGroup<>();
    private final CheckboxGroup<Ingredient> extraIngredientsCheckBoxGroup = new CheckboxGroup<>();

    private final HorizontalLayout actionsLayout = new HorizontalLayout();
    private final Button basketButton = new Button("Add to Basket");


    public ProductLayout(Product data) {

        addClassName("product");

//        START -> PRODUCT IMAGE LAYOUT COMPONENTS
        productImg.setWidth("100%");
        productImg.setHeight("auto");
        productImg.setSrc(data.getDefaultImage().getUrl());
        productImg.setAlt(data.getName());
        imageLayout.add(productImg);

//        END -> PRODUCT IMAGE LAYOUT COMPONENTS


//        START -> PRODUCT INFO LAYOUT COMPONENTS
        productNameH2.setText(data.getName());
        productNameH2.getStyle()
                .set("background", "#161616")
                .set("color", "#F2F2F2")
                .set("text-align", "center")
                .set("font-size", "2em")
                .set("opacity", "0.6")
                .set("width", "100vw")
                .set("margin-top", "-20px");
        productDescriptionP.setText(data.getDescription());
        productDescriptionP.getStyle()
                .set("margin-top", "-20px")
                .set("padding-left", "10px")
                .set("padding-right", "10px")
                .set("font-size", "1em");
        infoLayout.add(productNameH2, productDescriptionP);

//        END -> PRODUCT INFO LAYOUT COMPONENTS

//        START -> PRODUCT QUANTITY LAYOUT COMPONENTS

        quantityField.setValue(1d);
        quantityField.setHasControls(true);
        quantityField.setMin(1);
        quantityField.setWidth("25vw");
        quantityField.getStyle()
                .set("font-size", "2em")
                .set("background", "transparent");
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
        productPriceField.setWidth("20vw");
        productPriceField.getStyle().set("background", "transparent");
        final BigDecimal productTaxValue = productPriceValue.multiply(BigDecimal.valueOf(defaultTax.getPercentage()));
        productTaxField.addThemeVariants(TextFieldVariant.LUMO_ALIGN_RIGHT);
        productTaxField.setPrefixComponent(new Icon(VaadinIcon.EURO));
        productTaxField.setValue(productTaxValue.setScale(2, RoundingMode.HALF_EVEN));
        productTaxField.setReadOnly(true);
        productTaxField.setWidth("20vw");
        productTaxField.getStyle().set("background", "transparent");
        totalPriceField.addThemeVariants(TextFieldVariant.LUMO_ALIGN_RIGHT);
        totalPriceField.setPrefixComponent(new Icon(VaadinIcon.EURO));
        totalPriceField.setValue(productPriceValue.setScale(2, RoundingMode.HALF_EVEN));
        totalPriceField.setReadOnly(true);
        totalPriceField.setWidth("30vw");
        totalPriceField.getStyle().set("background", "transparent");

        priceLayout.add(productPriceField, productTaxField, totalPriceField);

//        END -> PRODUCT PRICE LAYOUT COMPONENTS

//        START -> DETAILS LAYOUT COMPONENTS

        ingredientsCheckBoxGroup.setLabel("Ingredients");
        ingredientsCheckBoxGroup.setWidth("40vw");
        List<Ingredient> ingredients = data.getIngredients();
        ingredientsCheckBoxGroup.setItems(ingredients);
        ingredientsCheckBoxGroup.setValue(new HashSet<>(ingredients));
        ingredientsCheckBoxGroup.addThemeVariants(CheckboxGroupVariant.LUMO_VERTICAL);

        extraIngredientsCheckBoxGroup.setLabel("Extras");
        extraIngredientsCheckBoxGroup.setWidth("40vw");
        List<Ingredient> extraIngredients = data.getIngredients();
        extraIngredientsCheckBoxGroup.setItems(extraIngredients);
        extraIngredientsCheckBoxGroup.addThemeVariants(CheckboxGroupVariant.LUMO_VERTICAL);

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
        detailsSection.setSummaryText("Details");
        detailsSection.addContent(detailsLayout);

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


//        START -> ACTIONS  LAYOUT COMPONENTS

        basketButton.setWidth("50vw");
        basketButton.getStyle()
                .set("background", "transparent")
                .set("vertical-align", "center")
                .set("margin-top", "10px")
                .set("color", "black")
                .set("border", "2px solid #161616");
        basketButton.addClickListener(onClick -> new Notification(data.getName() + " is added.", 2000, Notification.Position.BOTTOM_CENTER).open());
        actionsLayout.add(basketButton);

//        END -> ACTIONS LAYOUT COMPONENTS

        add(imageLayout, infoLayout, quantityLayout, priceLayout, detailsSection, actionsLayout);
    }
}
