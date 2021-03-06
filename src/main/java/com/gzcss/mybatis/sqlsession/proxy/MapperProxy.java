package com.gzcss.mybatis.sqlsession.proxy;

import com.gzcss.cfg.Mapper;
import com.gzcss.mybatis.utils.Executor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.util.Map;

public class MapperProxy implements InvocationHandler {
    //map的key是全限定类名+方法名
    private Map<String, Mapper> mappers;

    private Connection conn;


    public MapperProxy(Map<String,Mapper> mappers,Connection conn){
        this.mappers = mappers;
        this.conn = conn;
    }


    /*
    *   对方法执行增强
    * */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //1、获取方法名
        String methodName = method.getName();
        //2、获取方法所在类的名字
        String className = method.getDeclaringClass().getName();
        //3、组合key
        String key = className + "."+methodName;
        //4、获取mappers中的mapper对象
        Mapper mapper = mappers.get(key);
        //5、判断是否有mapper
        if(mapper == null){
            throw new IllegalArgumentException("传入的参数有误");
        }
        //6、调用工具类查询所有



        System.out.println("获取需要增强方法的名字："+methodName);
        System.out.println("获取方法所在类的名字："+className);
        System.out.println("组成的key："+key);


        return new Executor().selectList(mapper,conn);
    }
}
