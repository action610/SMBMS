package com.smbms.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;

/**
 * description:
 * Created by Ray on 2020-04-10
 */
public class SqlSessionUtil {
    //获取SqlSessionFactory对象
    //单例模式，提前创建属于饿汉式
    //将SqlSessionFactory私有化，以便创建单例
    private static SqlSessionFactory sessionFactory;
    //静态块，工厂类只创建一次用静态块就OK,SqlSessionFactoryBuilder只一次用匿名类就可以了
    static{
        try {
            sessionFactory=new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //获取SqlSessionFactory对象
    public static SqlSessionFactory getSessionFactory(){
        return sessionFactory;
    }
    //获取SqlSession对象
    public static SqlSession getSession(){
        return sessionFactory.openSession();
    }
}