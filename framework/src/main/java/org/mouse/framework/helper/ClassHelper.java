package org.mouse.framework.helper;

import org.mouse.framework.annotation.Controller;
import org.mouse.framework.annotation.Service;
import org.mouse.framework.util.ClassUtil;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Mahone on 2017/8/30.
 */
public  final class ClassHelper {

    private static final Set<Class<?>> CLASS_SET;

    static {
        String basePackage = ConfigHelper.getAppBasePackage();
        CLASS_SET = ClassUtil.getClassSet(basePackage);
    }


    /**
     * 获取应用包下所有类
     * @return
     */
    public static Set<Class<?>> getClassSet(){
        return CLASS_SET;
    }


    /**
     * 获取应用包下所有类
     * @return
     */
    public static Set<Class<?>> getServiceClass(){
        Set<Class<?>> classSet = new HashSet<Class<?>>();
        for(Class<?> clz : CLASS_SET){
            if(clz.isAnnotationPresent(Service.class)){//判断注解
                classSet.add(clz);
            }
        }
        return classSet;
    }

    public static Set<Class<?>> getControllerClass(){
        Set<Class<?>> classSet = new HashSet<Class<?>>();
        for(Class<?> clz : CLASS_SET){
            if(clz.isAnnotationPresent(Controller.class)){//判断注解
                classSet.add(clz);
            }
        }
        return classSet;
    }

    /**
     *
     * @return
     */
    public static  Set<Class<?>> getBeanClassSet(){
        Set<Class<?>> beanClassSet = new HashSet<Class<?>>();
        beanClassSet.addAll(getServiceClass());
        beanClassSet.addAll(getControllerClass());
        return beanClassSet;
    }

}
