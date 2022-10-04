package onlineShop.patterns.factory;

import onlineShop.dao.idbcMySQL.people.CustomersDAO;
import onlineShop.dao.idbcMySQL.people.UsersDAO;
import onlineShop.models.people.Customers;
import onlineShop.services.identification.Registration;

import java.io.IOException;

public class RegistrationMethod implements ServiceManager{
    @Override
    public void createServiceManager() {
        CustomersDAO customersDAO = new CustomersDAO();
        UsersDAO usersDAO = new UsersDAO();
        try {
            Customers customer = Registration.customerRegistration();
            customersDAO.add(customer);
            usersDAO.add(Registration.userRegistration(customer));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
