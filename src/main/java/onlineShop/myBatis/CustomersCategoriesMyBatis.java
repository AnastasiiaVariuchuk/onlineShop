package onlineShop.myBatis;

import onlineShop.dao.idbcMySQLImpl.ipeople.ICustomersCategoriesDAO;
import onlineShop.models.people.CustomersCategories;

import java.util.List;

public class CustomersCategoriesMyBatis implements ICustomersCategoriesDAO {
    @Override
    public CustomersCategories getById(int id) {
        return null;
    }

    @Override
    public List<CustomersCategories> getAll() {
        return null;
    }

    @Override
    public void add(CustomersCategories customersCategories) {

    }

    @Override
    public void update(CustomersCategories customersCategories) {

    }

    @Override
    public void delete(int id) {

    }
}
