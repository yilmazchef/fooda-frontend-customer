package be.fooda.frontend.layout;

import be.fooda.frontend.model.store.Store;
import com.vaadin.flow.component.*;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import java.io.Serializable;

@Tag("vaadin-store-layout")
public class StoreLayout extends Component implements HasComponents, HasStyle, Serializable {

    private final VerticalLayout imageLayout = new VerticalLayout();
    private final Image storeLogoImage = new Image();

    private final VerticalLayout infoLayout = new VerticalLayout();
    private final H2 storeNameH2 = new H2();
    private final Paragraph storeSloganP = new Paragraph();

    private final HorizontalLayout actionsLayout = new HorizontalLayout();
    private final Button viewDetailsButton = new Button("View Details");


    public StoreLayout(Store data) {

        addClassName("store");

//        START -> STORE IMAGE LAYOUT COMPONENTS
        storeLogoImage.setWidth("100%");
        storeLogoImage.setHeight("auto");
        storeLogoImage.setSrc(data.getBgImage().getUrl());
        storeLogoImage.setAlt(data.getName());
        imageLayout.add(storeLogoImage);

//        END -> STORE IMAGE LAYOUT COMPONENTS


//        START -> STORE INFO LAYOUT COMPONENTS
        storeNameH2.setText(data.getName());
        storeSloganP.setText(data.getSlogan());
        storeSloganP.getStyle().set("font-size", "medium");
        infoLayout.add(storeNameH2, storeSloganP);

//        END -> STORE INFO LAYOUT COMPONENTS

//        START -> DETAILS LAYOUT COMPONENTS


//        END -> DETAILS LAYOUT COMPONENTS


//        START -> ACTIONS  LAYOUT COMPONENTS

        viewDetailsButton.setWidth("50vw");
        viewDetailsButton.getStyle()
                .set("background", "transparent")
                .set("vertical-align", "center")
                .set("margin-top", "10px")
                .set("color", "black")
                .set("border", "2px solid #161616");
        viewDetailsButton.addClickListener(onViewDetailsClick -> UI.getCurrent().navigate("/restaurant_details"));
        actionsLayout.add(viewDetailsButton);

//        END -> ACTIONS LAYOUT COMPONENTS

        add(imageLayout, infoLayout, actionsLayout);
    }
}
