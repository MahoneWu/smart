package org.mouse.spring.aspect;


import org.springframework.stereotype.Service;

/**
 * @Title: MultiAdvicesAspect
 * @Package org.mouse.spring.aspect
 * @Description: 实现类
 * @author Mahone Wu
 * @date 2017/12/12 15:50
 * @version V1.0
 */
@Service
public class AdviceImpl {

    public boolean execute(String name,String msg){
        System.out.println(msg +","+name);
        return Boolean.TRUE;
    }


    public boolean execute(String name,int a){
        int b = 1 / a;
        System.out.println("name="+name);
        return Boolean.TRUE;
    }

    public boolean execute(int a){
        int b = 1 / a;
        return Boolean.TRUE;
    }

    public boolean execute(String taskName){
        System.out.println("===="+taskName);
        return Boolean.TRUE;
    }

}
