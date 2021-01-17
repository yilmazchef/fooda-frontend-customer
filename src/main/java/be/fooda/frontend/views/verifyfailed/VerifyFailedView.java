package be.fooda.frontend.views.verifyfailed;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import be.fooda.frontend.views.main.MainView;

@Route(value = "verify_failed", layout = MainView.class)
@PageTitle("Verify Failed")
public class VerifyFailedView extends Div {

    public VerifyFailedView() {
        setId("verify-failed-view");
        add(new Text("Content placeholder"));
    }

}
