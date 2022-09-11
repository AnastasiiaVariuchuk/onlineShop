package onlineShop.dao.idbcMySQL.people;

import onlineShop.ConnectionUtil;
import onlineShop.dao.idbcMySQLImpl.ipeople.IEmployeesDAO;
import onlineShop.models.people.Customers;
import onlineShop.models.people.Employees;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class EmployeesDAO implements IEmployeesDAO {
    private static final Logger logger = LogManager.getLogger(EmployeesDAO.class);
    List<Employees> employees = new LinkedList<>();
    private Employees getEmployeesById(ResultSet resultSet) throws SQLException {
        Employees employees1 = new Employees();
        employees1.setIdEmployee(resultSet.getInt("idemployee"));
        employees1.setEmployeeName(resultSet.getString("employeeName"));
        employees1.setEmployeeSurname(resultSet.getString("employeeSurname"));
        employees1.setEmployeeContact(resultSet.getString("employeeContact"));
        employees1.setEmployeeSalary(resultSet.getDouble("employeeSalary"));
        return employees1;
    }
    @Override
    public Employees getById(int id) {
        Connection connection = ConnectionUtil.getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM employees WHERE idemployee=" + id);
            if (resultSet.next()) {
                logger.info(getEmployeesById(resultSet));
                return getEmployeesById(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Employees> getAll() {
        PreparedStatement preparedStatement;
        Connection connection = ConnectionUtil.getConnection();
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM employees");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                employees.add(getEmployeesById(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
    }

    @Override
    public void add(int id, String employeeName, String employeeSurname, String employeeContact, double employeeSalary) {
        Connection connection = ConnectionUtil.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO employees VALUE(default, ?, ?, ?, ?, ?)");
            preparedStatement.setString(1, employeeName);
            preparedStatement.setString(2, employeeSurname);
            preparedStatement.setString(3, employeeContact);
            preparedStatement.setDouble(4, employeeSalary);
            if (preparedStatement.executeUpdate() == 1) {
                logger.info("Insertion is successful.");
            } else
                logger.info("Insertion was failed.");
        } catch (SQLException e) {
            e.getMessage();
        }
    }

    @Override
    public void update(Employees employees) {
        Connection connection = ConnectionUtil.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE employees SET employeeName=?, " +
                    "employeeSurname=?, employeeContact=?, employeeSalary=? WHERE idemployee=?");
            preparedStatement.setString(1, employees.getEmployeeName());
            preparedStatement.setString(2, employees.getEmployeeSurname());
            preparedStatement.setString(3, employees.getEmployeeContact());
            preparedStatement.setDouble(4, employees.getEmployeeSalary());
            preparedStatement.setInt(5, employees.getIdEmployee());
            if (preparedStatement.executeUpdate() == 1) {
                logger.info("Update process is successful: " + employees.getEmployeeName() + employees.getEmployeeSurname());
            } else
                logger.info("Update process was failed: " + employees.getEmployeeName() + employees.getEmployeeSurname());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        Connection connection = ConnectionUtil.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM employees " +
                    "WHERE idemployee=" + id);
            if (preparedStatement.executeUpdate() == 1) {
                logger.info("Delete process is successful.");
            } else
                logger.info("Delete process was failed.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
