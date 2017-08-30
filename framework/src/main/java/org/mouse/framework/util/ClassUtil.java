package org.mouse.framework.util;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileFilter;
import java.net.JarURLConnection;
import java.net.URL;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 * Created by Mahone on 2017/8/29.
 */
public class ClassUtil {


    private static final Logger logger = LoggerFactory.getLogger(ClassUtil.class);


    /**
     * 获取类加载器
     * @return
     */
    public static ClassLoader getClassLoader() {
        return Thread.currentThread().getContextClassLoader();
    }


    /**
     * 加载类
     * @param className
     * @param isInitialized 指是否执行类的静态代码块
     * @return
     */
    public static Class<?> loadClass(String className, boolean isInitialized) {
        Class<?> clz;

        try {
            clz = Class.forName(className, isInitialized, getClassLoader());
        } catch (ClassNotFoundException e) {
            logger.error("load class failure",e);
            throw new RuntimeException(e);
        }
        return clz;
    }

    /**
     * 获取指定包名下的所有类
     * @param packageName
     * @return
     */
    public static Set<Class<?>> getClassSet(String packageName) {
        Set<Class<?>> classSet = new HashSet<Class<?>>();
        try {
            String name = packageName.replace(".", "/");
            Enumeration<URL> urls = getClassLoader().getResources(name);
            while(urls.hasMoreElements()){
                URL url = urls.nextElement();
                if(null != url){
                    String protocol = url.getProtocol();
                    if(null != protocol && protocol.equals("file")){
                        String packagePath = url.getPath().replaceAll("%20", "");
                        addClass(classSet, packagePath, packageName);
                    }else if(null != protocol && protocol.equals("jar")){
                        JarURLConnection jarURLConnection = (JarURLConnection) url.openConnection();
                        if(null != jarURLConnection){
                            JarFile jarFile = jarURLConnection.getJarFile();
                            if(null != jarFile){
                                Enumeration<JarEntry> jarEntries = jarFile.entries();
                                while (jarEntries.hasMoreElements()){
                                    JarEntry jarEntry = jarEntries.nextElement();
                                    String jarEntryName = jarEntry.getName();
                                    if(jarEntryName.endsWith(".class")){
                                        String className = jarEntryName.substring(0, jarEntryName.lastIndexOf(".")).replaceAll("/", ".");
                                        doAddClass(classSet, className);
                                    }
                                }
                            }
                        }
                    }
                }

            }
        }catch (Exception e){
            logger.error("get class set failure",e);
            throw new RuntimeException(e);
        }
        return classSet;
    }


    public static void addClass(Set<Class<?>> classSet, String packagePath, String packageName) {
        final File[] flies = new File(packagePath).listFiles(new FileFilter() {
            @Override
            public boolean accept(File file) {
                return (file.isFile() && file.getName().endsWith(".class")) || file.isDirectory();
            }
        });

        for(File file : flies){
            String fileName = file.getName();
            if(file.isFile()){
                String className = fileName.substring(0, fileName.lastIndexOf("."));
                if(StringUtil.isNotEmpty(packageName)){
                    className = packageName + "." + className;
                }
                doAddClass(classSet, className);
            }else{
                String subPackagePath = fileName;
                if(StringUtils.isNotEmpty(packagePath)){
                    subPackagePath = packageName + "/" + subPackagePath;
                }
                String subPackageName = fileName;
                if(StringUtil.isNotEmpty(packageName)){
                    subPackageName = packageName + "." + subPackageName;
                }
                addClass(classSet, subPackagePath, subPackageName);
            }
        }
    }

    /**
     *
     * @param classSet
     * @param className
     */
    private static  void doAddClass(Set<Class<?>> classSet , String className){
        Class<?> cls = loadClass(className, false);
        classSet.add(cls);
    }



}
