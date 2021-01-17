package be.fooda.frontend.views.profile;

import be.fooda.frontend.views.main.MainView;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(value = "profile", layout = MainView.class)
@PageTitle("Profile & Settings")
public class ProfileView extends Div {

    public ProfileView() {

        setId("profile-view");
        add(new Text("Profile & Settings.. "));
    }

}
