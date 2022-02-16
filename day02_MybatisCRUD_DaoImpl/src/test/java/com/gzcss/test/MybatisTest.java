package com.gzcss.test;


import com.gzcss.Impl.IUserdao_daoImpl;
import com.gzcss.dao.IUserDao_dao;
import com.gzcss.domain.QueryVo_daoImpl;
import com.gzcss.domain.User_daoImpl;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MybatisTest {

    private InputStream in;
    private IUserDao_dao user;

    @Before //  @Before：该注解用于在测试方法(@Test)执行之前
    public void init() throws IOException {
        //1、读取配置文件
         in = Resources.getResourceAsStream("SqlMapConfigs_daoImpl.xml");
        //2、获取SqlSessionFactory
        /*
           SqlSessionFactoryBuilder Builder = new SqlSessionFactoryBuilder();
           SqlSessionFactory sqlSessionFactory = Builder.build(in);
         */
         SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);

        //4、获取dao的代理对象
         user = new IUserdao_daoImpl(sqlSessionFactory);

    }

    @After //  @After :该注解用于在测试方法(@Test)运行之后执行
    public void destroy() throws IOException {
        //释放资源
        in.close();
    }


    /*
    * 测试查询所有
    * */
    @Test
    public void testFindAll() throws IOException {
        
        List<User_daoImpl> list_Users = user.findAll();
        for(User_daoImpl user_daoImpl : list_Users ){
            System.out.println(user_daoImpl);
        }

    }

    /*
     *   保存用户
     * */
    @Test
    public void saveUser(){
        User_daoImpl save_user = new User_daoImpl();
        save_user.setUsername("超大石页");
        save_user.setBirthday(new Date());
        save_user.setSex("猫");
        save_user.setAddress("地球");
        System.out.println("保存之前操作："+save_user);
        user.saveUser(save_user);
        System.out.println("保存之后操作："+save_user);
    }

    /*
     *   更新用户
     * */
    @Test
    public void updateUser(){
        User_daoImpl save_user = new User_daoImpl();
        save_user.setId(62);
        save_user.setUsername("超小石页");
        save_user.setBirthday(new Date());
        save_user.setSex("猫");
        save_user.setAddress("猫星");
        user.updateUser(save_user);
    }

    /*
     *   根据ID删除用户
     * */
    @Test
    public void deleteUser(){
        user.deleteUser(58);
    }

    /*
     *   根据ID查找一个用户
     * */
    @Test
    public void findOne(){
        User_daoImpl one = user.findOne(59);
        System.out.println(one);
    }

    /*
     *   模糊查询
     * */
    @Test
    public void findByName(){
        List<User_daoImpl> byName = user.findByName("%王%");
        //第二种模糊查询的方式，传参时不需要加 %% 符号
        //List<User_crud> byName = user.findByName("王");
        for (User_daoImpl user : byName) {
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


    @Test
    public void findUserByCondtion(){
        User_daoImpl users =new User_daoImpl();
        users.setUsername("%王%");
        users.setSex("男");
        List<User_daoImpl> userByCondtion = user.findUserByCondtion(users);
        for (User_daoImpl li:userByCondtion) {
            System.out.println(li);
        }
    }

    @Test
    public void findUserids(){
        QueryVo_daoImpl ov = new QueryVo_daoImpl();
        List<Integer> list = new ArrayList<Integer>();
        list.add(41);
        list.add(42);
        list.add(46);
        ov.setIds(list);
        List<User_daoImpl> userids = user.findUserids(ov);
        for (User_daoImpl li:userids) {
            System.out.println(li);
        }

    }

}
