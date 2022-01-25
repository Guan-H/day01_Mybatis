package com.gzcss.mybatis.sqlsession.defaults;

import com.gzcss.cfg.Configuration;
import com.gzcss.mybatis.sqlsession.SqlSession;
import com.gzcss.mybatis.sqlsession.SqlSessionFactory;
/*
*   SqlSessionFactory接口的实现类
* */
public class DefaultSqlSessionFactory implements SqlSessionFactory {

    private Configuration cfg;

    public DefaultSqlSessionFactory(Configuration cfg){
        this.cfg = cfg;
    }

    /*
    *   用于创建一个新的操作数据库对象
    * */
    @Override
    public SqlSession openSession() {
        return new DefaultSqlSession(cfg);
    }
}
