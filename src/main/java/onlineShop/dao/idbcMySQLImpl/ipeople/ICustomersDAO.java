package onlineShop.dao.idbcMySQLImpl.ipeople;

import onlineShop.models.people.Customers;

import java.util.List;

public interface ICustomersDAO {
    Customers getById(int id);

    List<Customers> getAll();

    void add(Customers customers);

    void update(Customers customers);

    void delete(int id);
}
