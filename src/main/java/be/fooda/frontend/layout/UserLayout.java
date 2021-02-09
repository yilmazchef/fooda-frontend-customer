package be.fooda.frontend.layout;

import be.fooda.frontend.model.user.User;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.HasStyle;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;

import java.io.Serializable;

import static be.fooda.frontend.layout.CardStyleDefinitions.CARD;

@Tag("vaadin-user-layout")
public class UserLayout extends Component implements HasComponents, HasStyle, Serializable {

    private final VerticalLayout loginWithSmsLayout = new VerticalLayout();
    private final PhoneNumberField loginWithSmsPhoneField = new PhoneNumberField("Phone");
    private final TextField loginWithSmsCodeField = new TextField("Validation Code");

    private final VerticalLayout loginWithPasswordLayout = new VerticalLayout();
    private final PhoneNumberField loginWithPwdPhoneField = new PhoneNumberField("Phone");
    private final TextField loginWithPwdPasswordField = new TextField("Password");

    public UserLayout(User data) {

        addClassName(CARD.getValue());


    }
}
