package onlineShop.dao.idbcMySQLImpl.ipeople;

import onlineShop.models.people.Customers;
import onlineShop.models.people.Employees;

import java.util.List;

public interface IEmployeesDAO {
    Employees getById(int id);

    List<Employees> getAll();

    void add(Employees employees);

    void update(Employees employees);

    void delete(int id);
}
