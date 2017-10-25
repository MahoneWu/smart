package org.mouse.spring.two;

import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * main
 *
 * @author wuhao Mahone Wu
 * @date 2017/10/26
 */
public class MainOne {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("conf/two/two.xml");
        HelloService helloService = context.getBean("helloService",HelloService.class);
        helloService.say("hello world!!!");

        ProxyFactoryBean factoryBean = context.getBean("&helloServiceBean", ProxyFactoryBean.class);
        HelloService hs = (HelloService) factoryBean.getObject();
        hs.say("yoyo!!!");
    }

}
