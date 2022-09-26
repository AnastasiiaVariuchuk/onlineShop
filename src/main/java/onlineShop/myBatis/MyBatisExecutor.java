package onlineShop.myBatis;

import onlineShop.models.people.Customers;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

import java.util.LinkedList;
import java.util.List;


public class MyBatisExecutor {
    private static final Logger logger = (Logger) LogManager.getLogger(MyBatisExecutor.class);
    public static void main(String[] args) {
        //CustomersMyBatis customersMyBatis = new CustomersMyBatis();
        //customersMyBatis.getAll();
        //EmployeesMyBatis employeesMyBatis = new EmployeesMyBatis();
        //employeesMyBatis.getAll();
        CustomersCategoriesMyBatis customersCategoriesMyBatis = new CustomersCategoriesMyBatis();
        customersCategoriesMyBatis.getAll();
    }
}
