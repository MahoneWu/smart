package org.mouse.framework.helper;

import org.mouse.framework.annotation.Action;
import org.mouse.framework.annotation.Controller;
import org.mouse.framework.bean.Handler;
import org.mouse.framework.bean.Request;
import org.mouse.framework.util.ArrayUtil;
import org.mouse.framework.util.CollectionUtil;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by Mahone on 2017/8/30.
 */
public class ControllerHelper {


    private static final Map<Request, Handler> ACTION_MAP = new HashMap<Request, Handler>();

    static {
        Set<Class<?>> controllerClassSet = ClassHelper.getControllerClass();
        if(CollectionUtil.isNotEmpty(controllerClassSet)){
            for(Class<?> controllerClass : controllerClassSet){
                Method[] methods = controllerClass.getDeclaredMethods();
                if(ArrayUtil.isNotEmpty(methods)){
                    for(Method method : methods){//循环
                        if(method.isAnnotationPresent(Action.class)){
                            Action action = method.getAnnotation(Action.class);
                            String mapping = action.value();
                            if(mapping.matches("\\w+:/\\w*")){
                                String[] array = mapping.split(":");
                                if(ArrayUtil.isNotEmpty(array)&&array.length == 2){
                                    String requestMethod = array[0];
                                    String requestPath = array[1];
                                    Request request = new Request(requestMethod, requestPath);
                                    Handler hander = new Handler(Controller.class, method);
                                    ACTION_MAP.put(request, hander);
                                }
                            }

                        }
                    }
                }
            }
        }
    }


    public static Handler getHander(String requestMethod, String requestPath) {
        Request request = new Request(requestMethod, requestPath);
        return ACTION_MAP.get(request);
    }

}
