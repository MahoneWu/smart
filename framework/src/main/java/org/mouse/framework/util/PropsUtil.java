package org.mouse.framework.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by Mahone on 2017/8/23.
 */
public class PropsUtil {
    private static final Logger logger = LoggerFactory.getLogger(PropsUtil.class);

    public static Properties loadProps(String fileName){
        Properties properties = null;
        InputStream is = null;
        try{
            is = Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName);
            if(null == is){
                throw new FileNotFoundException(fileName + "file not found");
            }
            properties = new Properties();
            properties.load(is);
        }catch (IOException e){
            logger.error("加载属性出错 e = "+e);
        }finally {
            if(null != is){
                try {
                    is.close();
                } catch (IOException e) {
                   logger.error("关闭流失败 e = "+e);
                }
            }
        }
        return properties;
    }


    public static String getString(Properties prop ,String key){
        return getString(prop, key, "");
    }

    /**
     * 获取字符串
     * @param prop
     * @param key
     * @param defaultValue
     * @return
     */
    public static String getString(Properties prop,String key,String defaultValue){
        String value = defaultValue;
        if(prop.contains(key)){
            value = prop.getProperty(key);
        }
        return value;
    }


    public  static int getInt(Properties prop,String key){
        return getInt(prop,key,0);
    }

    public static int getInt(Properties prop,String key,int defaultValue){
        int value = defaultValue;
        return value;
    }



}
