package org.mouse.spring.resource;

import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.context.support.StaticMessageSource;

import java.util.Locale;
import static org.junit.Assert.*;

/**
 * 资源测试
 *
 * @author wuhao Mahone Wu
 * @date 2017/10/25
 */
public class MainOne {


    public static void main(String[] args) {
        StaticMessageSource messageSource = new StaticMessageSource();
        messageSource.addMessage("menu.file", Locale.US, "File({0})");
        messageSource.addMessage("menu.edit", Locale.US, "Edit");
        System.out.println("1==="+messageSource.getMessage("menu.file", new Object[]{"F"}, Locale.US));
        System.out.println("2==="+messageSource.getMessage("menu.edit", null,"Edit", Locale.US));
        ResourceBundleMessageSource rmessageSource = new ResourceBundleMessageSource();
        rmessageSource.setBasenames(new String[]{"conf/messages"});// 从 classpath加载资源文件
        System.out.println("3==="+rmessageSource.getMessage("menu.file", new Object[]{"F"}, Locale.US));
        ReloadableResourceBundleMessageSource romessageSource = new ReloadableResourceBundleMessageSource();
        romessageSource.setBasenames(new String[]{"file:conf/messages"}); // 从文件系统加载资源文件
        System.out.println("4===="+romessageSource.getMessage("menu.file", new Object[]{"F"},
                Locale.US));
        assertEquals("File(F)", romessageSource.getMessage("menu.file", new Object[]{"F"},
                Locale.US));
    }


}
