package com.gzcss.mybatis.sqlsession;

public interface SqlSessionFactory {

    /** *
     * 创建一个新的SqlSession对象
     * @return */
   SqlSession openSession() ;

}
