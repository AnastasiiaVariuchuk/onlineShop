package onlineShop.services;

import onlineShop.dao.idbcMySQL.people.EmployeesDAO;
import onlineShop.dao.idbcMySQL.purchases.ProductOrdersDAO;
import onlineShop.dao.idbcMySQL.purchases.ShoppingOrdersDAO;
import onlineShop.models.products.Products;
import onlineShop.models.purchases.ProductOrders;
import onlineShop.models.purchases.ShoppingOrders;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Date;


public class Order {
    private static final Logger logger = LogManager.getLogger(Order.class);
    public static ShoppingOrders createShoppingOrder(){
        ShoppingOrdersDAO shoppingOrdersDAO = new ShoppingOrdersDAO();
        ShoppingOrders shoppingOrders = new ShoppingOrders();
        long count = shoppingOrdersDAO.getAll().stream().count();
        shoppingOrders.setIdShoppingOrder((int) count + 1);

        EmployeesDAO employeesDAO = new EmployeesDAO();
        long countEmpl = employeesDAO.getAll().stream().count();
        shoppingOrders.setIdUser((int) (1+Math.random()*countEmpl));

        Date date = new Date();
        shoppingOrders.setShoppingOrderDate(date);
        return shoppingOrders;
    }

    public static ProductOrders createProductOrder(Products products, ShoppingOrders shoppingOrders) {
        ProductOrdersDAO productOrdersDAO = new ProductOrdersDAO();
        ProductOrders productOrders = new ProductOrders();
        long count = productOrdersDAO.getAll().stream().count();
        productOrders.setIdProductOrder((int) count + 1);
        productOrders.setIdProduct(products.getIdProduct());
        productOrders.setIdShoppingOrder(shoppingOrders.getIdShoppingOrder());
        productOrdersDAO.add(productOrders);
        return productOrders;
    }

    public static void createOrder() {

    }
}
