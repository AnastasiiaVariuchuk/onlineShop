package onlineShop;

import onlineShop.dao.idbcMySQL.places.CountriesDAO;
import onlineShop.dao.idbcMySQL.products.ProductCategoriesDAO;
import onlineShop.dao.idbcMySQL.products.ProductsDAO;
import onlineShop.models.places.Countries;
import onlineShop.models.products.Products;
import onlineShop.services.Menu;
import onlineShop.services.admin.EmployeeManager;
import onlineShop.services.orderService.Payment;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    private final static Logger logger = LogManager.getLogger(Main.class);
    public static void main(String[] args) throws InterruptedException, IOException, SQLException {
        try (Connection connection = ConnectionUtil.getConnection()) {
            logger.info(String.format("Connected to database %s"
                    + " successfully.", connection.getCatalog()));
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        Menu.getMenu();
    }
}
