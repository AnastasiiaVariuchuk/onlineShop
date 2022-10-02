package onlineShop;

import onlineShop.dao.idbcMySQL.people.CustomersDAO;
import onlineShop.dao.idbcMySQL.people.EmployeesDAO;
import onlineShop.dao.idbcMySQL.people.UsersDAO;
import onlineShop.dao.idbcMySQL.purchases.DeliveriesDAO;

import onlineShop.models.people.Customers;
import onlineShop.models.purchases.Deliveries;
import onlineShop.services.identification.FindUser;
import onlineShop.services.identification.Registration;
import onlineShop.services.identification.SingUp;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

public class Main {
    private final static Logger logger = LogManager.getLogger(Main.class);
    public static void main(String[] args) throws InterruptedException, IOException, SQLException {
        try (Connection connection = ConnectionUtil.getConnection()) {
            logger.info(String.format("Connected to database %s"
                    + " successfully.", connection.getCatalog()));
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }


        //CountryDAO = new CountriesDAO();

        //List<Countries> countries = CountryDAO.getAll();
        //logger.info(countries);
        //CustomersDAO = new CustomersDAO();
        //List<Customers> customers = CustomersDAO.getAll();
        //logger.info(customers);
        //Users user = Registration.userRegistration();
        //user.setIdUser(1);
        //user.setIdCustomer(56);
        //logger.info(user);
        //logger.info(Registration.customerRegistration());
        /*UsersDAO usersDAO = new UsersDAO();
        logger.info(usersDAO.getAll());
        logger.info(usersDAO.getById(2));
        Users users = new Users(1, "ANNA", "annaivanova@gmail.com", "1234567890", 1);
        //logger.info(Check.isUser(users));
        try {
            logger.info(FindUser.getByPassword("1234567890"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        logger.info(CheckUser.isCorrectPassword(users));*/
        /*AddressesDAO addressesDAO = new AddressesDAO();
        logger.info(addressesDAO.getAll());*/
        //logger.info(SingUp.entry());

        UsersDAO usersDAO = new UsersDAO();
        CustomersDAO customersDAO = new CustomersDAO();
        logger.info(usersDAO.getAll());
        logger.info(FindUser.getByName("iVV"));
        //logger.info(SingUp.entry());
        //Payment.createPayment(usersDAO.getById(2));
       // Delivery.createDelivery(usersDAO.getById(2));

       // ShoppingOrders shoppingOrders = Order.createOrder(usersDAO.getById(2));

        //ProductOrders productOrders = Order.createProductOrder(Assortment.chooseProduct(Assortment.chooseProductCategory()), shoppingOrders);


        //logger.info(shoppingOrders.getShoppingOrderTotalPrice());
        //ShoppingOrdersDAO shoppingOrdersDAO = new ShoppingOrdersDAO();
        //logger.info(Calculator.totalPrice(shoppingOrdersDAO.getById(11)));

    }
}
