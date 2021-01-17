package be.fooda.frontend.views.login;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import be.fooda.frontend.views.main.MainView;

@Route(value = "login", layout = MainView.class)
@PageTitle("Login")
public class LoginView extends Div {

    public LoginView() {
        setId("login-view");
        add(new Text("Content placeholder"));
    }

}
