package onlineShop;

import onlineShop.dao.idbcMySQL.places.CountriesDAO;
import onlineShop.dao.idbcMySQLImpl.iplaces.ICountriesDAO;
import onlineShop.models.places.Countries;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class Main {
    private final static Logger MAIN_LOGGER = LogManager.getLogger(Main.class);
    private static ICountriesDAO CountryDAO;
    public static void main(String[] args) throws InterruptedException {
        // create a new connection from MySQLJDBCUtil
        try (Connection connection = ConnectionUtil.getConnection()) {
            // print out a message
            System.out.println(String.format("Connected to database %s"
                    + " successfully.", connection.getCatalog()));
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }


        CountryDAO = new CountriesDAO();

        List<Countries> countries = CountryDAO.getAll();
        MAIN_LOGGER.info(countries);

        //CountryDAO.add(3,"Canada");

        //CountryDAO.getById(3);

        //CountryDAO.update(new Countries(7, "Japan"));

        //CountryDAO.getById(3);

        //CountryDAO.delete(5);

        System.out.println(countries);
    }
}
