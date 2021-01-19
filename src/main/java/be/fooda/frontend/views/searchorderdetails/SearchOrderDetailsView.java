package be.fooda.frontend.views.searchorderdetails;

import be.fooda.frontend.views.main.MainView;
import com.vaadin.flow.component.accordion.Accordion;
import com.vaadin.flow.component.accordion.AccordionPanel;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(value = "search_order_details", layout = MainView.class)
@PageTitle("Search Order Details")
public class SearchOrderDetailsView extends Div {

    public SearchOrderDetailsView() {
        setId("search-order-details-view");

        TextField searchField = new TextField();
        searchField.setWidth("217px");

        Accordion accordion = new Accordion();

        VerticalLayout personalInformationLayout = new VerticalLayout();
        personalInformationLayout.add(
                // add accordion components here ..
        );
        accordion.add("Personal Information", personalInformationLayout);

        VerticalLayout billingAddressLayout = new VerticalLayout();
        billingAddressLayout.add(
                new TextField("Address"),
                new TextField("City"),
                new TextField("State"),
                new TextField("Zip Code")
        );
        accordion.add("Billing Address", billingAddressLayout);

        VerticalLayout paymentLayout = new VerticalLayout();
        paymentLayout.add(
                new Span("Not yet implemented")
        );
        AccordionPanel billingAddressPanel = accordion.add("Payment", paymentLayout);
        billingAddressPanel.setEnabled(false);
        add(accordion);


        add(searchField);

    }

}
