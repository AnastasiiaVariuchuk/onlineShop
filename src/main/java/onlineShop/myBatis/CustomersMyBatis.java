package onlineShop.myBatis;

import onlineShop.dao.idbcMySQLImpl.ipeople.ICustomersDAO;
import onlineShop.models.people.Customers;
import onlineShop.models.products.Manufacturers;
import org.apache.ibatis.session.SqlSession;

import java.util.LinkedList;
import java.util.List;

public class CustomersMyBatis implements ICustomersDAO {
    @Override
    public Customers getById(int id) {
        SqlSession sqlSession = MyBatisConnection.getSqlSessionFactory().openSession();
        Customers customers = sqlSession.selectOne("src.main.resources.mappers.CustomersMapper.getBuId", id);
        sqlSession.close();
        return customers;
    }

    @Override
    public List<Customers> getAll() {
        List<Customers> customers = new LinkedList<>();
        SqlSession sqlSession = MyBatisConnection.getSqlSessionFactory().openSession();
        customers = sqlSession.selectList("src.main.resources.mappers.CustomersMapper.getAll", customers);
        sqlSession.close();
        return customers;
    }

    @Override
    public void add(Customers customers) {
        SqlSession sqlSession = MyBatisConnection.getSqlSessionFactory().openSession();
        sqlSession.insert("src.main.resources.mappers.CustomersMapper.add", customers);
        sqlSession.commit();sqlSession.close();
    }

    @Override
    public void update(Customers customers) {
        SqlSession sqlSession = MyBatisConnection.getSqlSessionFactory().openSession();
        sqlSession.update("src.main.resources.mappers.CustomersMapper.update", customers.getIdCustomer());
        sqlSession.commit();sqlSession.close();
    }

    @Override
    public void delete(int id) {
        SqlSession sqlSession = MyBatisConnection.getSqlSessionFactory().openSession();
        sqlSession.delete("src.main.resources.mappers.CustomersMapper.delete", id);
        sqlSession.commit();sqlSession.close();
    }
}
