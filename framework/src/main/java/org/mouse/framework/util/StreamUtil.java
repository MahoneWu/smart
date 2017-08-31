package org.mouse.framework.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.Buffer;

/**
 * Created by Mahone on 2017/8/31.
 */
public class StreamUtil {



    private static final Logger logger = LoggerFactory.getLogger(ClassUtil.class);



    public static  String getString(InputStream is){
        StringBuilder sb = new StringBuilder();

        try {

            BufferedReader reader = new BufferedReader(new InputStreamReader(is));

            String line;

            while ((line = reader.readLine()) != null){
                sb.append(line);
            }

        }catch (Exception e){
            logger.error("get string failure",e);
            throw new RuntimeException(e);
        }
        return sb.toString();
    }


}
