package onlineShop.services.identification;

import onlineShop.dao.idbcMySQL.people.CustomersDAO;
import onlineShop.dao.idbcMySQL.people.UsersDAO;
import onlineShop.models.people.Customers;
import onlineShop.models.people.Users;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;

public class FindCustomer {
    private static final Logger logger = LogManager.getLogger(FindCustomer.class);

    public static Customers getByPhone(String phone) throws SQLException {
        CustomersDAO customersDAO = new CustomersDAO();
        return customersDAO.getAll().stream().findAny().filter(customers -> customers.getCustomerPhoneNumber().equals(phone)).orElse(null);
    }
}
