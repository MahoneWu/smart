package org.mouse.chapter2.util;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by Mahone Wu on 2017/8/24.
 */
public class StringUtil {

    /**
     * 判断是否为空
     * @param str
     * @return
     */
    public static  boolean isEmpty(String str){
        if(null != str){
            str = str.trim();
        }
        return StringUtils.isEmpty(str);
    }


    public static boolean isNotEmpty(String str){
        return !isEmpty(str);
    }

}
