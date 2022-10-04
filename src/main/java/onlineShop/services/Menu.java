package onlineShop.services;

import onlineShop.Main;
import onlineShop.services.admin.Administrator;
import onlineShop.services.admin.EmployeeManager;
import onlineShop.services.orderService.Shopping;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class Menu {
    private final static Logger logger = LogManager.getLogger(Menu.class);
    public static void getMenu(){
        logger.info("Choose the mode of operation\n1 - I'm client\n2 - I`m administrator");
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        switch (i) {
            case (1):
                logger.info("Success => " + Shopping.shopping());
                break;
            case (2):
                boolean adminStatus = false;
                String password = null;
                do {
                    logger.info("Enter the password => ");
                    password = scanner.next();
                    if(password.equals(Administrator.getPassword()) == false ) {
                        logger.info("Do ypu want to exit\n1 - Yes\n0 - NO");
                        int exit = scanner.nextInt();
                        if (exit == 1) {
                            adminStatus = true;
                        }
                    }
                } while (password.equals(Administrator.getPassword()) == false || adminStatus != false );
                boolean adminStatus1 = false;
                do {
                    if (password.equals(Administrator.getPassword())){
                        logger.info("Choose changes you want to do\n1 - EmployeeManager");
                        int j = scanner.nextInt();
                        boolean employeeManagerStatus;
                        switch (j) {
                            case (1):
                                logger.info("EmployeeManager");
                                employeeManagerStatus = false;
                                do {
                                    logger.info("Choose changes you want to do\n1 - add\n2 - update\n3 - delete");
                                    int k = scanner.nextInt();
                                    switch (k) {
                                        case (1):
                                            EmployeeManager.addEmployee();
                                            break;
                                        case (2):
                                            EmployeeManager.updateEmployee();
                                            break;
                                        case (3):
                                            EmployeeManager.deleteEmployee();
                                            break;
                                    }
                                    logger.info("Do you want to exit?\n0 - Yes\n1 - No");
                                    int exit = scanner.nextInt();
                                    if (exit == 0) {
                                        employeeManagerStatus = true;
                                    }
                                } while (employeeManagerStatus != true);
                                break;
                        }
                        logger.info("Do you want to exit from Admin?\n0 - Yes\n1 - No");
                        int exit = scanner.nextInt();
                        if (exit == 0) {
                            adminStatus1 = true;
                        }
                    }
                } while (adminStatus1 != true);
                break;
        }
    }
}
