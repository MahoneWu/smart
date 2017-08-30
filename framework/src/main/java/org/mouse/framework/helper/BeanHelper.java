package org.mouse.framework.helper;

import org.mouse.framework.util.ReflectionUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by Mahone on 2017/8/30.
 */
public class BeanHelper {

    private static final Map<Class<?>, Object> BEAN_MAP = new HashMap<Class<?>, Object>();


    static {
        Set<Class<?>> beanClassSet = ClassHelper.getBeanClassSet();
        for(Class<?> beanClass : beanClassSet){
            Object obj = ReflectionUtil.newInstance(beanClass);
            BEAN_MAP.put(beanClass, obj);
        }
    }


    public static  Map<Class<?> ,Object> getBeanMap(){
        return BEAN_MAP;
    }


    public static <T> T getBean(Class<T> clz){
        if(!BEAN_MAP.containsKey(clz)){
            throw new RuntimeException("can not get bean by class : " + clz);
        }
        return (T) BEAN_MAP.get(clz);
    }



}
