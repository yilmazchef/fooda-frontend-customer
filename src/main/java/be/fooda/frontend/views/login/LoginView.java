package be.fooda.frontend.views.login;

import be.fooda.frontend.service.UserService;
import be.fooda.frontend.views.main.MainView;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.springframework.http.ResponseEntity;

import java.util.Objects;

@Route(value = "login", layout = MainView.class)
@PageTitle("Fooda | SMS Login")
public class LoginView extends VerticalLayout {

    private final UserService userService;

    public LoginView(UserService userService) {
        this.userService = userService;

        setId("login-view");

        TextField phoneNumberField = new TextField();
        phoneNumberField.setPlaceholder("32XXXXXXXXX");
        phoneNumberField.setMaxLength(11);
        phoneNumberField.setRequired(true);
        phoneNumberField.setAutoselect(true);

        Button sendSmsCodeButton = new Button("Send SMS Code");
        sendSmsCodeButton.addClickListener(click -> {
            final ResponseEntity<String> response = userService.sendSmsCode(phoneNumberField.getValue());
            if (response.getStatusCode().is2xxSuccessful() &&
                    Objects.requireNonNull(response.getBody()).equalsIgnoreCase("SMS_CODE_IS_SENT")) {

                UI.getCurrent().navigate("verify");
            }
        });

        add(phoneNumberField, sendSmsCodeButton);

    }

}
