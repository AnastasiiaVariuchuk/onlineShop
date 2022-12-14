package onlineShop.dao.idbcMySQLImpl.ipurchases;

import onlineShop.models.purchases.ProductOrders;

import java.util.List;

public interface IProductOrdersDAO {
    ProductOrders getById(int id);

    List<ProductOrders> getAll();

    void add(ProductOrders productOrders);

    void update(ProductOrders productOrders);

    void delete(int id);
}
