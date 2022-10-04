package onlineShop.services.orderService;

import onlineShop.dao.idbcMySQL.products.ProductsDAO;
import onlineShop.dao.idbcMySQL.purchases.ProductOrdersDAO;
import onlineShop.dao.idbcMySQL.purchases.ShoppingOrdersDAO;
import onlineShop.models.people.Users;
import onlineShop.models.products.Products;
import onlineShop.models.purchases.ProductOrders;
import onlineShop.models.purchases.ShoppingOrders;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import static onlineShop.services.orderService.Assortment.chooseProduct;
import static onlineShop.services.orderService.Assortment.chooseProductCategory;


public class Order {
    private static final Logger logger = LogManager.getLogger(Order.class);
    public static ShoppingOrders createShoppingOrder(Users users){
        ShoppingOrdersDAO shoppingOrdersDAO = new ShoppingOrdersDAO();
        ShoppingOrders shoppingOrders = new ShoppingOrders();
        long count = shoppingOrdersDAO.getAll().stream().count();
        shoppingOrders.setIdShoppingOrder((int) count + 100);
        shoppingOrders.setIdUser(users.getIdUser());
        java.util.Date d1 = new Date();
        Long l1 = d1.getTime();
        java.sql.Date date = new java.sql.Date(l1);
        shoppingOrders.setShoppingOrderDate(date);
        shoppingOrders.setShoppingOrderTotalPrice(0);
        shoppingOrdersDAO.add(shoppingOrders);
        return shoppingOrders;
    }

    public static ShoppingCard createOrder(Users users) {
        ShoppingOrdersDAO shoppingOrdersDAO = new ShoppingOrdersDAO();
        ShoppingOrders shoppingOrder1 = createShoppingOrder(users);;
        ShoppingCard shoppingCard = new ShoppingCard();
        List<Products> productList = new ArrayList<>();
        Products product1 = new Products();
        boolean choiceStatus = false;
        Scanner scanner = new Scanner(System.in);
        do {
            logger.info("Do tou want to choose products?\n0 - No\n1 - Yes ");
            int choice = scanner.nextInt();
            if (choice == 1) {
                product1 = chooseProduct(chooseProductCategory());
                logger.info("How many units of this product?");
                int units = scanner.nextInt();
                for (int i = 0; i < units; i++) {
                    productList.add(product1);
                }
                choiceStatus = false;
            } else {
                logger.info("Order loading...");
                choiceStatus = true;
            }
        } while (choiceStatus != true);

        shoppingCard.setProductsList(productList);
        shoppingCard.setShoppingOrders(shoppingOrder1);

        double price = Calculator.totalPrice(productList);

        shoppingOrder1.setShoppingOrderTotalPrice(price);
        shoppingOrdersDAO.update(shoppingOrder1);
        logger.info("Total Price => " + shoppingOrder1.getShoppingOrderTotalPrice());
        return shoppingCard;
    }
}
