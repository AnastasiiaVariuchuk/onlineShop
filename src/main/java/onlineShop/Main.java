package onlineShop;

import onlineShop.dao.idbcMySQL.people.CustomersDAO;
import onlineShop.dao.idbcMySQL.people.EmployeesDAO;
import onlineShop.dao.idbcMySQL.people.UsersDAO;
import onlineShop.dao.idbcMySQL.products.ProductsDAO;
import onlineShop.dao.idbcMySQL.purchases.DeliveriesDAO;

import onlineShop.dao.idbcMySQL.purchases.ProductOrdersDAO;
import onlineShop.dao.idbcMySQL.purchases.ShoppingOrdersDAO;
import onlineShop.models.people.Customers;
import onlineShop.models.purchases.Deliveries;
import onlineShop.models.purchases.ProductOrders;
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
       // ShoppingOrdersDAO shoppingOrdersDAO = new ShoppingOrdersDAO();
       // shoppingOrdersDAO.getAll().forEach(logger::info);

        logger.info(Shopping.shopping());
        //UsersDAO usersDAO = new UsersDAO();
        //Order.createOrder(usersDAO.getById(3));
       /* ProductsDAO productsDAO = new ProductsDAO();
        ShoppingOrdersDAO shoppingOrdersDAO = new ShoppingOrdersDAO();
        Order.createProductOrder(productsDAO.getById(1), shoppingOrdersDAO.getById(50));*/
       /* ProductOrdersDAO productOrdersDAO = new ProductOrdersDAO();
        ProductOrders productOrders = new ProductOrders(4, 4, 46);
        productOrdersDAO.add(productOrders);
        productOrdersDAO.getAll().forEach(logger::info);*/

    }
}
