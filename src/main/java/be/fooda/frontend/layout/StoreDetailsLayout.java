package be.fooda.frontend.layout;

import be.fooda.frontend.model.store.Product;
import be.fooda.frontend.model.store.Store;
import com.vaadin.flow.component.*;
import com.vaadin.flow.component.accordion.Accordion;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.component.textfield.BigDecimalField;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Tag("vaadin-store-details-layout")
public class StoreDetailsLayout extends Component implements HasComponents, HasStyle, Serializable {

    private final VerticalLayout imageLayout = new VerticalLayout();
    private final Image storeBackgroundImage = new Image();

    private final HorizontalLayout shareLayout = new HorizontalLayout();
    private final Button shareButton = new Button(VaadinIcon.SHARE.create());
    private final BigDecimalField deliveryTimeField = new BigDecimalField();
    private final BigDecimalField deliveryCostField = new BigDecimalField();

    private final VerticalLayout detailsLayout = new VerticalLayout();

    private final Tabs tabs = new Tabs();
    private final Tab menuTab = new Tab("Menu");
    private final Tab infoTab = new Tab("Information");
    private final Tab commentsTab = new Tab("Comments");

    public StoreDetailsLayout(Store data) {

        addClassName("store-details");

        //        START -> STORE IMAGE LAYOUT COMPONENTS
        storeBackgroundImage.setWidth("auto");
        storeBackgroundImage.setHeight("50vh");
        storeBackgroundImage.setSrc(data.getBgImage().getUrl());
        storeBackgroundImage.setAlt(data.getName());
        storeBackgroundImage.getStyle()
                .set("margin", "0")
                .set("padding", "0");
        imageLayout.setWidth("auto");
        imageLayout.setHeight("50vh");
        imageLayout.add(storeBackgroundImage);

//        END -> STORE IMAGE LAYOUT COMPONENTS

        tabs.setHeight("50vh");
        tabs.setWidth("auto");

//        START -> DETAILS LAYOUT -> MENU PAGE COMPONENTS ..

        VerticalLayout menuPage = new VerticalLayout();
        final Map<String, List<Product>> productsByCuisine = data.getProducts().stream().collect(Collectors.groupingBy(Product::getCuisine));
        Accordion productGroupAccordion = new Accordion();
        for (Map.Entry<String, List<Product>> entry : productsByCuisine.entrySet()) {
            String cuisine = entry.getKey();
            List<Product> productGroup = entry.getValue();
            VerticalLayout productGroupLayout = new VerticalLayout();
            for (Product product : productGroup) {
                productGroupLayout.add(new Text(product.getName()));
            }
            productGroupAccordion.add(cuisine, productGroupLayout);
        }
        menuPage.add(productGroupAccordion);

//        END -> DETAILS LAYOUT -> MENU PAGE COMPONENTS ..

//        START -> DETAILS LAYOUT -> INFO PAGE COMPONENTS ..

        VerticalLayout infoPage = new VerticalLayout();
        infoPage.setVisible(false);
        Paragraph infoPageP = new Paragraph();
        infoPageP.setText(data.getAbout());
        infoPage.add(infoPageP);

//        END -> DETAILS LAYOUT -> INFO PAGE COMPONENTS ..

//        START -> DETAILS LAYOUT -> COMMENTS PAGE COMPONENTS ..

        VerticalLayout commentsPage = new VerticalLayout();
        commentsPage.setVisible(false);
        Paragraph commentsPageP = new Paragraph();
        commentsPageP.setText("Under development..");
        commentsPage.add(commentsPageP);

//        END -> DETAILS LAYOUT -> COMMENTS PAGE COMPONENTS ..

        Map<Tab, Component> tabsToPages = new HashMap<>();
        tabsToPages.put(menuTab, menuPage);
        tabsToPages.put(infoTab, infoPage);
        tabsToPages.put(commentsTab, commentsPage);
        Div pages = new Div(menuPage, infoPage, commentsPage);

        tabs.addSelectedChangeListener(event -> {
            tabsToPages.values().forEach(page -> page.setVisible(false));
            Component selectedPage = tabsToPages.get(tabs.getSelectedTab());
            selectedPage.setVisible(true);
        });

        tabs.setFlexGrowForEnclosedTabs(1);
        detailsLayout.add(tabs, pages);

//        ADD DIVIDER COMPONENTS TO PARENT
        add(imageLayout, shareLayout, detailsLayout);
    }
}
