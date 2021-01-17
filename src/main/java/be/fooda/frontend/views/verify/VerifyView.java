package be.fooda.frontend.views.verify;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import be.fooda.frontend.views.main.MainView;

@Route(value = "verify", layout = MainView.class)
@PageTitle("Verify")
public class VerifyView extends Div {

    public VerifyView() {
        setId("verify-view");
        add(new Text("Content placeholder"));
    }

}
