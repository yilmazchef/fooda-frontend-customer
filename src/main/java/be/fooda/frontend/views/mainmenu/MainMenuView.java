package be.fooda.frontend.views.mainmenu;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import be.fooda.frontend.views.main.MainView;

@Route(value = "main", layout = MainView.class)
@PageTitle("Main Menu")
public class MainMenuView extends Div {

    public MainMenuView() {
        setId("main-menu-view");
        add(new Text("Content placeholder"));
    }

}
