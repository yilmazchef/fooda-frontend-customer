package be.fooda.frontend.views.components;

import be.fooda.frontend.models.product.ProductCategory;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.server.StreamResource;
import org.apache.commons.lang3.ArrayUtils;

import java.io.ByteArrayInputStream;
import java.util.List;

public class ProductCategorySetBadge extends HorizontalLayout {

    public ProductCategorySetBadge(List<ProductCategory> categoryStream) {

        setPadding(false);
        setMargin(false);
        setAlignItems(Alignment.CENTER);
        setVerticalComponentAlignment(Alignment.STRETCH);
        setJustifyContentMode(JustifyContentMode.CENTER);
        setSpacing(true);
        setHeight("60px");

        categoryStream.forEach(c -> {
            VerticalLayout rowLayout = new VerticalLayout();
            rowLayout.setPadding(false);
            rowLayout.setMargin(false);
            rowLayout.setWidthFull();

            byte[] imageBytes = ArrayUtils.toPrimitive(c.getIcon());
            StreamResource resource = new StreamResource(c.getTitle() + ".svg", () -> new ByteArrayInputStream(imageBytes));
            Image icon = new Image(resource, c.getTitle());

            Button categoryBadge = new Button(icon);
            categoryBadge.setWidth("50px");
            categoryBadge.setHeight("50px");
            categoryBadge.getStyle()
                    .set("border", "1px solid #F2F2F2")
                    .set("border-radius", "15px")
                    .set("font-size", "11px");
            categoryBadge.addClickListener(onClick -> {
                new Notification(c.getTitle() + " is clicked.").open();
            });
            setFlexGrow(1, categoryBadge);
            add(categoryBadge);
        });
    }

}
