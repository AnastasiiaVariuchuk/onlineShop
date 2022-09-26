package onlineShop.dao.myBatis;


import onlineShop.dao.idbcMySQLImpl.iproducts.IManufacturersDAO;
import onlineShop.models.products.Manufacturers;
import org.apache.ibatis.session.SqlSession;

import java.util.LinkedList;
import java.util.List;

public class ManufacturersMyBatis implements IManufacturersDAO {
    @Override
    public Manufacturers getById(int id) {
        SqlSession sqlSession = MyBatisConnection.getSqlSessionFactory().openSession();
        Manufacturers manufacturers = sqlSession.selectOne("src.main.resources.mappers.ManufacturersMapper.getById", id);
        sqlSession.close();
        return manufacturers;
    }

    @Override
    public List<Manufacturers> getAll() {
        List<Manufacturers> manufacturers= new LinkedList<>();
        SqlSession sqlSession = MyBatisConnection.getSqlSessionFactory().openSession();
        manufacturers = sqlSession.selectList("src.main.resources.mappers.ManufacturersMapper.getAll");
        sqlSession.close();
        return manufacturers;
    }

    @Override
    public void add(Manufacturers manufacturers) {
        SqlSession sqlSession = MyBatisConnection.getSqlSessionFactory().openSession();
        sqlSession.insert("src.main.resources.mappers.ManufacturersMapper.add", manufacturers);
        sqlSession.commit();sqlSession.close();
    }

    @Override
    public void update(Manufacturers manufacturers) {
        SqlSession sqlSession = MyBatisConnection.getSqlSessionFactory().openSession();
        sqlSession.update("src.main.resources.mappers.ManufacturersMapper.update", manufacturers);
        sqlSession.commit();sqlSession.close();
    }

    @Override
    public void delete(int id) {
        SqlSession sqlSession = MyBatisConnection.getSqlSessionFactory().openSession();
        sqlSession.delete("src.main.resources.mappers.ManufacturersMapper.delete", id);
        sqlSession.commit();sqlSession.close();
    }
}
