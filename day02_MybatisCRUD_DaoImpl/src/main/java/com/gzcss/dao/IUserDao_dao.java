package com.gzcss.dao;

import com.gzcss.domain.QueryVo_daoImpl;
import com.gzcss.domain.User_daoImpl;

import java.util.List;

/*
*   用户持久层接口
* */
public interface IUserDao_dao {

    /*
        查询所有用户
    * */
    List<User_daoImpl> findAll();


    /*
    *   保存用户
    * */
    void saveUser(User_daoImpl user);

    /*
    *   更新用户
    * */
    void updateUser(User_daoImpl user);

    /*
    *  根据ID删除用户
    * */
    void deleteUser(Integer id);

    /*
    *   根据ID查找一个用户
    * */
    User_daoImpl findOne(Integer id);

    /*
    *   模糊查询
    * */
    List<User_daoImpl> findByName(String username);

    /*
    *   查找总记录条数
    * */
    int findTotal();

    List<User_daoImpl> findUserByCondtion(User_daoImpl user_dao);

}
