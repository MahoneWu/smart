package org.mouse.framework.helper;

import org.mouse.framework.annotation.Controller;
import org.mouse.framework.annotation.Service;
import org.mouse.framework.util.ClassUtil;

import java.lang.annotation.Annotation;
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
     * 获取应用包下有关Service注解的类
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

    /**
     * 获取所有的controller注解
     * @return
     */
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


    /**
     * 获取某类的所有子类
     * @param superClass
     * @return
     */
    public static Set<Class<?>> getClassSetBySuper(Class<?> superClass) {
        Set<Class<?>> classSet = new HashSet<Class<?>>();
        for(Class<?> cls : CLASS_SET){
            if(superClass.isAssignableFrom(cls)&&!superClass.equals(superClass)){
                classSet.add(cls);
            }
        }
        return classSet;
    }

    /**
     * 根据注解获取相关注解的类
     * @param annotation
     * @return
     */
    public static Set<Class<?>> getClassSetByAnnotation(Class<? extends Annotation> annotation){
        Set<Class<?>> classSet = new HashSet<Class<?>>();
        for(Class<?> clz : CLASS_SET){
            if(clz.isAnnotationPresent(annotation)){
                classSet.add(clz);
            }
        }
        return classSet;
    }




}
