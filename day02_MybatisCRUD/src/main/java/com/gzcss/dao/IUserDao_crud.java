package com.gzcss.dao;

import com.gzcss.domain.User_crud;

import java.util.List;

/*
*   用户持久层接口
* */
public interface IUserDao_crud {

    /*
        查询所有用户
    * */
    List<User_crud> findAll();


    /*
    *   保存用户
    * */
    void saveUser(User_crud user);

    /*
    *   更新用户
    * */
    void updateUser(User_crud user);

    /*
    *  根据ID删除用户
    * */
    void deleteUser(Integer id);

    /*
    *   根据ID查找一个用户
    * */
    User_crud findOne(Integer id);

    /*
    *   模糊查询
    * */
    List<User_crud> findByName(String name);


}
