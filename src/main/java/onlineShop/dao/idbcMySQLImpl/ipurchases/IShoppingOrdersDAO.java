package onlineShop.dao.idbcMySQLImpl.ipurchases;

import onlineShop.dao.idbcMySQL.purchases.ShoppingOrdersDAO;
import onlineShop.models.purchases.ProductOrders;
import onlineShop.models.purchases.ShoppingOrders;

import java.util.Date;
import java.util.List;

public interface IShoppingOrdersDAO {
    ShoppingOrders getById(int id);

    List<ShoppingOrders> getAll();

    void add(int id, Date shoppingOrderDate, double shoppingOrderTotalPrice, int idUser);

    void add(ShoppingOrders shoppingOrders);

    void update(ShoppingOrders shoppingOrders);

    void delete(int id);
}
