package org.mouse.framework.helper;

import org.mouse.framework.util.ClassUtil;

/**
 * Created by Mahone on 2017/8/31.
 */
public class HelperLoader {


    public static void init() {
        Class<?>[] classList = {ClassHelper.class,BeanHelper.class,AopHelper.class,IocHelper.class,ControllerHelper.class};

        for(Class<?> clz : classList){
            ClassUtil.loadClass(clz.getName(), false);
        }

    }
}

