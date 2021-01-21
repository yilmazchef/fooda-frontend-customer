package be.fooda.frontend.components;

import be.fooda.frontend.models.basket.BasketProduct;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.theme.material.Material;

public class BasketLayout extends VerticalLayout {

    public BasketLayout(BasketProduct data) {

        getElement().setAttribute("theme", Material.DARK);
        setId("product-layout");

        add(new Text("every here .. "));

        /// ALL THE COMPONENTS FOR ONE BASKET PRODUCT ITEM IS HERE ..

    }
}
