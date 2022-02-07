package com.gzcss.mybatis.sqlsession.defaults;

import com.gzcss.cfg.Configuration;
import com.gzcss.mybatis.sqlsession.SqlSession;
import com.gzcss.mybatis.sqlsession.proxy.MapperProxy;
import com.gzcss.mybatis.utils.DataSourceUtil;

import javax.sql.DataSource;
import java.lang.reflect.Proxy;
import java.sql.Connection;

public class DefaultSqlSession implements SqlSession {

    private Configuration cfg;

    private Connection connection;

    public DefaultSqlSession(Configuration cfg){
        this.cfg = cfg;
        connection = DataSourceUtil.getConnection(cfg);
    }

    /*
    * 创建代理对象
    * */
    @Override
    public <T> T getMapper(Class<T> daoInterfaceClass) {
        return (T) Proxy.newProxyInstance(daoInterfaceClass.getClassLoader(),
                new Class[]{daoInterfaceClass},new MapperProxy(cfg.getMappers(),connection));

    }
    /*
    *   释放资源
    * */
    @Override
    public void close() {
        if(connection != null){
            try {
                connection.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
