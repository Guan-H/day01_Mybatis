package com.gzcss.Dao;

import com.gzcss.domain.User;
//import org.apache.ibatis.annotations.Select;

import java.util.List;


/*
*   用户持久层操作
* */
public interface IUserDao {

    /*
        查询所有用户
    * */
    /*@Select("select * from user")*/
    List<User> findAll();

}
