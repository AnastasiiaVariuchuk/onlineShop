package onlineShop.myBatis;

import onlineShop.dao.idbcMySQLImpl.ipeople.ICustomersCategoriesDAO;
import onlineShop.models.people.Customers;
import onlineShop.models.people.CustomersCategories;
import org.apache.ibatis.session.SqlSession;

import java.util.LinkedList;
import java.util.List;

public class CustomersCategoriesMyBatis implements ICustomersCategoriesDAO {
    @Override
    public CustomersCategories getById(int id) {
        return null;
    }

    @Override
    public List<CustomersCategories> getAll() {
        List<CustomersCategories> customersCategories = new LinkedList<>();
        SqlSession sqlSession = MyBatisConnection.getSqlSessionFactory().openSession();
        customersCategories = sqlSession.selectList("src.main.resources.mappers.CustomersCategoriesMapper.getAll", customersCategories);
        sqlSession.close();
        return customersCategories;
    }

    @Override
    public void add(CustomersCategories customersCategories) {

    }

    @Override
    public void update(CustomersCategories customersCategories) {

    }

    @Override
    public void delete(int id) {

    }
}
