package be.fooda.frontend.views.login;

import be.fooda.frontend.models.user.User;
import be.fooda.frontend.service.UserService;
import be.fooda.frontend.views.main.MainView;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.material.Material;
import org.springframework.http.ResponseEntity;

@Route(value = "login", layout = MainView.class)
@PageTitle("Fooda | SMS Login")
public class LoginView extends VerticalLayout {

    private final UserService userService;

    public LoginView(UserService userService) {
        this.userService = userService;

        getElement().setAttribute("theme", Material.DARK);
        setId("login-layout");

        setHorizontalComponentAlignment(Alignment.CENTER);

        VerticalLayout infoLayout = new VerticalLayout();
        infoLayout.addClassName("login-info-layout");
        final H2 nameHeader = new H2("Login with SMS");
        nameHeader.addClassName("login-name-header");
        final Paragraph descriptionParagraph = new Paragraph("We only collect information for helping you. We never share personal data.");
        descriptionParagraph.addClassName("login-description-paragraph");
        infoLayout.add(nameHeader, descriptionParagraph);

        VerticalLayout sendSmsLayout = new VerticalLayout();
        sendSmsLayout.addClassName("login-send-layout");

        TextField phoneField = new TextField();
        phoneField.addClassName("login-phone");
        phoneField.setMaxLength(11);
        phoneField.setLabel("Phone number: ");
        phoneField.setRequired(true);
        phoneField.setAutoselect(true);

        Button sendSmsCodeButton = new Button("Send SMS Code");
        sendSmsCodeButton.addClassName("login-send-sms-code-button");
        sendSmsCodeButton.addClickListener(sendSmsClick -> {
            final ResponseEntity<String> sendSmsResponse = userService.sendSmsCode(phoneField.getValue());
            if (sendSmsResponse.getStatusCode().is2xxSuccessful()) {
                final Notification codeIsValidNotification = new Notification("SMS Code is sent.");
                codeIsValidNotification.setDuration(2000);
                codeIsValidNotification.open();
            }
        });

        Checkbox rememberMeCheck = new Checkbox();
        rememberMeCheck.addClassName("login-remember-me");
        rememberMeCheck.setValue(true);

        sendSmsLayout.add(phoneField, sendSmsCodeButton, rememberMeCheck);

        VerticalLayout validateLayout = new VerticalLayout();
        validateLayout.addClassName("login-validate-layout");

        TextField smsCodeField = new TextField();
        smsCodeField.setRequired(true);
        smsCodeField.setAutofocus(true);

        Button validateCodeButton = new Button("Validate & Login");
        sendSmsCodeButton.addClassName("login-verify-sms-code-button");
        validateCodeButton.addClickListener(validateClick -> {
            if (phoneField.getValue().isEmpty()) {
                final Notification requiredPhoneNumberNotification = new Notification("Phone number is required");
                requiredPhoneNumberNotification.setDuration(2000);
                requiredPhoneNumberNotification.open();
            }

            if (smsCodeField.getValue().isEmpty()) {
                final Notification requiredSmsCodeNotification = new Notification("Sms Code is required");
                requiredSmsCodeNotification.setDuration(2000);
                requiredSmsCodeNotification.open();
            }

            final ResponseEntity<String> codeValidationResponse = userService.validateSmsCode(phoneField.getValue(), smsCodeField.getValue());
            if (codeValidationResponse.getStatusCode().is2xxSuccessful()) {
                final Notification codeIsValidNotification = new Notification(VaadinIcon.CHECK.create());
                codeIsValidNotification.setDuration(2000);
                codeIsValidNotification.open();
                UI.getCurrent().getSession().setAttribute(User.class, );
                UI.getCurrent().navigate("main");
            }
        });
        validateLayout.add(smsCodeField, validateCodeButton);

        add(infoLayout, sendSmsLayout, validateLayout);

    }

}
