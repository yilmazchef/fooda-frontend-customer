package be.fooda.frontend.components;

import be.fooda.frontend.models.user.User;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.theme.material.Material;

public class UserLayout extends VerticalLayout {

    public UserLayout(User data) {

        getElement().setAttribute("theme", Material.DARK);
        setId("user-layout");

        VerticalLayout infoLayout = new VerticalLayout();
        infoLayout.setAlignItems(Alignment.CENTER);
        infoLayout.addClassName("user-info-layout");
        final H2 nameHeader = new H2("User Info");
        nameHeader.addClassName("user-name-header");
        final Paragraph descriptionParagraph = new Paragraph("We only collect information for helping you. We never share personal data.");
        descriptionParagraph.addClassName("user-description-paragraph");
        infoLayout.add(nameHeader, descriptionParagraph);

        FormLayout profileLayout = new FormLayout();
        profileLayout.addClassName("user-form-layout");
        TextField phoneField = new TextField();
        phoneField.setLabel("Phone number: ");
        phoneField.setValue(data.getLogin());
        EmailField emailField = new EmailField();
        emailField.setLabel("Email: ");
        Checkbox isAuthenticated = new Checkbox();
        isAuthenticated.setValue(data.getAuthenticated());
        isAuthenticated.setReadOnly(true);
        profileLayout.add(phoneField, emailField, isAuthenticated);

        VerticalLayout actionLayout = new VerticalLayout();
        actionLayout.setAlignItems(Alignment.CENTER);
        actionLayout.addClassName("user-action-layout");
        Button viewMenuButton = new Button("Send SMS Code", onClick -> {
            new Notification("Send SMS Code is clicked .. ");
        });
        viewMenuButton.addClassName("user-send-sms-code-button");
        actionLayout.add(viewMenuButton);

        add(infoLayout, profileLayout, actionLayout);
    }
}
