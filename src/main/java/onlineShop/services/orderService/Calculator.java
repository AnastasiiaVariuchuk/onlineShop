package onlineShop.services.orderService;

import onlineShop.dao.idbcMySQL.products.ProductsDAO;
import onlineShop.dao.idbcMySQL.purchases.DiscountsDAO;
import onlineShop.dao.idbcMySQL.purchases.ProductOrdersDAO;
import onlineShop.models.products.Products;
import onlineShop.models.purchases.ProductOrders;
import onlineShop.models.purchases.ShoppingOrders;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.stream.Collectors;

public class Calculator {
    private static final Logger logger = LogManager.getLogger(Calculator.class);

    public static double totalPrice(ShoppingOrders shoppingOrders){
        ProductOrdersDAO productOrdersDAO = new ProductOrdersDAO();
        ProductsDAO productsDAO = new ProductsDAO();
        DiscountsDAO discountsDAO = new DiscountsDAO();
        List<ProductOrders> productOrders = productOrdersDAO.getAll().stream()
                .filter(productOrders1 -> productOrders1.getIdShoppingOrder() == shoppingOrders.getIdShoppingOrder())
                .collect(Collectors.toList());
        productOrders.forEach(logger::info);
        double price = 0;
        for(ProductOrders productOrders1 : productOrders) {
            Products product = new Products();
            product = productsDAO.getById(productOrders1.getIdProduct());
            logger.info(product.getProductPrice());
            price += product.getProductPrice() -
                    product.getProductPrice() * discountsDAO.getById(product.getIdDiscount()).getDiscountSize()/100;
        }
        return price;
    }
}
