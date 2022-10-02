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

public class Registration {
    private static final Logger logger = LogManager.getLogger(Registration.class);

    public static Users userRegistration(Customers customers) throws IOException {
        Scanner scanner = new Scanner(System.in);
        UsersDAO usersDAO = new UsersDAO();
        Users user = new Users();
        user.setIdUser((int) (usersDAO.getAll().stream().count()+1));
        boolean nameStatus = false;
        boolean emailStatus = false;
        boolean passwordStatus = false;

        logger.info("welcome to user registration");

        do {
            logger.info("Enter your nickname: ");
            String name = scanner.nextLine();
            try {
                if (!name.isEmpty() && FindUser.getByName(name) == null) {
                    user.setUserName(name);
                    nameStatus = true;
                } else {
                    logger.info("Please, try again!");
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } while (nameStatus != true);

        do {
            logger.info("Enter your email: ");
            String email = scanner.nextLine();
            try {
                if (email.contains("@") && email.contains(".") && FindUser.getByEmail(email) == null) {
                    user.setUserEmail(email);
                    emailStatus = true;
                } else {
                    logger.info("Please, try again!");
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } while (emailStatus!= true);

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

        user.setIdCustomer(customers.getIdCustomer());

        logger.info("Thank you for the registration!!");
        return user;
    }

    public static Customers customerRegistration() throws IOException {
        Scanner scanner = new Scanner(System.in);
        Customers customer = new Customers();
        CustomersDAO customersDAO = new CustomersDAO();
        boolean nameStatus = false;
        boolean surnameStatus = false;
        boolean phoneNumberStatus = false;
        boolean cardStatus = false;
        long count = customersDAO.getAll().stream().count();

        logger.info("welcome to customer registration");

        customer.setIdCustomer((int) (count+1));

        do {
            logger.info("Enter your name: ");
            String name = scanner.nextLine();
            if (name.matches("[A-Z][a-z]+")) {
                customer.setCustomerName(name);
                nameStatus = true;
            } else {
                logger.info("Please, use a capital letter at the beginning of a word!");
            }
        } while (nameStatus != true);

        do {
            logger.info("Enter your surname: ");
            String surname = scanner.nextLine();
            if (surname.matches("[A-Z][a-z]+")) {
                customer.setCustomerSurname(surname);
                surnameStatus = true;
            } else {
                logger.info("Please, use a capital letter at the beginning of a word!");
            }
        } while (surnameStatus != true);

        do {
            logger.info("Enter the card: ");
            String card = scanner.nextLine();
            if (card.length() == 16 && card.matches("\\d+")) {
                customer.setCustomerCard(card);
                cardStatus = true;
            } else {
                logger.info("Card must have 16 numeral characters!");
            }
        } while (cardStatus != true);

        do {
            logger.info("Enter the phone number:");
            String phoneNumber = scanner.nextLine();
            try {
                if (phoneNumber.length() >= 10 && phoneNumber.length() <= 13 && phoneNumber.matches("\\d+") && FindCustomer.getByPhone(phoneNumber) == null) {
                    String ph = "+" + phoneNumber;
                    customer.setCustomerPhoneNumber(ph);
                    phoneNumberStatus = true;
                } else {
                    logger.info("Phone number has wrong format! \n EX: (+380994445566)");
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } while (phoneNumberStatus != true);

        customer.setIdCustomerCategory(1);
        logger.info("Thank you for the registration!!");
        return customer;
    }
}