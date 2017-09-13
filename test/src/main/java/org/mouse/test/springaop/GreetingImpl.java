package org.mouse.test.springaop;

import org.springframework.stereotype.Component;

/**
 * Created by Mahone Wu on 2017/9/1.
 */
@Component
public class GreetingImpl implements Greet {

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
