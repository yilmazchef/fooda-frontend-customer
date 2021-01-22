package be.fooda.frontend.components;

import be.fooda.frontend.models.store.Store;
import be.fooda.frontend.models.store.StoreImageType;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.theme.material.Material;

public class StoreLayout extends VerticalLayout {

    public StoreLayout(Store data) {

        getElement().setAttribute("theme", Material.DARK);
        setId("store-layout");

        Image storeImage = new Image(data.getImages().stream().filter(img -> img.getType() == StoreImageType.BACKGROUND_IMAGE).findFirst().get().getUrl(), data.getStoreName());
        storeImage.addClassName("store-image-field");

        VerticalLayout imageLayout = new VerticalLayout();
        imageLayout.setAlignItems(Alignment.CENTER);
        imageLayout.add(storeImage);
        imageLayout.addClassName("store-image-layout");

        VerticalLayout infoLayout = new VerticalLayout();
        infoLayout.setAlignItems(Alignment.CENTER);
        infoLayout.addClassName("store-info-layout");
        final H2 nameHeader = new H2(data.getStoreName());
        nameHeader.addClassName("store-name-header");
        final Paragraph descriptionParagraph = new Paragraph(data.getAbout());
        descriptionParagraph.addClassName("store-description-paragraph");
        infoLayout.add(nameHeader, descriptionParagraph);

        VerticalLayout actionLayout = new VerticalLayout();
        actionLayout.setAlignItems(Alignment.CENTER);
        actionLayout.addClassName("store-action-layout");
        Button viewMenuButton = new Button("View Menu", onClick -> {
            new Notification("View Menu is clicked .. ");
        });
        viewMenuButton.addClassName("store-view-menu-button");
        actionLayout.add(viewMenuButton);

        add(imageLayout, infoLayout, actionLayout);
    }
}
