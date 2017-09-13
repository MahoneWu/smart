package org.mouse.test.springaop;

import javafx.application.Application;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Mahone Wu on 2017/9/13.
 */
public class Client2 {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

        GreetingImpl greetingImpl = (GreetingImpl)context.getBean("greetingProxy");
        greetingImpl.say("mahone");

        Apology apology = (Apology)greetingImpl;
        apology.saySorry("mahone");

    }
}
