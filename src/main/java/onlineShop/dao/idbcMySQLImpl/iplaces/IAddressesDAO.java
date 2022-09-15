package onlineShop.dao.idbcMySQLImpl.iplaces;

import onlineShop.models.places.Addresses;

import java.util.List;

public interface IAddressesDAO {
    Addresses getById(int id);

    List<Addresses> getAll();

    void add(int id, String addressName, String addressPostalCode, int idCity);

    void add(Addresses addresses);

    void update(Addresses addresses);

    void delete(int id);
}
