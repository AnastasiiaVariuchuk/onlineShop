package onlineShop.services.orderService;

import onlineShop.dao.idbcMySQL.people.CustomersDAO;
import onlineShop.dao.idbcMySQL.people.UsersDAO;
import onlineShop.models.people.Customers;
import onlineShop.models.people.Users;
import onlineShop.services.delivery.Delivery;
import onlineShop.services.identification.EntryResult;
import onlineShop.services.identification.Registration;
import onlineShop.services.identification.SingUp;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.Scanner;

public class Shopping {
    private static final Logger logger = LogManager.getLogger(Shopping.class);

    public static boolean shopping() {
        boolean shoppingStatus = false;
        logger.info("Welcome to our store");
        logger.info("You must register to make an order\nAre you a new customer?\n0 - Yes\n1 - No");

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        boolean success = false;
        CustomersDAO customersDAO = new CustomersDAO();
        UsersDAO usersDAO = new UsersDAO();
        Users user = new Users();
        Customers customer = new Customers();
        EntryResult entryResult = new EntryResult();

        if (choice == 0) {

            try {
                customer = Registration.customerRegistration();
                customersDAO.add(customer);

                user = Registration.userRegistration(customer);
                usersDAO.add(user);

                if (usersDAO.getById(user.getIdUser()) != null
                        && customersDAO.getById(customer.getIdCustomer()) != null) {
                    success = true;
                }
                logger.info("Registration status " + success);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else if (choice == 1) {
            entryResult = SingUp.entry();
            logger.info("Sing up status " + entryResult.isStatus());
            user = entryResult.getUsers();
        }

        logger.info("Let`s take a look at our range!");
        ShoppingCard shoppingCard = Order.createOrder(user);

        if (shoppingCard.getShoppingOrders().getShoppingOrderTotalPrice() != 0) {
            logger.info("Let's make delivery!");
            Delivery.createDelivery(user);
            logger.info("Let`s make payment!");
            Payment.createPayment(user);
            shoppingStatus = true;
        }
        return shoppingStatus;

    }

    //registration or SingUp
    //createOrder
    //payment
    //delivery
}
