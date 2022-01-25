package com.gzcss.mybatis.sqlsession;

public interface SqlSession {

    /** * 创建Dao接口的代理对象
     * 根据参数创建一个代理对象
     * @param daoClass
     * @return
     * 自定义Mybatis中与数据库交互的核心类
     * 他里面可以创建Dao的接口对象
     * */
   <T> T getMapper(Class<T> daoClass);

    /** *
     * 释放资源
     * */
   void close();

}
