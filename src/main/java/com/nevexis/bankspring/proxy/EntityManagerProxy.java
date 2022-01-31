package com.nevexis.bankspring.proxy;

import javax.persistence.EntityManager;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class EntityManagerProxy implements InvocationHandler {

    EntityManager original;

    public EntityManagerProxy(EntityManager original) {
        this.original = original;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        if("find".equals(method.getName())){


            return null;
        }

        return method.invoke(original,args);
    }
}
