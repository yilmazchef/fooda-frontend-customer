package be.fooda.frontend.layout;

public enum CardStyleDefinitions {

    CARD("card"),
    CARD_IMAGE("card-image"),
    CARD_IMAGE_SMALL("card-image-small"),
    CARD_TITLE("card-title"),
    CARD_TITLE_SMALL("card-title-small"),
    CARD_DESCRIPTION("card-description"),
    CARD_DESCRIPTION_SMALL("card-description-small"),
    CARD_NUMBER("card-number"),
    CARD_NUMBER_SMALL("card-number-small"),
    CARD_BUTTON_WITH_TEXT("card-button"),
    CARD_BUTTON_WITH_ICON("card-icon-button"),
    CARD_CHECKBOX("card-checks");

    private final String value;

    CardStyleDefinitions(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
