package onlineShop.services.orderService;

import onlineShop.dao.idbcMySQL.purchases.ProductOrdersDAO;
import onlineShop.dao.idbcMySQL.purchases.ShoppingOrdersDAO;
import onlineShop.models.people.Users;
import onlineShop.models.products.Products;
import onlineShop.models.purchases.ProductOrders;
import onlineShop.models.purchases.ShoppingOrders;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Date;
import java.util.Scanner;

import static onlineShop.services.orderService.Assortment.chooseProduct;
import static onlineShop.services.orderService.Assortment.chooseProductCategory;


public class Order {
    private static final Logger logger = LogManager.getLogger(Order.class);
    public static ShoppingOrders createShoppingOrder(Users users){
        ShoppingOrdersDAO shoppingOrdersDAO = new ShoppingOrdersDAO();
        ShoppingOrders shoppingOrders = new ShoppingOrders();
        long count = shoppingOrdersDAO.getAll().stream().count();
        shoppingOrders.setIdShoppingOrder((int) count + 1);
        shoppingOrders.setIdUser(users.getIdUser());
        java.util.Date d1 = new Date();
        Long l1 = d1.getTime();
        java.sql.Date date = new java.sql.Date(l1);
        shoppingOrders.setShoppingOrderDate(date);
        shoppingOrdersDAO.add(shoppingOrders);
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

    public static ShoppingOrders createOrder(Users users) {
        ShoppingOrdersDAO shoppingOrdersDAO = new ShoppingOrdersDAO();
        ProductOrdersDAO productOrdersDAO = new ProductOrdersDAO();
        ShoppingOrders shoppingOrder1 = createShoppingOrder(users);
        boolean choiceStatus = false;
        Scanner scanner = new Scanner(System.in);
        do {
            logger.info("Do tou want to choose products?\n0 - No\n1 - Yes ");
            int choice = scanner.nextInt();
            if (choice == 1) {
                ProductOrders productOrders1 = createProductOrder(chooseProduct(chooseProductCategory()), shoppingOrder1);
                logger.info("How many units of this product?");
                int units = scanner.nextInt();
                for (int i = 0; i < units; i++) {
                    productOrdersDAO.add(productOrders1);
                }
                choiceStatus = false;
            } else {
                logger.info("Order loading...");
                choiceStatus = true;
            }
        } while (choiceStatus != true);

        shoppingOrder1.setShoppingOrderTotalPrice(Calculator.totalPrice(shoppingOrder1));
        shoppingOrdersDAO.update(shoppingOrder1);
        return shoppingOrder1;
    }
}
