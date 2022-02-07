package com.gzcss.mybatis.utils;

import com.gzcss.cfg.Configuration;
import jdk.nashorn.internal.runtime.ECMAException;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataSourceUtil {
    /*
    *   用于获取一个connection连接
    * */
    public static Connection getConnection(Configuration cfg){
        try {
            Class.forName(cfg.getDriver());
            return DriverManager.getConnection(cfg.getUrl(),cfg.getUsername(),cfg.getPassword());
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }


}
