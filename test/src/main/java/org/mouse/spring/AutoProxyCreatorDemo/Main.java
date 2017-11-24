package org.mouse.spring.AutoProxyCreatorDemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Mahone Wu on 2017/11/22.
 */
public class Main {

    public static void main(String[] args) {
//        ApplicationContext context = new ClassPathXmlApplicationContext("conf/proxycreatordemo/proxycreator.xml");
//        UserService userService = (UserService)context.getBean("userService");
//        userService.print();
        String test = "user*Service";
        System.out.println(test.indexOf(42));

    }
}
