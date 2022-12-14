package onlineShop.dao.idbcMySQLImpl.ipeople;

import onlineShop.models.people.Employees;
import onlineShop.models.people.Users;

import java.util.List;

public interface IUsersDAO {
    Users getById(int id);

    List<Users> getAll();

    void add(Users users);

    void update(Users users);

    void delete(int id);
}
