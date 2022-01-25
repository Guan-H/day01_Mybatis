package com.gzcss.mybatis.sqlsession.defaults;

import com.gzcss.mybatis.sqlsession.SqlSession;

public class DefaultSqlSession implements SqlSession {
    @Override
    public <T> T getMapper(Class<T> daoClass) {
        return null;
    }

    @Override
    public void close() {

    }
}
