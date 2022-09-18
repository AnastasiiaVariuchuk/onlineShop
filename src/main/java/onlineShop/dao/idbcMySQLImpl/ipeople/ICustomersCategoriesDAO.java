package onlineShop.dao.idbcMySQLImpl.ipeople;

import onlineShop.models.people.CustomersCategories;
import onlineShop.models.places.Addresses;

import java.util.List;

public interface ICustomersCategoriesDAO {
    CustomersCategories getById(int id);

    List<CustomersCategories> getAll();

    void add(CustomersCategories customersCategories);

    void update(CustomersCategories customersCategories);

    void delete(int id);
}
