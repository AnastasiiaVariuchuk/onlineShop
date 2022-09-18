package onlineShop.dao.idbcMySQLImpl.ipurchases;

import onlineShop.models.purchases.Payments;

import java.sql.Timestamp;
import java.util.List;

public interface IPaymentsDAO {
    Payments getById(int id);

    List<Payments> getAll();

    void add(Payments payments);

    void update(Payments payments);

    void delete(int id);
}
