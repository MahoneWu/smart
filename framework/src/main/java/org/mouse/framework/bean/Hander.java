package org.mouse.framework.bean;

import java.lang.reflect.Method;

/**
 * Created by Mahone on 2017/8/30.
 */
public class Hander {


    /**
     * controller
     */
    private Class<?> controllerClass;

    /**
     * Action
     */
    private Method actionMethod;


    public Hander(Class<?> controllerClass, Method actionMethod) {
        this.controllerClass = controllerClass;
        this.actionMethod = actionMethod;
    }

    public Class<?> getControllerClass() {
        return controllerClass;
    }

    public Method getActionMethod() {
        return actionMethod;
    }
}
