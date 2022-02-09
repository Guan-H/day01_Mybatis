package com.gzcss.test;

import com.gzcss.dao.IUserDao_crud;
import com.gzcss.domain.QueryVo;
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
        //执行完后，提交事务
        sqlSession.commit();
        //释放资源
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
        save_user.setUserName("大石页");
        save_user.setUserBirthday(new Date());
        save_user.setUserSex("猫");
        save_user.setUserAddress("地球");
        System.out.println("保存之前操作："+save_user);
        user.saveUser(save_user);
        System.out.println("保存之后操作："+save_user);
    }

    /*
     *   更新用户
     * */
    @Test
    public void updateUser(){
        User_crud save_user = new User_crud();
        save_user.setUserId(59);
        save_user.setUserName("小石页");
        save_user.setUserBirthday(new Date());
        save_user.setUserSex("猫");
        save_user.setUserAddress("猫星");
        user.updateUser(save_user);
        //提交事务
    }

    /*
    *   根据ID删除用户
    * */
    @Test
    public void deleteUser(){
        user.deleteUser(60);
    }

    /*
     *   根据ID查找一个用户
     * */
    @Test
    public void findOne(){
        User_crud one = user.findOne(59);
        System.out.println(one);
    }

    /*
    *   模糊查询
    * */
    @Test
    public void findByName(){
        List<User_crud> byName = user.findByName("%王%");
        //第二种模糊查询的方式，传参时不需要加 %% 符号
        //List<User_crud> byName = user.findByName("王");
        for (User_crud user : byName) {
            System.out.println(user);
        }
    }

    /*
     *   查询总记录数
     * */
    @Test
    public void findTotal(){
        int count = user.findTotal();
        System.out.println("总记录数："+count);
    }

    /*
    *   测试使用QueryVo作为查询条件
    * */
    @Test
    public void findByVo(){
        QueryVo vo = new QueryVo();
        User_crud user_crud = new User_crud();
        user_crud.setUserName("%王%");
        vo.setUser(user_crud);
        List<User_crud> byVo = user.findByVo(vo);
        for (User_crud userCruds:byVo){
            System.out.println(byVo);
        }


    }
}
