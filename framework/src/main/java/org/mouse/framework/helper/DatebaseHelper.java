package org.mouse.chapter2.helper;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.mouse.chapter2.model.Customer;
import org.mouse.chapter2.util.CollectionUtil;
import org.mouse.chapter2.util.PropsUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * Created by Mahone Wu on 2017/8/25.
 */
public class DateBaseHelper {

    public static final Logger logger = LoggerFactory.getLogger(DateBaseHelper.class);


    private static final QueryRunner QUERY_RUNNER ;
    private static final ThreadLocal<Connection> CONNECTION_HOLDER ;

    private static final BasicDataSource DATA_SOURCE;


    private static final String DRIVECLASS;
    private static final String URL;
    private static final String USERNAME;
    private static final String PASSWD;


    static {

        QUERY_RUNNER = new QueryRunner();
        CONNECTION_HOLDER = new ThreadLocal<Connection>();


        Properties prop = PropsUtil.loadProps("config.properties");
        DRIVECLASS = prop.getProperty("jdbc.driver");
        URL = prop.getProperty("jdbc.url");
        USERNAME = prop.getProperty("jdbc.username");
        PASSWD = prop.getProperty("jdbc.password");


        DATA_SOURCE = new BasicDataSource();
        DATA_SOURCE.setDriverClassName(DRIVECLASS);
        DATA_SOURCE.setUrl(URL);
        DATA_SOURCE.setUsername(USERNAME);
        DATA_SOURCE.setPassword(PASSWD);
    }


    /**
     * 获取数据库连接
     * @return
     */
    public static Connection getConnection(){
        Connection conn = CONNECTION_HOLDER.get();
        try {
            if(null == conn){
                //conn = DriverManager.getConnection(URL, USERNAME, PASSWD);
                conn = DATA_SOURCE.getConnection();
            }
        } catch (SQLException e) {
            logger.error("getConnection 异常 = {}",e);
            throw new RuntimeException(e);
        }finally {
            CONNECTION_HOLDER.set(conn);
        }
        return conn;
    }

    /**
     * 关闭数据库连接
     */
    /*public  static void closeConnection(){
        Connection conn = CONNECTION_HOLDER.get();
        if(null != conn){
            try {
                conn.close();
            } catch (SQLException e) {
                logger.error("closeConnection e= {}",e);
                throw new RuntimeException(e);
            }
        }
    }*/

    /*public  static void closeConnection(){
        Connection conn = CONNECTION_HOLDER.get();
        if(null != conn){
            try {
                conn.close();
            } catch (SQLException e) {
                logger.error("closeConnection e= {}",e);
                throw new RuntimeException(e);
            }
        }
    }*/


    public static  <T> List<T> queryEntityList(Class<T> clz,String sql,Object... params){
        List<T> entityList = null;
        Connection conn = getConnection();
        try {
            entityList = QUERY_RUNNER.query(conn, sql, new BeanListHandler<T>(clz), params);
        } catch (SQLException e) {
            logger.error("queryEntityList e= {}",e);
            throw new RuntimeException(e);
        }finally {
           // closeConnection();
        }
        return entityList;
    }

    public static  <T> T queryEntity(Class<T> clz,String sql,Object... params){
        T entity = null;
        Connection conn = getConnection();
        try {
            entity = QUERY_RUNNER.query(conn, sql, new BeanHandler<T>(clz), params);
        } catch (SQLException e) {
            logger.error("queryEntity异常=={}",e);
            throw new RuntimeException(e);
        }finally {
           // closeConnection();
        }
        return entity;
    }


    public static List<Map<String,Object>> executeQuery(String sql,Object...params) {
        List<Map<String, Object>> result = null;
        Connection connection = getConnection();
        try {
            result = QUERY_RUNNER.query(connection, sql, new MapListHandler(),params);
        } catch (SQLException e) {
            logger.error("查询异常 e= {}",e);
            throw new RuntimeException(e);
        }finally {
         //   closeConnection();
        }
        return result;
    }

    public static int executeUpdate(String sql,Object...params){
        int rows = 0;
        Connection connection = getConnection();
        try {
            rows = QUERY_RUNNER.update(connection, sql, params);
        } catch (SQLException e) {
            logger.error("executeUpdate e= {}",e);
            throw new RuntimeException(e);
        }finally {
           // closeConnection();
        }
        return rows;
    }


    /**
     * 插入数据
     * @param entityClass
     * @param fieldMap
     * @param <T>
     * @return
     */
    public static  <T> boolean insertEntity(Class<T> entityClass,Map<String,Object> fieldMap){
        if (CollectionUtil.isEmpty(fieldMap)) {
            logger.error("insertEntity fieldMap is empty");
            return false;
        }
        String sql  = "insert into" + getTableName(entityClass);
        StringBuilder columns = new StringBuilder("(");
        StringBuilder value = new StringBuilder("(");
        for(String fieldName : fieldMap.keySet()){
            columns.append(fieldName).append(", ");
            value.append("?,");
        }
        columns.replace(columns.lastIndexOf(","), columns.length(), ")");
        value.replace(value.lastIndexOf(","), value.length(), ")");
        sql += columns + "VALUES" + value;
        Object[] params = fieldMap.values().toArray();

        return executeUpdate(sql,params) == 1;
    }


    /**
     * 更新
     * @param clz
     * @param id
     * @param fieldMap
     * @param <T>
     * @return
     */
    public static <T> boolean updateEntity(Class<T> clz , long id,Map<String,Object> fieldMap){
        if (CollectionUtil.isEmpty(fieldMap)) {
            logger.error(" updateEntity  fieldMap is empty");
            return false;
        }

        String sql = "UPDATE" + getTableName(clz) + "SET";
        StringBuilder columns = new StringBuilder();
        for(String fieldName : fieldMap.keySet()){
            columns.append(fieldName).append("= ?,");
        }
        sql += columns.substring(0, columns.lastIndexOf(",")) + "where id = ?";
        List<Object> paramList = new ArrayList<Object>();
        paramList.addAll(fieldMap.keySet());
        paramList.add(id);
        Object[] params = paramList.toArray();
        return executeUpdate(sql, params) == 1;
    }


    /**
     * 删除
     * @param clz
     * @param id
     * @param <T>
     * @return
     */
    public static <T> boolean deleteEntity(Class clz, long id) {
        String sql = "delete from " + getTableName(clz) + "where id = ?";
        return executeUpdate(sql, id) == 1;
    }


    private static <T> String getTableName(Class<T> entityClass) {
        return entityClass.getSimpleName().toUpperCase();
    }



    public static void executeSqlFile(String filePath){
        InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream(filePath);
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        String sql;
        try {
            while ((sql = reader.readLine()) != null) {
                executeUpdate(sql);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
