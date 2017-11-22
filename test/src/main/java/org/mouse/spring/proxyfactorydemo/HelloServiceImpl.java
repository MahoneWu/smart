package org.mouse.spring.proxyfactorydemo;

/**
 * hello
 *
 * @author wuhao Mahone Wu
 * @date 2017/10/25
 */
public class HelloServiceImpl implements HelloService {


    /*public void setBasenames(String ...basenames){
        dealName(basenames);
    }


    public void dealName(String ...names){
        if(!ObjectUtils.isEmpty(names)) {
            for(int i=0;i<names.length;i++){
                System.out.println(names[i]);
            }
        }
    }*/

    @Override
    public void say(String thing) {
        System.out.println("hello ," + thing);
    }


    @Override
    public String execute(int id) {
        String name = "Mahone Wu-";
        System.out.println(name + id);
        return name;
    }
}
