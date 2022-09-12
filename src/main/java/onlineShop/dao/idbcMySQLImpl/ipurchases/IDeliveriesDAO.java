package onlineShop.dao.idbcMySQLImpl.ipurchases;

import onlineShop.models.purchases.Deliveries;

import java.time.LocalDateTime;
import java.util.List;

public interface IDeliveriesDAO {
    Deliveries getById(int id);

    List<Deliveries> getAll();

    void add(int id, int idAddress, int idUser, LocalDateTime deliveryDataTime, int idEmployee);

    void update(Deliveries deliveries);

    void delete(int id);
}
