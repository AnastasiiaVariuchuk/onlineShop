package onlineShop.services.admin;

import onlineShop.dao.idbcMySQL.people.EmployeesDAO;
import onlineShop.models.people.Employees;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class EmployeeManager {
    private static final Logger logger = LogManager.getLogger(EmployeeManager.class);
    public static void addEmployee() {
        EmployeesDAO employeesDAO = new EmployeesDAO();
        Scanner scanner = new Scanner(System.in);
        long count = employeesDAO.getAll().stream().count();
        int id = ((int) count + 1);
        logger.info("Enter Name");
        String name = scanner.nextLine();
        logger.info("Enter Surname");
        String surname = scanner.nextLine();
        logger.info("Enter Email");
        String email = scanner.nextLine();
        logger.info("Enter Salary");
        double salary = scanner.nextDouble();
        Employees employees = new Employees(id, name, surname, email, salary);
        employeesDAO.add(employees);
    }

    public static void updateEmployee() {
        EmployeesDAO employeesDAO = new EmployeesDAO();
        employeesDAO.getAll().forEach(logger::info);
        Scanner scanner = new Scanner(System.in);
        logger.info("Choose employee(enter id)");
        int id = scanner.nextInt();
        Employees employees = employeesDAO.getById(id);
        logger.info("What do you want to update?\n1 - email\n2 - salary\n3 - exit");
        int i = scanner.nextInt();
        switch (i) {
            case (1):
                logger.info("Enter new email");
                String newEmail = scanner.next();
                employees.setEmployeeContact(newEmail);
                employeesDAO.update(employees);
                break;
            case (2):
                logger.info("Enter new salary");
                double newSalary = scanner.nextDouble();
                employees.setEmployeeSalary(newSalary);
                employeesDAO.update(employees);
                break;
            case (3):
                break;
        }
    }

    public static void deleteEmployee() {
        EmployeesDAO employeesDAO = new EmployeesDAO();
        employeesDAO.getAll().forEach(logger::info);
        Scanner scanner = new Scanner(System.in);
        logger.info("Choose employee(enter id)");
        int id = scanner.nextInt();
        employeesDAO.delete(id);
    }
}
