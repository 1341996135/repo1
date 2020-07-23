package com.bjpowernode.util;

public class ServiceFactory {
    //传递zs，返回ls
    public static  Object getService(Object service){
        return  new TransactionInvocationHandler(service).getProxy();
    }
}
