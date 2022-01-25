package com.gzcss.mybatis.sqlsession.defaults;

import com.gzcss.cfg.Configuration;
import com.gzcss.mybatis.sqlsession.SqlSession;
import com.gzcss.mybatis.sqlsession.proxy.MapperProxy;

import java.lang.reflect.Proxy;

public class DefaultSqlSession implements SqlSession {

    private Configuration cfg;

    public DefaultSqlSession(Configuration cfg){
        this.cfg = cfg;
    }

    /*
    * 创建代理对象
    * */
    @Override
    public <T> T getMapper(Class<T> daoInterfaceClass) {
        Proxy.newProxyInstance(daoInterfaceClass.getClassLoader(),new Class[]{daoInterfaceClass},new MapperProxy(cfg.getMappers()));
         return null;
    }
    /*
    *   释放资源
    * */
    @Override
    public void close() {

    }
}
