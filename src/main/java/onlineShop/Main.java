package onlineShop;

import onlineShop.dao.idbcMySQL.people.CustomersDAO;
import onlineShop.dao.idbcMySQL.places.CountriesDAO;
import onlineShop.dao.idbcMySQLImpl.ipeople.ICustomersDAO;
import onlineShop.dao.idbcMySQLImpl.iplaces.ICountriesDAO;
import onlineShop.models.people.Customers;
import onlineShop.models.places.Countries;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class Main {
    private final static Logger logger = LogManager.getLogger(Main.class);
    private static ICountriesDAO CountryDAO;
    private static ICustomersDAO CustomersDAO;
    public static void main(String[] args) throws InterruptedException {
        try (Connection connection = ConnectionUtil.getConnection()) {
            logger.info(String.format("Connected to database %s"
                    + " successfully.", connection.getCatalog()));
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }


        //CountryDAO = new CountriesDAO();

        //List<Countries> countries = CountryDAO.getAll();
        //logger.info(countries);
        CustomersDAO = new CustomersDAO();
        List<Customers> customers = CustomersDAO.getAll();
        logger.info(customers);
    }
}
