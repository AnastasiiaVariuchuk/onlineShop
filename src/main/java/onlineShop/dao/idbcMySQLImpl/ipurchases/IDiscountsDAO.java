package onlineShop.dao.idbcMySQLImpl.ipurchases;

import onlineShop.models.purchases.Discounts;

import java.util.List;

public interface IDiscountsDAO {
    Discounts getById(int id);

    List<Discounts> getAll();

    void add(int id, double discountSize);
    void add(Discounts discounts);

    void update(Discounts discounts);

    void delete(int id);
}
