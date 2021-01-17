package be.fooda.frontend.views.welcome;

import be.fooda.frontend.views.main.MainView;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;

@Route(value = "welcome", layout = MainView.class)
@PageTitle("Welcome")
@RouteAlias(value = "", layout = MainView.class)
public class WelcomeView extends Div {

    public WelcomeView() {
        setId("welcome-view");
        add(new Text("Welcome to Fooda"));
    }

}
