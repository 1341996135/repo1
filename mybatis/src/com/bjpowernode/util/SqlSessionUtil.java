package com.bjpowernode.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class SqlSessionUtil {
    private  static  SqlSessionFactory sessionFactory;
    static {
        String resource="mybatis.xml";
        InputStream inputStream=null;
        try {
            inputStream= Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
      sessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
    }
    private  static ThreadLocal<SqlSession> t=new ThreadLocal<>();
    public static  SqlSession getSession(){
        SqlSession session=t.get();
        if (session==null){
            session=sessionFactory.openSession();
            t.set(session);
        }
        return session;
    }
    public  static  void myClose(SqlSession sqlSession){
        if (sqlSession!=null){
            sqlSession.close();
        }
        t.remove();
    }
}
