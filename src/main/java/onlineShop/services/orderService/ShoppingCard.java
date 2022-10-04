package onlineShop.services.orderService;

import onlineShop.models.products.Products;
import onlineShop.models.purchases.ShoppingOrders;

import java.util.List;

public class ShoppingCard {
    private List<Products> productsList;
    private ShoppingOrders shoppingOrders;

    public List<Products> getProductsList() {
        return productsList;
    }

    public void setProductsList(List<Products> productsList) {
        this.productsList = productsList;
    }

    public ShoppingOrders getShoppingOrders() {
        return shoppingOrders;
    }

    public void setShoppingOrders(ShoppingOrders shoppingOrders) {
        this.shoppingOrders = shoppingOrders;
    }
}
