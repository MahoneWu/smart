package org.mouse.framework.helper;

import org.mouse.framework.annotation.Aspect;
import org.mouse.framework.annotation.Service;
import org.mouse.framework.annotation.Transaction;
import org.mouse.framework.proxy.AspectProxy;
import org.mouse.framework.proxy.Proxy;
import org.mouse.framework.proxy.ProxyManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.annotation.Annotation;
import java.util.*;

/**
 * Created by Mahone Wu on 2017/9/14.
 */
public class AopHelper {

    private static final Logger logger = LoggerFactory.getLogger(AopHelper.class);

 /*   static {
        try {
            Map<Class<?>, Set<Class<?>>>   proxyMap = createProxyMap();
            Map<Class<?>, List<Proxy>> targetMap = createTargetMap(proxyMap);
            for(Map.Entry<Class<?> ,List<Proxy>> targetEntry : targetMap.entrySet()){
                Class<?> targetClass = targetEntry.getKey();
                List<Proxy> proxyList = targetEntry.getValue();
                Object proxy = ProxyManager.createProxy(targetClass, proxyList);
                BeanHelper.setBean(targetClass, proxy);
            }
        } catch (Exception e) {
            logger.error("aop failure",e);
            e.printStackTrace();
        }
    }
*/

    private static Set<Class<?>> createTargetClassSet(Aspect aspect) throws Exception{
        Set<Class<?>> targetClassSet = new HashSet<Class<?>>();
        Class<? extends Annotation> annotation = aspect.value();
        if(null != annotation && !annotation.equals(Aspect.class)){
            targetClassSet.addAll(ClassHelper.getClassSetByAnnotation(annotation));
        }
        return targetClassSet;
    }


    /**
     * 代理类需要拓展AspectProxy，并且还需要带有Aspect注解
     * @return
     * @throws Exception
     */
    private static Map<Class<?> ,Set<Class<?>>> createProxyMap() throws  Exception{
        Map<Class<?>, Set<Class<?>>> proxyMap = new HashMap<Class<?>, Set<Class<?>>>();
        addAspectProxy(proxyMap);
        addTransaction(proxyMap);
        return proxyMap;
    }


    /**
     * 添加事物
     * @param proxyMap
     */
    public static void addTransaction(Map<Class<?>, Set<Class<?>>> proxyMap) {
        Set<Class<?>> serviceClass = ClassHelper.getClassSetByAnnotation(Service.class);
        proxyMap.put(Transaction.class,serviceClass);
    }

    /**
     * aop代理
     * @param proxyMap
     * @throws Exception
     */
    public static void addAspectProxy(Map<Class<?>, Set<Class<?>>> proxyMap) throws Exception{
        Set<Class<?>> proxyClassSet = ClassHelper.getClassSetBySuper(AspectProxy.class);
        for(Class<?> proxyClass : proxyClassSet){
            if(proxyClass.isAnnotationPresent(Aspect.class)){
                Aspect aspect = proxyClass.getAnnotation(Aspect.class);
                Set<Class<?>> targetClassSet = createTargetClassSet(aspect);
                proxyMap.put(proxyClass, targetClassSet);//代理类，和目标类对象集合
            }
        }
    }


    private static  Map<Class<?> ,List<Proxy>> createTargetMap(Map<Class<?>,Set<Class<?>>> proxyMap) throws Exception{
        Map<Class<?>, List<Proxy>> targetMap = new HashMap<Class<?>, List<Proxy>>();
        for(Map.Entry<Class<?> ,Set<Class<?>>> proxyEntry : proxyMap.entrySet()){
            Class<?> proxyClass = proxyEntry.getKey();
            Set<Class<?>> targetClassSet = proxyEntry.getValue();
            for(Class<?> targetClass : targetClassSet){
                Proxy proxy = (Proxy)proxyClass.newInstance();
                if(targetMap.containsKey(targetClass)){
                    targetMap.get(targetClass).add(proxy);
                }else{
                    List<Proxy> proxyList = new ArrayList<Proxy>();
                    proxyList.add(proxy);
                    targetMap.put(targetClass, proxyList);
                }
            }
        }
        return targetMap;
    }

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getContextClassLoader()); // 当前线程的类加载器
        System.out.println(AopHelper.class.getClassLoader()); // 当前类的类加载器
        System.out.println(ClassLoader.getSystemClassLoader()); // 系统初始的类加载器

        int i = 1;
        i++;
        ++i;
        System.out.println(++i);
    }

}
