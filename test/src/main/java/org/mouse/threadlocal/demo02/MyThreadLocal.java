package org.mouse.threadlocal.demo02;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by wuhao on 2017/9/17.
 */
public class MyThreadLocal<T> {


    private Map<Thread, T> container = Collections.synchronizedMap(new HashMap<Thread, T>());


    public void set(T value){
        container.put(Thread.currentThread(), value);
    }

    //获取当前线程值
    public T get(){
        Thread thread = Thread.currentThread();
        T value = container.get(thread);
        if(null == value && !container.containsKey(thread)){
            value = initiaValue();
            container.put(thread, value);
        }
        return value;
    }

    //初始化数据
    protected   T initiaValue(){
        return null;
    }





}
