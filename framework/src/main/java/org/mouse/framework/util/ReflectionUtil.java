package org.mouse.framework.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by Mahone on 2017/8/30.
 */
public class ReflectionUtil {


    private static final Logger logger = LoggerFactory.getLogger(ReflectionUtil.class);

    /**
     * 创建实例
     * @param clz
     * @return
     */
    public static Object newInstance(Class<?> clz){
        Object instance = null;
        try {
            instance = clz.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return instance;
    }


    /**
     * 反射调用方法
     * @param obj
     * @param method
     * @param args
     * @return
     */
    public static  Object invokeMethod(Object obj, Method method,Object... args){
        Object result = null;
        try {
            method.setAccessible(true);
            result = method.invoke(obj, args);
        }catch (Exception e){
            logger.error("{}",e);
            throw new RuntimeException(e);
        }
        return result;
    }


    /**
     * 设置数据
     * @param object
     * @param field
     * @param value
     */
    public static void setField(Object object, Field field, Object value) {
        try {
            field.setAccessible(true);
            field.set(object,value);
        }catch (Exception e){
            logger.error("{}",e);
            throw new RuntimeException(e);
        }
    }


}
