package org.mouse.test.springaspectj;

import org.mouse.test.springaop.Greet;
import org.springframework.stereotype.Component;

/**
 * Created by Mahone Wu on 2017/9/1.
 */
@Component(value = "greetingAspectj")
public class GreetingImpl implements Greet {

    @Tag
    public void say(String name) {
        System.out.println("Hello " + name);
        //throw new RuntimeException("error");
    }

    public void goodMorning(String name) {
        System.out.println("Good Morning " +name);
    }

    public void goodNight(String name) {
        System.out.println("Good night " +name);
    }
}
