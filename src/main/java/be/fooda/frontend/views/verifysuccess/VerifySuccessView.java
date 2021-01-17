package be.fooda.frontend.views.verifysuccess;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import be.fooda.frontend.views.main.MainView;

@Route(value = "verify_success", layout = MainView.class)
@PageTitle("Verify Success")
public class VerifySuccessView extends Div {

    public VerifySuccessView() {
        setId("verify-success-view");
        add(new Text("Content placeholder"));
    }

}
