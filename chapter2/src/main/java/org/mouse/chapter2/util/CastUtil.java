package org.mouse.chapter2.util;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.helpers.Loader;

/**
 * Created by Mahone Wu on 2017/8/24.
 */
public class CastUtil {


    public static String castString(Object obj){
        return castString(obj, "");
    }

    public static String castString(Object obj,String defaultValue){
        return obj != null ? String.valueOf(obj) : defaultValue;
    }

    public static int castInt(Object object) {
        return castInt(object, 0);
    }

    /**
     * 强制转换为int
     * @param obj
     * @param defaultValue
     * @return
     */
    public static int castInt(Object obj, int defaultValue) {
        int value = defaultValue;
        if(null != obj){
            String valueStr = castString(obj);
            if(StringUtils.isNotEmpty(valueStr)){
                value = Integer.parseInt(valueStr);
            }
        }
        return value;
    }


    public static double castDouble(Object object){
        return  castDouble(object, 0.0);
    }


    /**
     * 转换为double
     * @param object
     * @param defaultValue
     * @return
     */
    public static double castDouble(Object object, double defaultValue) {
        double value = defaultValue;
        if(null != object){
            String valueStr = castString(object);
            if(StringUtils.isNotEmpty(valueStr)){
                value = Double.parseDouble(valueStr);
            }
        }
        return value;
    }


    public static long castLong(Object object) {
        return castLong(object,0);
    }

    /**
     * 转换为long
     * @param object
     * @param defaultValue
     * @return
     */
    public  static long castLong(Object object,long  defaultValue){
        long value = defaultValue;
        if(null != object){
            String valueStr = castString(object);
            if(StringUtils.isNotEmpty(valueStr)){
                value = Long.parseLong(valueStr);
            }
        }
        return value;
    }

    public static boolean castBoolean(Object object) {
        return castBoolean(object, false);
    }


    public static boolean castBoolean(Object object,boolean defaultValue){
        boolean value = defaultValue;
        if(null != object){
            String valueStr = castString(object);
            if(StringUtils.isNotEmpty(valueStr)){
                value = Boolean.parseBoolean(valueStr);
            }
        }
        return value;
    }



}

