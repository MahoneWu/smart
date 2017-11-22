package org.mouse.spring.advice;

import org.mouse.spring.two.HelloService;
import org.mouse.spring.two.HelloServiceImpl;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Mahone Wu on 2017/11/16.
 */
public class MainAdviceTest {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("conf/two/two.xml");
        HelloService helloService = context.getBean("proxyService",HelloService.class);
        //helloService.getName(1);

        //织入对象
        ProxyFactory proxyFactory = new ProxyFactory(new HelloServiceImpl());
        proxyFactory.setInterfaces(new Class[]{HelloService.class});
        //应用到目标对象的Aspect(spring中叫advisor)
        proxyFactory.addAdvice(new DiscountMethodInterceptor());
        HelloService proxyObject = (HelloService)proxyFactory.getProxy();
        System.out.println(proxyObject.getName(1237889));
        System.out.println("---------->"+proxyFactory.getProxy());
        System.out.println("=====>"+HelloService.class.cast(proxyFactory.getProxy()));

    }

}
