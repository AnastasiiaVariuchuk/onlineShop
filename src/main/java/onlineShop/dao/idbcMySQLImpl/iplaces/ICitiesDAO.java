package onlineShop.dao.idbcMySQLImpl.iplaces;

import onlineShop.models.places.Addresses;
import onlineShop.models.places.Cities;

import java.util.List;

public interface ICitiesDAO {
    Cities getById(int id);

    List<Cities> getAll();

    void add(int id, String cityName, String cityPostalCode, int idCountry);

    void add(Cities cities);

    void update(Cities cities);

    void delete(int id);
}
