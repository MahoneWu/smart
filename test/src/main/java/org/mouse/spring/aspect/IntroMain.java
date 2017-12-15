package org.mouse.spring.aspect;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Mahone Wu on 2017/12/14.
 */
public class IntroMain {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("conf/aspect/aspect.xml");
        Object task = ctx.getBean("task");
        System.out.println(((ICounter)task).count());
    }
}
