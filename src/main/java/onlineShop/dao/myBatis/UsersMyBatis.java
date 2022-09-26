package onlineShop.dao.myBatis;

import onlineShop.dao.idbcMySQLImpl.ipeople.IUsersDAO;
import onlineShop.models.people.Users;
import org.apache.ibatis.session.SqlSession;

import java.util.LinkedList;
import java.util.List;

public class UsersMyBatis implements IUsersDAO {
    @Override
    public Users getById(int id) {
        SqlSession sqlSession = MyBatisConnection.getSqlSessionFactory().openSession();
        Users users = sqlSession.selectOne("src.main.resources.mappers.UsersMapper.getById", id);
        sqlSession.close();
        return users;
    }

    @Override
    public List<Users> getAll() {
        List<Users> users = new LinkedList<>();
        SqlSession sqlSession = MyBatisConnection.getSqlSessionFactory().openSession();
        users = sqlSession.selectList("src.main.resources.mappers.UsersMapper.getAll");
        sqlSession.close();
        return users;
    }

    @Override
    public void add(Users users) {
        SqlSession sqlSession = MyBatisConnection.getSqlSessionFactory().openSession();
        sqlSession.insert("src.main.resources.mappers.UsersMapper.add", users);
        sqlSession.commit();sqlSession.close();
    }

    @Override
    public void update(Users users) {
        SqlSession sqlSession = MyBatisConnection.getSqlSessionFactory().openSession();
        sqlSession.update("src.main.resources.mappers.UsersMapper.update", users);
        sqlSession.commit();sqlSession.close();
    }

    @Override
    public void delete(int id) {
        SqlSession sqlSession = MyBatisConnection.getSqlSessionFactory().openSession();
        sqlSession.delete("src.main.resources.mappers.UsersMapper.delete", id);
        sqlSession.commit();sqlSession.close();
    }
}
