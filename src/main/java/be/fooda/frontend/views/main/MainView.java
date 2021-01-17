package be.fooda.frontend.views.main;

import be.fooda.frontend.views.basket.BasketView;
import be.fooda.frontend.views.profile.ProfileView;
import be.fooda.frontend.views.searchfood.SearchFoodView;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.ComponentUtil;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.component.tabs.TabsVariant;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.server.PWA;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.material.Material;

import java.util.Optional;

/**
 * The main view is a top-level placeholder for other views.
 */
@CssImport("./styles/views/main/main-view.css")
@PWA(name = "Fooda", shortName = "Fooda", enableInstallPrompt = false)
@JsModule("./styles/shared-styles.js")
@Theme(value = Material.class, variant = Material.DARK)
public class MainView extends AppLayout {

    private final Tabs menu;
    private H1 viewTitle;

    public MainView() {
        setPrimarySection(Section.DRAWER);
        addToNavbar(true, createHeaderContent());
        menu = createMenu();
        addToDrawer(createDrawerContent(menu));
    }

    private Component createHeaderContent() {
        HorizontalLayout layout = new HorizontalLayout();
        layout.setId("header");
        layout.setWidthFull();
        layout.setSpacing(false);
        layout.setAlignItems(FlexComponent.Alignment.CENTER);
        layout.add(new DrawerToggle());
        viewTitle = new H1();
        layout.add(viewTitle);
        final Image basketIcon = new Image("images/basket_empty.svg", "Basket");
        layout.add(basketIcon);
        return layout;
    }

    private Component createDrawerContent(Tabs menu) {
        VerticalLayout layout = new VerticalLayout();
        layout.addClassName("drawer_layout");

        HorizontalLayout logoLayout = new HorizontalLayout();
        logoLayout.setAlignItems(FlexComponent.Alignment.CENTER);
        final Image logoImage = new Image("images/logo.png", "Fooda Logo");
        logoImage.addClassName("drawer_logo");
        logoLayout.add(logoImage);
        layout.add(logoLayout, menu);
        return layout;
    }

    private Tabs createMenu() {
        final Tabs tabs = new Tabs();
        tabs.setOrientation(Tabs.Orientation.VERTICAL);
        tabs.addThemeVariants(TabsVariant.LUMO_HIDE_SCROLL_BUTTONS);
        tabs.setId("tabs");
        tabs.add(createMenuItems());
        return tabs;
    }

    private Component[] createMenuItems() {
        return new Tab[]{
                createTab("Basket", BasketView.class),
                createTab("Search", SearchFoodView.class),
                createTab("Profile", ProfileView.class)
//                createTab("Basket", new Image("images/basket_empty.svg", "Basket"), BasketView.class),
//                createTab("Search", new Image("images/search.svg", "Search"), SearchFoodView.class),
//                createTab("Profile", new Image("images/profile.svg", "Profile"), ProfileView.class)
        };
    }

    private static Tab createTab(String text, Class<? extends Component> navigationTarget) {
        final Tab tab = new Tab();
        tab.add(new RouterLink(text, navigationTarget));
        ComponentUtil.setData(tab, Class.class, navigationTarget);
        return tab;
    }

    private static Tab createTab(String text, Image vectorIcon, Class<? extends Component> navigationTarget) {
        final Tab tab = new Tab();
        vectorIcon.addClassName("navigation_icon");
        tab.add(vectorIcon, new RouterLink(text, navigationTarget));
        ComponentUtil.setData(tab, Class.class, navigationTarget);
        return tab;
    }

    @Override
    protected void afterNavigation() {
        super.afterNavigation();
        getTabForComponent(getContent()).ifPresent(menu::setSelectedTab);
        viewTitle.setText(getCurrentPageTitle());
    }

    private Optional<Tab> getTabForComponent(Component component) {
        return menu.getChildren().filter(tab -> ComponentUtil.getData(tab, Class.class).equals(component.getClass()))
                .findFirst().map(Tab.class::cast);
    }

    private String getCurrentPageTitle() {
        return getContent().getClass().getAnnotation(PageTitle.class).value();
    }
}
