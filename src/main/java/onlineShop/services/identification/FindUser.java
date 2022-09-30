package onlineShop.services.identification;

import onlineShop.dao.idbcMySQL.people.UsersDAO;
import onlineShop.models.people.Users;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;

public class FindUser {
    private static final Logger logger = LogManager.getLogger(FindUser.class);

    public static Users getByName(String name) throws SQLException {
        UsersDAO usersDAO = new UsersDAO();
        return usersDAO.getAll().stream().findAny().filter(users -> users.getUserName().equals(name)).orElse(null);
    }

    public static Users getByPassword(String password) throws SQLException {
        UsersDAO usersDAO = new UsersDAO();
        return usersDAO.getAll().stream().findAny().filter(users -> users.getUserPassword().equals(password)).orElse(null);
    }
}
