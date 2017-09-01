package org.mouse.test.cglibproxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by Mahone Wu on 2017/9/1.
 */
public class CGLlibProxy implements MethodInterceptor {


    private static CGLlibProxy cgLlibProxy = new CGLlibProxy();

    private CGLlibProxy(){

    }

    public static  CGLlibProxy getInstance(){
        return cgLlibProxy;
    }


    public <T> T getProxy(Class<T> clz){
        return (T) Enhancer.create(clz, this);
    }


    public Object intercept(Object obj, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        before();
        Object result = methodProxy.invokeSuper(obj, args);
        after();
        return result;
    }

    private void after() {
        System.out.println("after");
    }

    private void before() {
        System.out.println("before");
    }


}
