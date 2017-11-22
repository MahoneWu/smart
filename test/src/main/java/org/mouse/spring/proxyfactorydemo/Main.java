package org.mouse.spring.proxyfactorydemo;

import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.NameMatchMethodPointcutAdvisor;

/**
 * Created by Mahone Wu on 2017/11/20.
 */
public class Main {

    public static void main(String[] args) {
        //织入对象
        /*HelloServiceImpl helloService = new HelloServiceImpl();
        ProxyFactory proxyFactory = new ProxyFactory(helloService);*/
        ProxyFactory proxyFactory = new ProxyFactory(new HelloServiceImpl());
        proxyFactory.setProxyTargetClass(true);
        proxyFactory.setInterfaces(new Class[]{HelloService.class});
        //切面
        NameMatchMethodPointcutAdvisor advisor = new NameMatchMethodPointcutAdvisor();
        advisor.setMappedName("execute");
        //增强
        advisor.setAdvice(new HelloMethodInterceptor());

        //应用到目标对象的Aspect(spring中叫advisor)
        proxyFactory.addAdvice(new HelloMethodInterceptor());
        proxyFactory.addAdvisor(advisor);
        HelloService proxyObject = (HelloService)proxyFactory.getProxy();
        System.out.println("class ==== "+proxyObject.getClass());
        System.out.println(proxyObject.execute(1237889));
        System.out.println("---------->"+proxyFactory.getProxy());
        System.out.println("=====>"+HelloService.class.cast(proxyFactory.getProxy()));
    }
}
