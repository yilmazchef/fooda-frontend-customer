package be.fooda.frontend.components;

import be.fooda.frontend.models.store.Store;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.theme.material.Material;

public class StoreLayout extends VerticalLayout {

    public StoreLayout(Store data) {

        getElement().setAttribute("theme", Material.DARK);

        setId("store-layout");

        setPadding(false);
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        setJustifyContentMode(JustifyContentMode.CENTER);
        setWidthFull();

        VerticalLayout photoLayout = new VerticalLayout();
        Image image = new Image(data.getImages().get(0).getUrl(), data.getStoreName());
        image.setWidth("100vw");
        image.setHeight("auto");
        photoLayout.setWidthFull();
        photoLayout.setAlignItems(Alignment.CENTER);
        photoLayout.add(image);

        VerticalLayout infoLayout = new VerticalLayout();
        H3 header = new H3(data.getStoreName());
        Paragraph paragraph = new Paragraph(data.getSlogan());
        Span span = new Span(data.getAbout());
        infoLayout.setWidthFull();
        infoLayout.setAlignItems(Alignment.CENTER);
        infoLayout.add(header, paragraph, span);

        HorizontalLayout actionsLayout = new HorizontalLayout();
        NativeButton viewButton = new NativeButton("View Menu");
        viewButton.addClickListener(onClick -> {
            new Notification(data.getStoreName() + " is clicked .. ");
        });
        actionsLayout.setAlignItems(Alignment.CENTER);
        actionsLayout.setWidthFull();
        actionsLayout.add(viewButton);

        add(photoLayout, infoLayout, actionsLayout);
    }
}
