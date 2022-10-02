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
        for(Customers customer: customersDAO.getAll()) {
            if(customer.getCustomerPhoneNumber().equals(phone)){
                return customer;
            }
        }
        return null;
    }
}
