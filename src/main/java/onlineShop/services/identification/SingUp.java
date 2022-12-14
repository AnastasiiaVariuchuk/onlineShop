package onlineShop.services.identification;

import onlineShop.dao.idbcMySQL.people.CustomersDAO;
import onlineShop.dao.idbcMySQL.people.UsersDAO;
import onlineShop.models.people.Customers;
import onlineShop.models.people.Users;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class SingUp {
    private static final Logger logger = LogManager.getLogger(SingUp.class);
    public static Users singUp() {
        Scanner scanner = new Scanner(System.in);
        boolean nameStatus = false;
        boolean passwordStatus = false;
        Users user = new Users();

        do {
            logger.info("Enter your nickname: ");
            String name = scanner.nextLine();
            if (!name.isEmpty()) {
                user.setUserName(name);
                nameStatus = true;
            } else {
                logger.info("Please, try again!");
            }
        } while (nameStatus != true);

        do {
            logger.info("Enter the password: ");
            String password = scanner.nextLine();
            if (password.length() >= 6) {
                user.setUserPassword(password);
                passwordStatus = true;
            } else {
                logger.info("Password must have at least 6 characters!");
            }
        } while (passwordStatus != true);

        return user;
    }

    public static EntryResult entry() {
        Scanner scanner = new Scanner(System.in);
        Users user = singUp();
        boolean singUpSuccess = false;
        EntryResult entryResult = new EntryResult();
        UsersDAO usersDAO = new UsersDAO();
        while (CheckUser.isUser(user) == false) {
            logger.info("No user with such nick! ");
            logger.info("\n1 - Try again\n2 - Exit\n3 - I`m new customer");
            int choice = scanner.nextInt();
            switch (choice) {
                case (1):
                    user = singUp();
                    singUpSuccess = CheckUser.isUser(user);
                    break;
                case (2):
                    singUpSuccess = false;
                    break;
                case (3):
                    try {
                        CustomersDAO customersDAO = new CustomersDAO();
                        Customers newCustomer = Registration.customerRegistration();
                        customersDAO.add(newCustomer);

                        Users newUser = Registration.userRegistration(newCustomer);
                        newUser.setIdCustomer(newCustomer.getIdCustomer());
                        usersDAO.add(newUser);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    singUpSuccess = true;
                    break;
            }
        }
        while (CheckUser.isCorrectPassword(user) == false) {
            logger.info("Your password is wrong! ");
            logger.info("\n1 - Try again\n2 - Exit\n");
            int choice = scanner.nextInt();
            switch (choice) {
                case (1):
                    user = singUp();
                    singUpSuccess = CheckUser.isCorrectPassword(user);
                    break;
                case (2):
                    singUpSuccess = false;
                    break;
            }
        }
        if(CheckUser.isUser(user) == true && CheckUser.isCorrectPassword(user)) {
            try {
                user = FindUser.getByName(user.getUserName());
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            singUpSuccess = true;
        }
        entryResult.setStatus(singUpSuccess);
        entryResult.setUsers(user);
        return entryResult;
    }
}
