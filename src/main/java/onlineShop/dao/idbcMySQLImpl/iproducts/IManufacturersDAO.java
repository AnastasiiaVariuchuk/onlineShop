package onlineShop.dao.idbcMySQLImpl.iproducts;

import onlineShop.models.people.Users;
import onlineShop.models.products.Manufacturers;

import java.util.List;

public interface IManufacturersDAO {
    Manufacturers getById(int id);

    List<Manufacturers> getAll();

    void add(Manufacturers manufacturers);

    void update(Manufacturers manufacturers);

    void delete(int id);
}
