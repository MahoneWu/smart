package org.mouse.spring.aspect;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Title: MultiAdvicesAspect
 * @Package org.mouse.spring.aspect
 * @Description: test
 * @author Mahone Wu
 * @date 2017/12/12 15:42
 * @version V1.0
 */
public class TestMain {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("conf/aspect/aspect.xml");
        AdviceImpl adviceImpl = (AdviceImpl) ctx.getBean("adviceImpl");
        //adviceImpl.execute("Mahone", "hello");
        //adviceImpl.execute("Mahone",0);
        //adviceImpl.execute(0);
        //adviceImpl.execute("hahhaha");
    }

}
