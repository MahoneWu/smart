package org.mouse.test.springaspectj;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Mahone Wu on 2017/9/13.
 */
public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-aspectj.xml");

        org.mouse.test.springaspectj.GreetingImpl greetingImpl = (org.mouse.test.springaspectj.GreetingImpl)context.getBean("greetingAspectj");
        greetingImpl.say("mahone");

    }

}
