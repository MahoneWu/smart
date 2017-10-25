package org.mouse.spring.one;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.*;

import java.io.FileNotFoundException;

/**
 * main
 *
 * @author wuhao Mahone Wu
 * @date 2017/10/20
 */
public class Main {

    public static void main(String[] args)throws Exception {
        BeanFactory container = new XmlBeanFactory(new ClassPathResource("conf/one/one.xml"));

        FXNewsProvider fxNewsProvider1 = (FXNewsProvider) container.getBean("djNewProvider");
        fxNewsProvider1.getAndPersisterNews();
        System.out.println(fxNewsProvider1);
        FXNewsProvider fxNewsProvider2 = (FXNewsProvider) container.getBean("djNewProvider");
        System.out.println(fxNewsProvider2);



        ResourceLoader resourceLoader = new DefaultResourceLoader();
        Resource fakeFileResource = resourceLoader.getResource("D:/spring21site/README");
        System.out.println(fakeFileResource instanceof ClassPathResource);
        System.out.println(fakeFileResource.exists());
        Resource urlResource1 = resourceLoader.getResource("file:D:/spring21site/README");

        System.out.println(urlResource1 instanceof UrlResource);
        Resource urlResource2 = resourceLoader.getResource("http://www.spring21.cn");

        try{
            fakeFileResource.getFile();
            //fail("no such file with path["+fakeFileResource.getFilename()+"] exists in classpath");
        }
        catch(FileNotFoundException e){
//
        }
        try{ urlResource1.getFile();
        }
        catch(FileNotFoundException e){
           // fail();
        }


        ApplicationContext ctx = new FileSystemXmlApplicationContext("conf/one/one.xml");
        System.out.println("djNewsPersister");

    }

}
