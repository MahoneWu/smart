package org.mouse.spring.two;

import org.springframework.util.ObjectUtils;

/**
 * hello
 *
 * @author wuhao Mahone Wu
 * @date 2017/10/25
 */
public class HelloServiceImpl implements  HelloService {


    public void setBasenames(String ...basenames){
        dealName(basenames);
    }


    public void dealName(String ...names){
        if(!ObjectUtils.isEmpty(names)) {
            for(int i=0;i<names.length;i++){
                System.out.println(names[i]);
            }
        }
    }

    @Override
    public void say(String thing) {
        System.out.println("hello ," + thing);
    }
}
