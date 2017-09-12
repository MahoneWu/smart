package org.mouse.thread.callable;

import java.util.concurrent.*;

/**
 * Created by Mahone Wu on 2017/9/12.
 */
public class CallableTest1 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService pool = Executors.newSingleThreadExecutor();


        Callable callable = new MyCallable();

        Future f1 = pool.submit(callable);

        System.out.println(f1.get());

        pool.shutdown();

    }

}
