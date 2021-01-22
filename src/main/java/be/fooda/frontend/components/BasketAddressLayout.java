package be.fooda.frontend.components;

import be.fooda.frontend.models.basket.BasketAddress;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.theme.material.Material;

public class BasketAddressLayout extends VerticalLayout {

    public BasketAddressLayout(BasketAddress data) {

        getElement().setAttribute("theme", Material.DARK);
        setId("basket-address-layout");

        VerticalLayout addressLayout = new VerticalLayout();
        addressLayout.setClassName("basket-address-layout");
        HorizontalLayout nameAndDefaultLayout = new HorizontalLayout();
        nameAndDefaultLayout.addClassName("basket-address-name-and-default-layout");
        H3 title = new H3(data.getTitle());
        title.setClassName("basket-address-title");
        Checkbox isDefaultCheckBox = new Checkbox(false);
        isDefaultCheckBox.setClassName("basket-address-default-checkbox");
        nameAndDefaultLayout.add(title, isDefaultCheckBox);



        Paragraph address = new Paragraph(data.getMunicipality() + " " + data.getPostcode());
        address.setClassName("basket-address-paragraph");

        addressLayout.add(nameAndDefaultLayout, address);


        add(addressLayout);

    }
}
