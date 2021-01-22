package be.fooda.frontend.components;

import be.fooda.frontend.models.store.Store;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.BigDecimalField;
import com.vaadin.flow.theme.material.Material;

import java.math.BigDecimal;

public class StoreLayout extends HorizontalLayout {

    public StoreLayout(Store data) {

        getElement().setAttribute("theme", Material.DARK);
        setId("store-layout");
        setWidthFull();

        VerticalLayout imageLayout = new VerticalLayout();
        imageLayout.setWidth("20vw");
        imageLayout.setHeight("200px");

        Image logo = new Image(data.getImages().get(0).getUrl(), data.getStoreName());
        logo.setWidth("20vw");
        logo.setHeight("auto");
        imageLayout.add(logo);

        VerticalLayout infoLayout = new VerticalLayout();
        infoLayout.setWidth("70vw");
        infoLayout.setHeight("200px");

        H2 title = new H2();
        Span address = new Span(data.getAddress().getMunicipality() + ", " + data.getAddress().getCity());
        infoLayout.add(title, address);

        HorizontalLayout otherInfo = new HorizontalLayout();
        BigDecimalField ranking = new BigDecimalField("Ranking: ");
        ranking.setValue(BigDecimal.valueOf(9.8));
        Span cuisine = new Span();

        Icon star = VaadinIcon.STAR.create();

        BigDecimalField deliveryTime = new BigDecimalField("Delivery: ");
        deliveryTime.setValue(new BigDecimal("35.00"));

        BigDecimalField deliveryCost = new BigDecimalField("Cost: ");
        deliveryCost.setValue(BigDecimal.ZERO);

        otherInfo.add(ranking, cuisine, star, deliveryTime, deliveryCost);

        Span matchScore = new Span("100%");

        VerticalLayout scoreLayout = new VerticalLayout();
        scoreLayout.setWidth("10vw");
        scoreLayout.setHeight("200px");
        scoreLayout.add(matchScore);

        add(imageLayout, infoLayout, scoreLayout);

    }
}
