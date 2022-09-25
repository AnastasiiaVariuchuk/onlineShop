package onlineShop.myBatis;


import onlineShop.dao.idbcMySQLImpl.iproducts.IManufacturersDAO;
import onlineShop.models.people.Users;
import onlineShop.models.products.Manufacturers;
import org.apache.ibatis.session.SqlSession;

import java.util.LinkedList;
import java.util.List;

public class ManufacturersMyBatis implements IManufacturersDAO {
    @Override
    public Manufacturers getById(int id) {
        SqlSession sqlSession = MyBatisConnection.getSqlSessionFactory().openSession();
        Manufacturers manufacturers = sqlSession.selectOne("src.main.resources.myMappers.ManufacturersMapper.getBuId", id);
        sqlSession.close();
        return manufacturers;
    }

    @Override
    public List<Manufacturers> getAll() {
        List<Manufacturers> manufacturers= new LinkedList<>();
        SqlSession sqlSession = MyBatisConnection.getSqlSessionFactory().openSession();
        manufacturers = sqlSession.selectList("src.main.resources.myMappers.manufacturersMapper.getAll");
        sqlSession.close();
        return manufacturers;
    }

    @Override
    public void add(Manufacturers manufacturers) {
        SqlSession sqlSession = MyBatisConnection.getSqlSessionFactory().openSession();
        sqlSession.insert("src.main.resources.myMappers.UsersMapper.add", manufacturers);
        sqlSession.commit();sqlSession.close();
    }

    @Override
    public void update(Manufacturers manufacturers) {
        SqlSession sqlSession = MyBatisConnection.getSqlSessionFactory().openSession();
        sqlSession.update("src.main.resources.myMappers.ManufacturersMapper.update", manufacturers.getIdManufacturer());
        sqlSession.commit();sqlSession.close();
    }

    @Override
    public void delete(int id) {
        SqlSession sqlSession = MyBatisConnection.getSqlSessionFactory().openSession();
        sqlSession.delete("src.main.resources.myMappers.ManufacturersMapper.delete", id);
        sqlSession.commit();sqlSession.close();
    }
}
