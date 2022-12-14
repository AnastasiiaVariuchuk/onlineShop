package onlineShop.dao.myBatis;

import onlineShop.dao.idbcMySQLImpl.ipeople.ICustomersCategoriesDAO;
import onlineShop.models.people.CustomersCategories;
import org.apache.ibatis.session.SqlSession;

import java.util.LinkedList;
import java.util.List;

public class CustomersCategoriesMyBatis implements ICustomersCategoriesDAO {
    @Override
    public CustomersCategories getById(int id) {
        SqlSession sqlSession = MyBatisConnection.getSqlSessionFactory().openSession();
        CustomersCategories customersCategories = sqlSession.selectOne("src.main.resources.mappers.CustomersCategoriesMapper.getById", id);
        sqlSession.close();
        return customersCategories;
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
        SqlSession sqlSession = MyBatisConnection.getSqlSessionFactory().openSession();
        sqlSession.insert("src.main.resources.mappers.CustomersCategoriesMapper.add", customersCategories);
        sqlSession.commit();sqlSession.close();
    }

    @Override
    public void update(CustomersCategories customersCategories) {
        SqlSession sqlSession = MyBatisConnection.getSqlSessionFactory().openSession();
        sqlSession.update("src.main.resources.mappers.CustomersCategoriesMapper.update", customersCategories);
        sqlSession.commit();sqlSession.close();
    }

    @Override
    public void delete(int id) {
        SqlSession sqlSession = MyBatisConnection.getSqlSessionFactory().openSession();
        sqlSession.delete("src.main.resources.mappers.CustomersCategoriesMapper.delete", id);
        sqlSession.commit();sqlSession.close();
    }
}
