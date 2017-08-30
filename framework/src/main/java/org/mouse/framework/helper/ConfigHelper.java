package org.mouse.framework.helper;

import org.mouse.framework.ConfigConstant;
import org.mouse.framework.util.PropsUtil;

import java.util.Properties;

/**
 * Created by Mahone on 2017/8/29.
 */
public class ConfigHelper{


    private static final Properties CONFIG_PROPS = PropsUtil.loadProps(ConfigConstant.CONFIG_FILE);


    /**
     * 获取数据库驱动
     * @return
     */
    public static String getJdbcDriver(){
        return PropsUtil.getString(CONFIG_PROPS, ConfigConstant.JDBC_DREIVE);
    }


    /**
     * 获取数据库url
     * @return
     */
    public  static String getJdbcUrl(){
        return PropsUtil.getString(CONFIG_PROPS, ConfigConstant.JDBC_URL);
    }

    /**
     * 获取用户名
     * @return
     */
    public static String getJdbcUserName() {
        return PropsUtil.getString(CONFIG_PROPS, ConfigConstant.JDBC_USERNAME);
    }


    /**
     * 获取密码
     * @return
     */
    public static String getJdbcPassword(){
        return PropsUtil.getString(CONFIG_PROPS, ConfigConstant.JDBC_PASSWORD);
    }

    /**
     * 获取包目录
     * @return
     */
    public static String getAppBasePackage(){
        return PropsUtil.getString(CONFIG_PROPS, ConfigConstant.APP_BASE_PACKAGE);
    }


    /**
     * jsp路径
     * @return
     */
    public static String getAppJspPath(){
        return PropsUtil.getString(CONFIG_PROPS, ConfigConstant.APP_JSP_PATH,"/WEB-INF/view/");
    }


    /**
     *静态资源路径
     * @return
     */
    public static String getAppAssetPath(){
        return PropsUtil.getString(CONFIG_PROPS, ConfigConstant.APP_ASSET_PATH, "/asset/");
    }


}
