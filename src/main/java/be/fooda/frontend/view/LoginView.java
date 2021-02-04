package be.fooda.frontend.view;

import be.fooda.frontend.service.UserService;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;

@Route(value = "user/login", layout = MainView.class)
@PageTitle("Fooda | User Login")
public class LoginView extends VerticalLayout {

    private static final String LOGIN_WITH_SMS_CODE = "Login with SMS Code";
    private static final String LOGIN_WITH_PASSWORD = "Login with Password";
    private static final String SEND_VALIDATION_CODE = "Send Validation Code";
    private static final String REDIRECT_ON_SUCCESS_ROUTE = "home";

    private final ComboBox<String> loginOptionsSelection = new ComboBox<>("Login Options", Arrays.asList(LOGIN_WITH_PASSWORD, LOGIN_WITH_SMS_CODE));

    private final VerticalLayout loginWithSmsLayout = new VerticalLayout();
    private final VerticalLayout loginWithPasswordLayout = new VerticalLayout();

    private final TextField loginWithSmsPhoneField = new TextField("Phone");
    private final TextField loginWithSmsCodeField = new TextField("Validation Code");
    private final TextField loginWithPwdPhoneField = new TextField("Phone");
    private final TextField loginWithPwdPasswordField = new TextField("Password");
    private final UserService userService;
    private final LogDisplay logDisplay = new LogDisplay();

    public LoginView(UserService userService) {
        this.userService = userService;
        addClassName("page");

        loginWithSmsLayout.setVisible(false);
        loginWithPasswordLayout.setVisible(true);

        loginOptionsSelection.addValueChangeListener(onSelectionChange -> {
            final String changeValue = onSelectionChange.getValue();
            loginWithSmsLayout.setVisible(changeValue.equalsIgnoreCase(LOGIN_WITH_SMS_CODE));
            loginWithPasswordLayout.setVisible(changeValue.equalsIgnoreCase(LOGIN_WITH_PASSWORD));
        });


//        START -> SEND SMS CODE AND VALIDATE COMPONENTS

        Button sendSmsButton = new Button(SEND_VALIDATION_CODE);
        sendSmsButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        sendSmsButton.addClickListener(onClick -> {
            final ResponseEntity<String> response = userService.sendSmsCode(loginWithSmsPhoneField.getValue());
            logDisplay.log(response.getBody());
        });

        Button loginWithSmsButton = new Button(LOGIN_WITH_SMS_CODE);
        loginWithSmsButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        loginWithSmsButton.addClickListener(onClick -> {
            ResponseEntity<String> response = userService.validateSmsCode(loginWithSmsPhoneField.getValue(), loginWithSmsCodeField.getValue());
            logDisplay.log(response.getBody());
            if (response.getStatusCode().equals(HttpStatus.ACCEPTED)) {
                UI.getCurrent().getSession().setAttribute("login", loginWithSmsPhoneField.getValue());
                UI.getCurrent().navigate(REDIRECT_ON_SUCCESS_ROUTE);
            }
        });

        loginWithSmsLayout.add(loginWithSmsPhoneField, sendSmsButton, loginWithSmsCodeField, loginWithSmsButton, logDisplay);

//        END -> SEND SMS CODE AND VALIDATE COMPONENTS

//        START -> LOGIN WITH PHONE AND PASSWORD

        Button loginWithPwdButton = new Button(LOGIN_WITH_PASSWORD);
        loginWithPwdButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        loginWithPwdButton.addClickListener(onClick -> {
            ResponseEntity<String> response = userService.loginWithPassword(loginWithPwdPhoneField.getValue(), loginWithPwdPasswordField.getValue());
            logDisplay.log(response.getBody());
            if (response.getStatusCode().equals(HttpStatus.ACCEPTED)) {
                UI.getCurrent().getSession().setAttribute("login", loginWithPwdPhoneField.getValue());
                UI.getCurrent().navigate(REDIRECT_ON_SUCCESS_ROUTE);
            }
        });

        loginWithPasswordLayout.add(loginWithPwdPhoneField, loginWithPwdPasswordField, loginWithPwdButton, logDisplay);

//        END -> LOGIN WITH PHONE AND PASSWORD

        add(loginOptionsSelection, loginWithSmsLayout, loginWithPasswordLayout);

    }

    public static class LogDisplay extends Composite<VerticalLayout> {

        public void log(String message) {
            if (getContent().getComponentCount() > 4) {
                getContent().removeAll();
            }
            getContent().add(new Paragraph(message));
        }
    }
}
