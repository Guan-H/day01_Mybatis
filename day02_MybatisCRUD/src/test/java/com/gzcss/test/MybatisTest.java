package com.gzcss.test;

import com.gzcss.dao.IUserDao_crud;
import com.gzcss.domain.User_crud;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class MybatisTest {

    private InputStream in;
    private SqlSessionFactory sqlSessionFactory;
    private SqlSession sqlSession;
    private IUserDao_crud user;


    @Before //  @Before：该注解用于在测试方法(@Test)执行之前
    public void init() throws IOException {
        //1、读取配置文件
         in = Resources.getResourceAsStream("SqlMapConfigs_crud.xml");
        //2、获取SqlSessionFactory
        /*
           SqlSessionFactoryBuilder Builder = new SqlSessionFactoryBuilder();
           SqlSessionFactory sqlSessionFactory = Builder.build(in);
         */
         sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);

        //3、获取SqlSession
         sqlSession = sqlSessionFactory.openSession();
        //4、获取dao的代理对象
         user = sqlSession.getMapper(IUserDao_crud.class);

    }

    @After //  @After :该注解用于在测试方法(@Test)运行之后执行
    public void destroy() throws IOException {
        sqlSession.close();
        in.close();
    }


    /*
    * 测试查询所有
    * */
    @Test
    public void testFindAll() throws IOException {
        List<User_crud> list_Users = user.findAll();
        for(User_crud user_crud: list_Users ){
            System.out.println(user_crud);
        }

    }



    /*
    *   保存用户
    * */
    @Test
    public void saveUser(){
        User_crud save_user = new User_crud();
        save_user.setUsername("飞上天");
        save_user.setBirthday(new Date());
        save_user.setSex("男");
        save_user.setAddress("地球");
        user.saveUser(save_user);
        //提交事务
        sqlSession.commit();
    }


}
