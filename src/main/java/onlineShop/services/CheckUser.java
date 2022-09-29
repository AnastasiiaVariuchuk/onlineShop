package onlineShop.services;

import onlineShop.models.people.Users;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;

public class CheckUser {
    private static final Logger logger = LogManager.getLogger(CheckUser.class);

    public static boolean isUser(Users user) {
        boolean isUser = false;
        try {
            if(FindUser.getByName(user.getUserName()) != null) {
                isUser = true;
            };
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return isUser;
    }

    public static boolean isCorrectPassword(Users user) {
        boolean isCorrectPassword = false;
        if(isUser(user)) {
            try {
                if(FindUser.getByPassword(user.getUserPassword()) != null) {
                    int user1 = FindUser.getByName(user.getUserName()).getIdUser();
                    int user2 = FindUser.getByPassword(user.getUserPassword()).getIdUser();
                    if (user1 == user2)
                        isCorrectPassword = true;
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return isCorrectPassword;
    }
}
