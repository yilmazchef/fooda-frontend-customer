package be.fooda.frontend.view;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.page.Viewport;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.server.PWA;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.lumo.Lumo;

/**
 * The main view is a top-level placeholder for other views.
 */
@CssImport("./styles/views/main/main-view.css")
@Viewport("width=device-width, minimum-scale=1, initial-scale=1, user-scalable=yes, viewport-fit=cover")
@PWA(name = "Fooda", shortName = "Fooda", enableInstallPrompt = false)
@JsModule("./styles/shared-styles.js")
@Theme(value = Lumo.class)
public class MainView extends AppLayout {

    public static final String HOME_PAGE = "home";
    public static final String USER_LOGIN_PAGE = "user/login";
    public static final String BASKET_PRODUCTS_PAGE = "basket/products";
    public static final String FOODS_PAGE = "foods";
    public static final String RESTAURANTS_PAGE = "restaurants";
    public static final String ORDERS_PAGE = "orders";

    public MainView() {

        setDrawerOpened(false);
        setId("main-view");

        Image logoForTabs = new Image("images/logo.svg", "Fooda Logo");
        logoForTabs.setWidth("128px");
        logoForTabs.getStyle()
                .set("padding-top", "8vh")
                .set("padding-bottom", "4vh")
                .set("margin", "0");

        Image logoForDrawer = new Image("images/logo.svg", "Fooda Logo");
        logoForDrawer.setWidth("32px");
        logoForDrawer.getStyle().set("float", "right");

        addToNavbar(true, new DrawerToggle(), logoForDrawer);

        Tabs tabs = new Tabs(
                new Tab(logoForTabs),
                new Tab(new Anchor(HOME_PAGE, "Home")),
                new Tab(new Anchor(USER_LOGIN_PAGE, "Login")),
                new Tab(new Anchor(BASKET_PRODUCTS_PAGE, "Basket")),
                new Tab(new Anchor(FOODS_PAGE, "Foods")),
                new Tab(new Anchor(RESTAURANTS_PAGE, "Restaurants")),
                new Tab(new Anchor(ORDERS_PAGE, "Orders"))
        );

        tabs.setOrientation(Tabs.Orientation.VERTICAL);
        tabs.getStyle().set("justify-content", "flex-end");

        addToDrawer(tabs);
    }
}
