package onlineShop.dao.idbcMySQLImpl.iplaces;

import onlineShop.models.places.Cities;
import onlineShop.models.places.Countries;

import java.util.List;

public interface ICountriesDAO {
    Countries getById(int id);

    List<Countries> getAll();

    void add(Countries countries);

    void update(Countries countries);

    void delete(int id);
}
