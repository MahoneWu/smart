package org.mouse.spring.targetsourcedemo;

/**
 * Created by Mahone Wu on 2017/11/22.
 */
public class UserServiceImpl implements UserService {

    @Override
    public void print() {
        System.out.println(getClass()+"#print");
    }
}
