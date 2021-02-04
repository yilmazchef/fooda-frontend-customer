package be.fooda.frontend.view;

import be.fooda.frontend.model.user.User;
import be.fooda.frontend.service.UserService;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Route(value = "user/login", layout = MainView.class)
@PageTitle("Fooda | User Login")
public class LoginView extends VerticalLayout {

    private TextField login = new TextField("Phone");
    private TextField validationCode = new TextField("Validation Code");
    private User user = new User();
    private final UserService userService;
    private LogDisplay logDisplay = new LogDisplay();

    public LoginView(UserService userService) {
        this.userService = userService;
        setAlignItems(Alignment.CENTER);
        login.setRequired(true);
        validationCode.setRequired(true);

        Binder<User> binder = new BeanValidationBinder<>(User.class);
        binder.bindInstanceFields(this);
        binder.setBean(user);

        Button validateCodeButton = new Button("Validate Code & Login");
        validateCodeButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        validateCodeButton.addClickListener(event -> {
            if (binder.validate().isOk()) {
                final ResponseEntity<String> response = userService.validateSmsCode(user.getLogin(), user.getValidationCode());
                logDisplay.log(response.getBody());
                if (response.getStatusCode().equals(HttpStatus.ACCEPTED)) {
                    UI.getCurrent().navigate("home");
                }
                user = new User();
                binder.setBean(user);
            }
        });

        validationCode.setVisible(false);
        validateCodeButton.setVisible(false);

        Button sendValidationCodeButton = new Button("Send Validation Code");
        sendValidationCodeButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        sendValidationCodeButton.addClickListener(event -> {
            if (binder.validate().isOk()) {
                final ResponseEntity<String> response = userService.sendSmsCode(user.getLogin());
                logDisplay.log(response.getBody());
                validationCode.setVisible(true);
                validateCodeButton.setVisible(true);
            }
        });


        add(login, sendValidationCodeButton, logDisplay, validationCode, validateCodeButton);

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
