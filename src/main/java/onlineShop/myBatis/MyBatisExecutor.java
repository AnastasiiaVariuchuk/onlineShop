package onlineShop.myBatis;

import onlineShop.models.people.Customers;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

import java.util.List;


public class MyBatisExecutor {
    private static final Logger logger = (Logger) LogManager.getLogger(MyBatisExecutor.class);
    public static void main(String[] args) {
        //CustomersMyBatis customersMyBatis = new CustomersMyBatis();
        //customersMyBatis.getAll();
        //EmployeesMyBatis employeesMyBatis = new EmployeesMyBatis();
        //employeesMyBatis.getById(1);
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisConnection.getSqlSessionFactory().openSession();
            List<Customers> list = sqlSession.getMapper(CustomersMyBatis.class).getAll();
            for (Customers customers : list) {
                System.out.println(customers);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }
}
