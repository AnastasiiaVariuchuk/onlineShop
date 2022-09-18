package onlineShop.dao.idbcMySQLImpl.ipurchases;

import onlineShop.models.purchases.Deliveries;

import java.time.LocalDateTime;
import java.util.List;

public interface IDeliveriesDAO {
    Deliveries getById(int id);

    List<Deliveries> getAll();

    void add(Deliveries deliveries);

    void update(Deliveries deliveries);

    void delete(int id);
}
