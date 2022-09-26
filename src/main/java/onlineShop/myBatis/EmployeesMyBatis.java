package onlineShop.myBatis;

import onlineShop.dao.idbcMySQLImpl.ipeople.IEmployeesDAO;
import onlineShop.models.people.Employees;
import org.apache.ibatis.session.SqlSession;

import java.util.LinkedList;
import java.util.List;

public class EmployeesMyBatis implements IEmployeesDAO {
    @Override
    public Employees getById(int id) {
        SqlSession sqlSession = MyBatisConnection.getSqlSessionFactory().openSession();
        Employees employees = sqlSession.selectOne("src.main.resources.mappers.EmployeesMapper.getById", id);
        sqlSession.close();
        return employees;
    }

    @Override
    public List<Employees> getAll() {
        List<Employees> employees = new LinkedList<>();
        SqlSession sqlSession = MyBatisConnection.getSqlSessionFactory().openSession();
        employees = sqlSession.selectList("src.main.resources.mappers.EmployeesMapper.getAll", employees);
        sqlSession.close();
        return employees;
    }

    @Override
    public void add(Employees employees) {
        SqlSession sqlSession = MyBatisConnection.getSqlSessionFactory().openSession();
        sqlSession.insert("src.main.resources.mappers.EmployeesMapper.add", employees);
        sqlSession.commit();sqlSession.close();
    }

    @Override
    public void update(Employees employees) {
        SqlSession sqlSession = MyBatisConnection.getSqlSessionFactory().openSession();
        sqlSession.update("src.main.resources.mappers.EmployeesMapper.update", employees);
        sqlSession.commit();sqlSession.close();
    }

    @Override
    public void delete(int id) {
        SqlSession sqlSession = MyBatisConnection.getSqlSessionFactory().openSession();
        sqlSession.delete("src.main.resources.mappers.EmployeesMapper.delete", id);
        sqlSession.commit();sqlSession.close();
    }
}
