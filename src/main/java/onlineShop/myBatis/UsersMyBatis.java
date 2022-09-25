package onlineShop.myBatis;

import onlineShop.dao.idbcMySQL.people.UsersDAO;
import onlineShop.dao.idbcMySQLImpl.ipeople.IUsersDAO;
import onlineShop.models.people.Users;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.LinkedList;
import java.util.List;

public class UsersMyBatis implements IUsersDAO {
    @Override
    public Users getById(int id) {
        SqlSession sqlSession = MyBatisConnection.getSqlSessionFactory().openSession();
        Users users = sqlSession.selectOne("src.main.resources.myMappers.UsersMapper.getBuId", id);
        sqlSession.close();
        return users;
    }

    @Override
    public List<Users> getAll() {
        List<Users> users = new LinkedList<>();
        SqlSession sqlSession = MyBatisConnection.getSqlSessionFactory().openSession();
        users = sqlSession.selectList("src.main.resources.myMappers.UsersMapper.getAll");
        sqlSession.close();
        return users;
    }

    @Override
    public void add(Users users) {
        SqlSession sqlSession = MyBatisConnection.getSqlSessionFactory().openSession();
        sqlSession.insert("src.main.resources.myMappers.UsersMapper.add", users);
        sqlSession.commit();sqlSession.close();
    }

    @Override
    public void update(Users users) {
        SqlSession sqlSession = MyBatisConnection.getSqlSessionFactory().openSession();
        sqlSession.update("src.main.resources.myMappers.UsersMapper.update", users.getIdUser());
        sqlSession.commit();sqlSession.close();
    }

    @Override
    public void delete(int id) {
        SqlSession sqlSession = MyBatisConnection.getSqlSessionFactory().openSession();
        sqlSession.delete("src.main.resources.myMappers.UsersMapper.delete", id);
        sqlSession.commit();sqlSession.close();
    }
}
