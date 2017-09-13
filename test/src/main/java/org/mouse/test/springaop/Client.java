package org.mouse.test.springaop;

import org.mouse.test.staticproxy.Hello;
import org.springframework.aop.framework.ProxyFactory;

/**
 * Created by Mahone Wu on 2017/9/13.
 */
public class Client {

    public static void main(String[] args) {
        ProxyFactory proxyFactory = new ProxyFactory();

        proxyFactory.setTarget(new GreetingImpl());
        proxyFactory.addAdvice(new GreetingBeforeAdvice());
        proxyFactory.addAdvice(new GreetingAfterAdvice());
        proxyFactory.addAdvice(new GreetingThrowAdvice());
        Hello hello = (Hello) proxyFactory.getProxy();
        hello.say("mahone");
    }

}
