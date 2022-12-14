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
        ResultSet resultSet = null;
        Statement statement = null;
        Connection connection = ConnectionUtil.getConnection();
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM employees WHERE idemployee=" + id);
            if (resultSet.next()) {
                logger.info(getEmployeesById(resultSet));
                return getEmployeesById(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionUtil.close(resultSet);
            ConnectionUtil.close(statement);
            ConnectionUtil.close(connection);
        }
        return null;
    }

    @Override
    public List<Employees> getAll() {
        List<Employees> employees = new LinkedList<>();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Connection connection = ConnectionUtil.getConnection();
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM employees");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                employees.add(getEmployeesById(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionUtil.close(resultSet);
            ConnectionUtil.close(preparedStatement);
            ConnectionUtil.close(connection);
        }
        return employees;
    }

    @Override
    public void add(Employees employees) {
        PreparedStatement preparedStatement = null;
        Connection connection = ConnectionUtil.getConnection();
        try {
            preparedStatement = connection.prepareStatement("INSERT INTO employees VALUES(?, ?, ?, ?, ?)");
            preparedStatement.setInt(1, employees.getIdEmployee());
            preparedStatement.setString(2, employees.getEmployeeName());
            preparedStatement.setString(3, employees.getEmployeeSurname());
            preparedStatement.setString(4, employees.getEmployeeContact());
            preparedStatement.setDouble(5, employees.getEmployeeSalary());
            if (preparedStatement.executeUpdate() == 1) {
                logger.info("Insertion is successful.");
            } else
                logger.info("Insertion was failed.");
        } catch (SQLException e) {
            e.getMessage();
        } finally {
            ConnectionUtil.close(preparedStatement);
            ConnectionUtil.close(connection);
        }
    }

    @Override
    public void update(Employees employees) {
        PreparedStatement preparedStatement = null;
        Connection connection = ConnectionUtil.getConnection();
        try {
            preparedStatement = connection.prepareStatement("UPDATE employees SET employeeName=?, " +
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
        } finally {
            ConnectionUtil.close(preparedStatement);
            ConnectionUtil.close(connection);
        }
    }

    @Override
    public void delete(int id) {
        PreparedStatement preparedStatement = null;
        Connection connection = ConnectionUtil.getConnection();
        try {
            preparedStatement = connection.prepareStatement("DELETE FROM employees " +
                    "WHERE idemployee=" + id);
            if (preparedStatement.executeUpdate() == 1) {
                logger.info("Delete process is successful.");
            } else
                logger.info("Delete process was failed.");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionUtil.close(preparedStatement);
            ConnectionUtil.close(connection);
        }
    }
}
