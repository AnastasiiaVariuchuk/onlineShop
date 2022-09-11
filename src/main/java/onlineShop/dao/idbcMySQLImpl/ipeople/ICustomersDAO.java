package onlineShop.dao.idbcMySQLImpl.ipeople;

import onlineShop.models.people.Customers;
import onlineShop.models.people.CustomersCategories;

import java.util.List;

public interface ICustomersDAO {
    Customers getById(int id);

    List<Customers> getAll();

    void add(int id, String customerName, String customerSurname, String customerCard,
             String customerPhoneNumber, int idCustomerCategory);

    void update(Customers customers);

    void delete(int id);
}
