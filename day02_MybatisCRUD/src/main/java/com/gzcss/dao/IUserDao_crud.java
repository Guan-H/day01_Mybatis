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
}
