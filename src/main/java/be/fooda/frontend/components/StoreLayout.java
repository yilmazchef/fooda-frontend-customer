package be.fooda.frontend.components;

import be.fooda.frontend.models.store.Store;
import be.fooda.frontend.models.store.StoreImage;
import be.fooda.frontend.models.store.StoreImageType;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.theme.material.Material;

public class StoreLayout extends VerticalLayout {

    public StoreLayout(Store data) {
        getElement().setAttribute("theme", Material.DARK);
        setId("store-layout");

        StoreImage defaultBackgroundImage = new StoreImage();
        defaultBackgroundImage.setUrl("images/default_store_bg.png");
        Image backgroundImage = new Image(data.getImages()
                .stream()
                .filter(storeImage -> storeImage.getType() == StoreImageType.BACKGROUND_IMAGE)
                .findFirst().orElse(defaultBackgroundImage)
                .getUrl(),
                data.getStoreName()
        );
        backgroundImage.addClassName("store-background");
        getStyle().set("background-image", backgroundImage.getSrc());

        VerticalLayout infoLayout = new VerticalLayout();
        infoLayout.addClassName("store-info-layout");
        H3 storeNameHeader = new H3(data.getStoreName());
        storeNameHeader.addClassName("store-name");
        Paragraph sloganParagraph = new Paragraph(data.getSlogan());
        sloganParagraph.addClassName("store-slogan");
        Span aboutSpan = new Span(data.getAbout());
        aboutSpan.addClassNames("store-about");
        infoLayout.add(storeNameHeader, sloganParagraph, aboutSpan);

        HorizontalLayout actionsLayout = new HorizontalLayout();
        actionsLayout.addClassName("store-actions-layout");
        NativeButton viewMenuButton = new NativeButton("View Menu");
        viewMenuButton.addClassName("store-view-menu");
        viewMenuButton.addClickListener(onClick -> {
            new Notification(data.getStoreName() + " is clicked .. ");
        });
        actionsLayout.add(viewMenuButton);

        // Add all layouts to parent layout ..
        add(infoLayout, actionsLayout);
    }
}
