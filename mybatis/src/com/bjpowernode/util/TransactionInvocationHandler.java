package com.bjpowernode.util;

import org.apache.ibatis.session.SqlSession;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class TransactionInvocationHandler implements InvocationHandler {
   private  Object target;
   public  TransactionInvocationHandler(Object target){
       this.target=target;
   }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        SqlSession session=null;
        Object object=null;
      try {
          session = SqlSessionUtil.getSession();
          object = method.invoke(target, args);
          session.commit();
      }catch (Exception e){
          session.rollback();
      }
       return object;
    }
    //取得ls对象
    public  Object getProxy(){
       return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
    }
}
