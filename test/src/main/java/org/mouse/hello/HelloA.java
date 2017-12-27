package org.mouse.hello;

import org.mouse.java.Test;

/**
 * Created by Mahone Wu on 2017/12/27.
 */
public class HelloA extends Test {

    public static void main(String[] args) {
        Test test = new Test();
        test.printPublic();
        HelloA a = new HelloA();
        a.printProtected();

        char ss = '中';


    }
}
