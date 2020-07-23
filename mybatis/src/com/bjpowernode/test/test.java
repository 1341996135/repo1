package com.bjpowernode.test;

import com.bjpowernode.domain.Student;
import com.bjpowernode.service.Impl.StudentServiceImpl;
import com.bjpowernode.service.StudentService;
import com.bjpowernode.util.ServiceFactory;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class test {
    public static void main(String[] args) {
        //此时ss为zs对象，没有提交事务的功能
        //StudentService ss=new StudentServiceImpl();
        //加载成为ls对象，自动提交事务
        StudentService ss= (StudentService) ServiceFactory.getService(new StudentServiceImpl());
        //Student s=new Student();
        //s.setId("A0003");
        //s.setName("ww");
        //s.setAge(33);
        //ss.save(s);
        ss.getById("A0001");
    }
}
