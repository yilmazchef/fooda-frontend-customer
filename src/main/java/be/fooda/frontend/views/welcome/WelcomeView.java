package be.fooda.frontend.views.welcome;

import be.fooda.frontend.views.main.MainView;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;

@Route(value = "welcome", layout = MainView.class)
@PageTitle("Welcome")
@RouteAlias(value = "", layout = MainView.class)
public class WelcomeView extends VerticalLayout {

    private static final String PREVIOUS_PAGE = "";
    private static final String NEXT_PAGE = "login";

    public WelcomeView() {

        setId("welcome-view");

        Image logoImage = new Image("images/logo.svg", "Fooda Logo");
        logoImage.setId("logo-image");
        Image sloganImage = new Image("images/slogan.svg", "Painkiller for Food Delivery..!");
        sloganImage.setId("slogan-image");
        Button nextButton = new Button("Next");
        nextButton.setId("next-button");

        nextButton.addClickListener(click -> {
            UI.getCurrent().navigate(NEXT_PAGE);
        });

        setAlignItems(Alignment.CENTER);

        addAndExpand(logoImage, sloganImage, nextButton);
    }


}
