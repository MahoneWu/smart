package org.mouse.thread.callable;

import java.util.concurrent.Callable;

/**
 * Created by Mahone Wu on 2017/9/12.
 */
public class MyCallable implements Callable {


    public Integer call() throws Exception {
        int sum = 0;
        for (int i = 0; i < 100; i++) {
            sum += i;
        }
        return Integer.valueOf(sum);
    }

}
