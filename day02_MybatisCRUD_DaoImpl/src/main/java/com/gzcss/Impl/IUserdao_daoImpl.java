package com.gzcss.Impl;

import com.gzcss.dao.IUserDao_dao;
import com.gzcss.domain.QueryVo_daoImpl;
import com.gzcss.domain.User_daoImpl;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import java.util.List;

public class IUserdao_daoImpl implements IUserDao_dao {


    private SqlSessionFactory sqlSessionFactory;

    public IUserdao_daoImpl(SqlSessionFactory sessionFactory) {
        this.sqlSessionFactory = sessionFactory;
    }

    @Test
    @Override
    public List<User_daoImpl> findAll() {
        //获取sqlsession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //查询结构返回
        List<User_daoImpl> list = sqlSession.selectList("com.gzcss.dao.IUserDao_dao.findAll");
        //释放资源
        sqlSession.close();
        return list;
    }

    @Override
    public void saveUser(User_daoImpl user) {
        //根据sqlSessionFactory获取sqlsession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //调用方法实现保存
        sqlSession.insert("com.gzcss.dao.IUserDao_dao.saveUser", user);
        //提交事务
        sqlSession.commit();
        //释放资源
        sqlSession.close();

    }

    @Override
    public void updateUser(User_daoImpl user) {
        //根据sqlSessionFactory获取sqlsession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //调用方法实现update
        sqlSession.insert("com.gzcss.dao.IUserDao_dao.updateUser", user);
        //提交事务
        sqlSession.commit();
        //释放资源
        sqlSession.close();
    }

    @Override
    public void deleteUser(Integer id) {
        //根据sqlSessionFactory获取sqlsession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //调用方法实现删除
        sqlSession.delete("com.gzcss.dao.IUserDao_dao.deleteUser", id);

        //提交事务
        sqlSession.commit();
        //释放资源
        sqlSession.close();
    }

    @Override
    public User_daoImpl findOne(Integer id) {
        //根据sqlSessionFactory获取sqlsession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //调用方法实现查找
        User_daoImpl user = sqlSession.selectOne("com.gzcss.dao.IUserDao_dao.findOne", id);
        //释放资源
        sqlSession.close();
        return user;
    }

    @Override
    public List<User_daoImpl> findByName(String username) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<User_daoImpl> user_daoList = sqlSession.selectList("com.gzcss.dao.IUserDao_dao.findByName",username);
        sqlSession.close();
        return user_daoList;
    }

    @Override
    public int findTotal() {
        //根据sqlSessionFactory获取sqlsession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //调用方法实现查找
        Integer  count = sqlSession.selectOne("com.gzcss.dao.IUserDao_dao.findTotal");
        //释放资源
        sqlSession.close();
        return count;
    }

}
