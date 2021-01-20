package be.fooda.frontend.views.main;

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
import com.vaadin.flow.theme.material.Material;

/**
 * The main view is a top-level placeholder for other views.
 */
@CssImport("./styles/views/main/main-view.css")
@Viewport("width=device-width, minimum-scale=1, initial-scale=1, user-scalable=yes, viewport-fit=cover")
@PWA(name = "Fooda", shortName = "Fooda", enableInstallPrompt = false)
@JsModule("./styles/shared-styles.js")
@Theme(value = Material.class, variant = Material.DARK)
public class MainView extends AppLayout {

    public static final int RESULTS_PER_PAGE = 25;
    public static final int DEFAULT_PAGE_NUMBER = 1;

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

        addToNavbar(new DrawerToggle(), logoForDrawer);

        Tabs tabs = new Tabs(
                new Tab(logoForTabs),
                new Tab(new Anchor("login", "Login")),
                new Tab(new Anchor("basket", "Go to Basket")),
                new Tab(new Anchor("search_food", "Search Food")),
                new Tab(new Anchor("search_restaurant", "Search Restaurant")),
                new Tab(new Anchor("search_map", "Search by Location")),
                new Tab(new Anchor("search_orders", "Search in Orders"))
        );

        tabs.setOrientation(Tabs.Orientation.VERTICAL);
        tabs.getStyle()
                .set("justify-content", "flex-end");

        addToDrawer(tabs);
    }
}
