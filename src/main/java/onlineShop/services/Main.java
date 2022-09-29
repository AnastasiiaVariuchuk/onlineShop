package onlineShop.services;

import onlineShop.ConnectionUtil;
import onlineShop.dao.idbcMySQL.people.UsersDAO;
import onlineShop.dao.idbcMySQLImpl.ipeople.ICustomersDAO;
import onlineShop.dao.idbcMySQLImpl.iplaces.ICountriesDAO;
import onlineShop.models.people.Users;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    private final static Logger logger = LogManager.getLogger(Main.class);
    private static ICountriesDAO CountryDAO;
    private static ICustomersDAO CustomersDAO;
    public static void main(String[] args) throws InterruptedException, IOException {
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
        UsersDAO usersDAO = new UsersDAO();
        logger.info(usersDAO.getAll());
        Users users = new Users(1, "ANNA", "annaivanova@gmail.com", "1234567890", 1);
        //logger.info(Check.isUser(users));
        try {
            logger.info(FindUser.getByPassword("1234567890"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        logger.info(CheckUser.isCorrectPassword(users));

    }
}
