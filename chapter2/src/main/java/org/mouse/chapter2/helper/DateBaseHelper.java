package org.mouse.chapter2.helper;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.mouse.chapter2.util.CollectionUtil;
import org.mouse.chapter2.util.PropsUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * Created by Mahone Wu on 2017/8/25.
 */
public class DateBaseHelper {

    public static final Logger logger = LoggerFactory.getLogger(DateBaseHelper.class);


    private static final QueryRunner QUERY_RUNNER = new QueryRunner();

    private static final ThreadLocal<Connection> CONNECTION_HOLDER = new ThreadLocal<Connection>();

    private static final String DRIVECLASS;
    private static final String URL;
    private static final String USERNAME;
    private static final String PASSWD;


    static {
        Properties prop = PropsUtil.loadProps("config.properties");
        DRIVECLASS = prop.getProperty("jdbc.driver");
        URL = prop.getProperty("jdbc.url");
        USERNAME = prop.getProperty("jdbc.username");
        PASSWD = prop.getProperty("jdbc.password");
        try {
            Class.forName(DRIVECLASS);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    /**
     * 获取数据库连接
     * @return
     */
    public static Connection getConnection(){
        Connection conn = CONNECTION_HOLDER.get();
        try {
            if(null == conn){
                conn = DriverManager.getConnection(URL, USERNAME, PASSWD);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            CONNECTION_HOLDER.set(conn);
        }
        return conn;
    }

    /**
     * 关闭数据库连接
     */
    public  static void closeConnection(){
        Connection conn = CONNECTION_HOLDER.get();
        if(null != conn){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    public static  <T> List<T> queryEntityList(Class<T> clz,String sql,Object... params){
        List<T> entityList = null;
        Connection conn = getConnection();
        try {
            entityList = QUERY_RUNNER.query(conn, sql, new BeanListHandler<T>(clz), params);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closeConnection();
        }
        return entityList;
    }

    public static  <T> T queryEntity(Class<T> clz,String sql,Object... params){
        T entity = null;
        Connection conn = getConnection();
        try {
            entity = QUERY_RUNNER.query(conn, sql, new BeanHandler<T>(clz), params);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closeConnection();
        }
        return entity;
    }


    public static List<Map<String,Object>> executeQuery(String sql,Object...params) {
        List<Map<String, Object>> result = null;
        Connection connection = getConnection();
        try {
            result = QUERY_RUNNER.query(connection, sql, new MapListHandler(),params);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closeConnection();
        }
        return result;
    }

    public static int executeUpdate(String sql,Object...params){
        int rows = 0;
        Connection connection = getConnection();
        try {
            rows = QUERY_RUNNER.update(connection, sql, params);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closeConnection();
        }
        return rows;
    }


    public static  <T> boolean insertEntity(Class<T> entityClass,Map<String,Object> fieldMap){
        if (CollectionUtil.isEmpty(fieldMap)) {
            logger.error("fieldMap is empty");
            return false;
        }
        getTableName(entityClass);
        return true;

    }

    private static <T> String getTableName(Class<T> entityClass) {
        return entityClass.getSimpleName().toUpperCase();
    }



}
