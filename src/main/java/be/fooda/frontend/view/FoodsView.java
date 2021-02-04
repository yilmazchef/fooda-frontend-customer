package be.fooda.frontend.view;

import be.fooda.frontend.layout.ProductLayout;
import be.fooda.frontend.model.product.Product;
import be.fooda.frontend.service.BasketService;
import be.fooda.frontend.service.ProductService;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Route(value = "foods", layout = MainView.class)
@PageTitle("Fooda | Foods")
public class FoodsView extends VerticalLayout {

    private final ProductService productService;
    private final BasketService basketService;

    public FoodsView(ProductService productService, BasketService basketService) {
        this.productService = productService;
        this.basketService = basketService;
        addClassName("page");

        final ResponseEntity response = productService.getAll(1, 10);
        Product[] products = (Product[]) response.getBody();

        if (response.getStatusCode().equals(HttpStatus.FOUND) && products != null && products.length > 0) {
            for (Product product : products) {
                add(new ProductLayout(product));
            }
        }

    }
}
