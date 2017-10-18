package org.mouse.spring.one;

/**
 * @author wuhao Mahone Wu
 * @date 2017/10/19
 */
public class DowJonesNewsListener implements  IFNewsListener {


    @Override
    public void getNews() {
        System.out.println("获取新闻");
    }
}
