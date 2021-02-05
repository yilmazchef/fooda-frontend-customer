package be.fooda.frontend.layout;

import com.vaadin.flow.component.customfield.CustomField;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.component.textfield.TextField;

public class PhoneNumberField extends CustomField<String> {
    private final Select countryCode = new Select();
    private final TextField areaCode = new TextField();
    private final TextField subscriberCode = new TextField();

    public PhoneNumberField() {
        this("Phone");
    }

    public PhoneNumberField(String label) {

        setLabel(label.isEmpty() ? "Phone" : label);
        countryCode.setItems("+32", "+31");
        countryCode.getStyle().set("width", "6em");
        countryCode.setPlaceholder("Code");
        areaCode.setPattern("[0-9]*");
        areaCode.setPreventInvalidInput(true);
        areaCode.setMaxLength(4);
        areaCode.setPlaceholder("Area");
        areaCode.getStyle().set("width", "5em");
        subscriberCode.setPattern("[0-9]*");
        subscriberCode.setPreventInvalidInput(true);
        subscriberCode.setMaxLength(8);
        subscriberCode.setPlaceholder("Subscriber");
        HorizontalLayout horizontalLayout = new HorizontalLayout();
        horizontalLayout.add(countryCode, areaCode, subscriberCode);
        add(horizontalLayout);
    }

    @Override
    protected String generateModelValue() {
        return countryCode.getValue().toString().replace("+", "00") + areaCode.getValue() + subscriberCode.getValue();
    }

    @Override
    protected void setPresentationValue(String newPresentationValue) {
        if (newPresentationValue == null) {
            areaCode.setValue(null);
            subscriberCode.setValue(null);
        }
    }
}
