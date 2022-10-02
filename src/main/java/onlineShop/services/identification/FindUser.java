package onlineShop.services.identification;

import onlineShop.dao.idbcMySQL.people.UsersDAO;
import onlineShop.models.people.Users;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class FindUser {
    private static final Logger logger = LogManager.getLogger(FindUser.class);

    public static Users getByName(String name) throws SQLException {
        UsersDAO usersDAO = new UsersDAO();
        for(Users user: usersDAO.getAll()) {
            if(user.getUserName().equals(name)){
                return user;
            }
        }
        return null;
    }

    public static Users getByPassword(String password) throws SQLException {
        UsersDAO usersDAO = new UsersDAO();
        for(Users user: usersDAO.getAll()) {
            if(user.getUserPassword().equals(password)){
                return user;
            }
        }
        return null;
    }

    public static Users getByEmail(String email) throws SQLException{
        UsersDAO usersDAO = new UsersDAO();
        for(Users user: usersDAO.getAll()) {
            if(user.getUserEmail().equals(email)){
                return user;
            }
        }
        return null;
    }
}
