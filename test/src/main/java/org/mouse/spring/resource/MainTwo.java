package org.mouse.spring.resource;

/**
 * test
 *
 * @author wuhao Mahone Wu
 * @date 2017/10/25
 */
public class MainTwo {


    public static void main(String[] args) {
        String name = "&helloService";
        String beanName = null;
        for(beanName = name; beanName.startsWith("&"); beanName = beanName.substring("&".length())) {
            ;
        }
        System.out.println(beanName);
    }


}
