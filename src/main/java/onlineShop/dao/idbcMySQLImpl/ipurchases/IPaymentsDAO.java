package onlineShop.dao.idbcMySQLImpl.ipurchases;

import onlineShop.models.purchases.Payments;

import java.sql.Timestamp;
import java.util.List;

public interface IPaymentsDAO {
    Payments getById(int id);

    List<Payments> getAll();

    void add(int id, int idCustomer, Timestamp paymentDateTime, boolean paymentStatus);

    void update(Payments payments);

    void delete(int id);
}
