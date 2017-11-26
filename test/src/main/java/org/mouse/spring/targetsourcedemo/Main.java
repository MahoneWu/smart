package org.mouse.spring.targetsourcedemo;

import org.springframework.aop.framework.Advised;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Mahone Wu on 2017/11/23.
 */
public class Main {


    public static void main(String[] args) throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("conf/targetsourcedemo/targetsourcedemo.xml");
        Object targetProxy = context.getBean("targetProxy");

        Object targetObject0 = ((Advised) targetProxy).getTargetSource().getTarget();
        Object targetObject1 = ((Advised) targetProxy).getTargetSource().getTarget();
        Object targetObject2 = ((Advised) targetProxy).getTargetSource().getTarget();
        System.out.println(targetObject0);
        System.out.println(targetObject1);
        System.out.println(targetObject2);



    }

}
