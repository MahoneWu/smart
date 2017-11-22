package org.mouse.spring.proxyfactorydemo;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * Created by Mahone Wu on 2017/11/20.
 */
public class HelloMethodInterceptor implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        System.out.println(invocation.getMethod().getName());
        Object result = invocation.proceed();
        return result;
    }
}
