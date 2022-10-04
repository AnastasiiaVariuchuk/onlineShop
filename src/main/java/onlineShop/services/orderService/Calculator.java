package onlineShop.services.orderService;

import onlineShop.dao.idbcMySQL.people.UsersDAO;
import onlineShop.dao.idbcMySQL.products.ProductsDAO;
import onlineShop.dao.idbcMySQL.purchases.DiscountsDAO;
import onlineShop.dao.idbcMySQL.purchases.ProductOrdersDAO;
import onlineShop.models.people.Users;
import onlineShop.models.products.Products;
import onlineShop.models.purchases.ProductOrders;
import onlineShop.models.purchases.ShoppingOrders;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Calculator {
    private static final Logger logger = LogManager.getLogger(Calculator.class);

    public static double totalPrice(List<Products> productsList){
        DiscountsDAO discountsDAO = new DiscountsDAO();
        double price = 0;
        for(Products product : productsList) {
            logger.info(product.getProductPrice());
            price += product.getProductPrice() -
                    product.getProductPrice() * discountsDAO.getById(product.getIdDiscount()).getDiscountSize()/100;
        }
        return price;
    }
}
