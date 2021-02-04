package be.fooda.frontend.view;

import be.fooda.frontend.model.product.Product;
import be.fooda.frontend.service.BasketService;
import be.fooda.frontend.service.ProductService;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.springframework.http.ResponseEntity;

@Route(value = "foods", layout = MainView.class)
@PageTitle("Fooda | Foods")
public class FoodsView extends VerticalLayout {

    private final ProductService productService;
    private final BasketService basketService;

    public FoodsView(ProductService productService, BasketService basketService) {
        this.productService = productService;
        this.basketService = basketService;

        final ResponseEntity response = productService.getAll(1, 10);
        Product[] products = (Product[]) response.getBody();

        for (Product product : products) {
            add(new Text(product.getName()));
            add(new Text(" -------- "));
        }

    }
}
