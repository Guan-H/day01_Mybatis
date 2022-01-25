package com.gzcss.mybatis.sqlsession;

import com.gzcss.cfg.Configuration;
import com.gzcss.mybatis.sqlsession.defaults.DefaultSqlSessionFactory;
import com.gzcss.mybatis.utils.XMLConfigBuilder;

import java.io.InputStream;

public class
SqlSessionFactoryBuilder {

    /** * 根据传入的流，实现对SqlSessionFactory的创建
     * @param config 它就是SqlMapConfig.xml的配置以及里面包含的IUserDao.xml的配置
     * @return
     * */
    public static SqlSessionFactory build(InputStream config){
        Configuration cfg = XMLConfigBuilder.loadConfiguration(config);
        return new DefaultSqlSessionFactory(cfg);
    }
}


