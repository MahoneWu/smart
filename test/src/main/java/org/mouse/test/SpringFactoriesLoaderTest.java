package org.mouse.test;

import org.springframework.context.ApplicationListener;
import org.springframework.core.io.UrlResource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.core.io.support.SpringFactoriesLoader;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Properties;

/**
 * Created by Mahone Wu on 2017/10/9.
 */
public class SpringFactoriesLoaderTest {

    public static void main(String[] args) {
        Class factoryClass =ApplicationListener.class;
        ClassLoader classLoader = SpringFactoriesLoader.class.getClassLoader();
        try {
            Enumeration ex = classLoader != null?classLoader.getResources("META-INF/spring.factories"):ClassLoader.getSystemResources("META-INF/spring.factories");
            ArrayList result = new ArrayList();
            String factoryClassName = factoryClass.getName();
            while(ex.hasMoreElements()) {
                URL url = (URL)ex.nextElement();
                Properties properties = PropertiesLoaderUtils.loadProperties(new UrlResource(url));
                String factoryClassNames = properties.getProperty(factoryClassName);
                result.addAll(Arrays.asList(StringUtils.commaDelimitedListToStringArray(factoryClassNames)));
            }
            System.out.println(result.size());
            //return result;
        } catch (IOException var8) {
            throw new IllegalArgumentException("Unable to load [" + factoryClass.getName() + "] factories from location [" + "META-INF/spring.factories" + "]", var8);
        }
    }

}
