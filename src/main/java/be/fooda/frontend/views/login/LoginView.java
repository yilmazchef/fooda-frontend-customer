package be.fooda.frontend.views.login;

import be.fooda.frontend.service.UserService;
import be.fooda.frontend.views.main.MainView;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.springframework.http.ResponseEntity;

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
        sendSmsCodeButton.addClickListener(sendSmsClick -> {
            final ResponseEntity<String> sendSmsResponse = userService.sendSmsCode(phoneNumberField.getValue());
            if (sendSmsResponse.getStatusCode().is2xxSuccessful()) {
                new Notification("Sms is Sent").open();
                TextField smsCodeField = new TextField();
                smsCodeField.setRequired(true);
                smsCodeField.setAutofocus(true);

                Button validateCodeButton = new Button("Validate & Login");
                validateCodeButton.addClickListener(validateClick -> {
                    final ResponseEntity<String> codeValidationResponse = userService.validateSmsCode(phoneNumberField.getValue(), smsCodeField.getValue());
                    if (codeValidationResponse.getStatusCode().is2xxSuccessful()) {
                        UI.getCurrent().navigate("main");
                        new Notification("Sms is Valid").open();
                    }
                });

                add(smsCodeField, validateCodeButton);
            }
        });

        setPadding(false);
        setMargin(false);
        setSizeFull();
        setAlignItems(Alignment.CENTER);
        add(phoneNumberField, sendSmsCodeButton);

    }

}
