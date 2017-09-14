package org.mouse.test.staticproxy;

import jdk.internal.org.objectweb.asm.Handle;

/**
 * Created by Mahone Wu on 2017/9/1.
 */
public class HelloImpl implements Hello {

    public void say(String name) {
        System.out.println("Hello " + name);
    }

    public int count() {
        return 1;
    }
}
