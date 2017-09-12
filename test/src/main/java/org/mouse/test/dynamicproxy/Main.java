package org.mouse.test.dynamicproxy;

import org.mouse.test.staticproxy.Hello;
import org.mouse.test.staticproxy.HelloImpl;

/**
 * Created by Mahone Wu on 2017/9/1.
 */
public class Main {

    public static void main(String[] args) {
        Hello hello = new HelloImpl();

        /*DynamicProxy dynamicProxy = new DynamicProxy();*/
        DynamicProxy dynamicProxy = new DynamicProxy(hello);

        /*Hello helloProxy = (Hello)Proxy.newProxyInstance(hello.getClass().getClassLoader(), hello.getClass().getInterfaces(), dynamicProxy);
        helloProxy.say("mahone");*/
        Hello helloProxy = dynamicProxy.getProxy();
        helloProxy.say("Mahone");

    }
}
