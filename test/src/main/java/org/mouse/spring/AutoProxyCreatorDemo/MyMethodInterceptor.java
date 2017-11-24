package org.mouse.spring.AutoProxyCreatorDemo;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * Created by Mahone Wu on 2017/11/22.
 */
public class MyMethodInterceptor implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        System.out.println(getClass() +"调用方法前");
        Object object = invocation.proceed();
        System.out.println(getClass()+"调用方法后");
        return object;
    }
}
