package onlineShop;

import onlineShop.dao.idbcMySQL.people.CustomersDAO;
import onlineShop.dao.idbcMySQL.people.EmployeesDAO;
import onlineShop.dao.idbcMySQL.people.UsersDAO;
import onlineShop.dao.idbcMySQL.purchases.DeliveriesDAO;

import onlineShop.models.people.Customers;
import onlineShop.models.purchases.Deliveries;
import onlineShop.services.Shopping;
import onlineShop.services.identification.FindUser;
import onlineShop.services.identification.Registration;
import onlineShop.services.identification.SingUp;
import onlineShop.services.orderService.Order;
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
        logger.info(Shopping.shopping());
        //UsersDAO usersDAO = new UsersDAO();
        //Order.createShoppingOrder(usersDAO.getById(3));
        //Order.createOrder(usersDAO.getById(3));

    }
}
