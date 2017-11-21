package org.mouse.spring.proxyfactorydemo;

import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.NameMatchMethodPointcutAdvisor;

/**
 * Created by Mahone Wu on 2017/11/20.
 */
public class CgMain {

    public static void main(String[] args) {
        ProxyFactory proxyFactory = new ProxyFactory(new Executable());
        //proxyFactory.setProxyTargetClass(true);
        NameMatchMethodPointcutAdvisor advisor = new NameMatchMethodPointcutAdvisor();
        advisor.setMappedName("execute");
        advisor.setAdvice(new HelloMethodInterceptor());
        proxyFactory.addAdvisor(advisor);
        Executable proxyObject = (Executable)proxyFactory.getProxy();
        proxyObject.execute();
        System.out.println(proxyObject.getClass());
    }

}
