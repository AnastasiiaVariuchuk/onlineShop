package onlineShop.services.identification;


import onlineShop.models.people.Customers;
import onlineShop.models.people.Users;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.Scanner;

public class Registration {
    private static final Logger logger = LogManager.getLogger(Registration.class);

    public static Users userRegistration() throws IOException {
        Scanner scanner = new Scanner(System.in);
        Users user = new Users();
        boolean nameStatus = false;
        boolean emailStatus = false;
        boolean passwordStatus = false;

        logger.info("welcome to user registration");

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
            logger.info("Enter your email: ");
            String email = scanner.nextLine();
            if (email.contains("@") && email.contains(".")) {
                user.setUserEmail(email);
                emailStatus = true;
            } else {
                logger.info("Please, try again!");
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

        logger.info("Thank you for the registration!!");
        return user;
    }

    public static Customers customerRegistration() throws IOException {
        Scanner scanner = new Scanner(System.in);
        Customers customer = new Customers();
        boolean nameStatus = false;
        boolean surnameStatus = false;
        boolean phoneNumberStatus = false;
        boolean cardStatus = false;
        //boolean customerStatus = false;

        logger.info("welcome to customer registration");

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
            if (phoneNumber.length() >= 10 && phoneNumber.length() <= 13 && phoneNumber.matches("\\d+")) {
                String ph = "+" + phoneNumber;
                customer.setCustomerPhoneNumber(ph);
                phoneNumberStatus = true;
            } else {
                logger.info("Phone number has wrong format! \n EX: (+380994445566)");
            }
        } while (phoneNumberStatus != true);

        customer.setIdCustomerCategory(1);
        logger.info("Thank you for the registration!!");
        return customer;
    }
}