package org.mouse.framework.util;

import org.apache.commons.lang3.ArrayUtils;

/**
 * Created by Mahone on 2017/8/30.
 */
public class ArrayUtil {

    public static  boolean isNotEmpty(Object[] array){
        return !ArrayUtils.isEmpty(array);
    }

    public static  boolean isEmpty(Object[] array){
        return ArrayUtils.isEmpty(array);
    }



}
