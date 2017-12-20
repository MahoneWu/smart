package org.mouse.spring.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter;

import java.beans.PropertyDescriptor;

/**
 * Created by Mahone Wu on 2017/12/20.
 */
public class MyInstantiationAwareBeanPostProcessor extends InstantiationAwareBeanPostProcessorAdapter {


    public MyInstantiationAwareBeanPostProcessor() {
             super();
             System.out.println("这是InstantiationAwareBeanPostProcessorAdapter实现类构造器！！");
    }

    @Override
     public Object postProcessBeforeInstantiation(Class beanClass,String beanName) throws BeansException {
                 System.out.println("InstantiationAwareBeanPostProcessor调用postProcessBeforeInstantiation方法");
                 return null;
     }


    @Override
     public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
                 System.out.println("InstantiationAwareBeanPostProcessor调用postProcessAfterInitialization方法");
                 return bean;
    }

     @Override
     public PropertyValues postProcessPropertyValues(PropertyValues pvs,PropertyDescriptor[] pds, Object bean, String beanName) throws BeansException {
         System.out.println("InstantiationAwareBeanPostProcessor调用postProcessPropertyValues方法");
         return pvs;
     }

}
