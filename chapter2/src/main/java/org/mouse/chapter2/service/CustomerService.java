package org.mouse.chapter2.service;

import org.mouse.chapter2.helper.DateBaseHelper;
import org.mouse.chapter2.model.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Mahone Wu on 2017/8/23.
 */
public class CustomerService {

    public static final Logger logger = LoggerFactory.getLogger(CustomerService.class);

   /* public List<Customer> getCustomerLists(String  keyword){
        Connection connection = null;
        List<Customer> customerList = null;
        try{
           customerList = new ArrayList<Customer>();
            String sql = "select * from customer";
            connection = DateBaseHelper.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            Customer customer = null;
            while (rs.next()){
                customer = new Customer();
                customer.setId(rs.getLong("id"));
                customer.setName(rs.getString("name"));
                customer.setContact(rs.getString("contact"));
                customer.setTelephone(rs.getString("telephone"));
                customer.setEmail(rs.getString("email"));
                customer.setRemark(rs.getString("remark"));
                customerList.add(customer);
            }
        }catch (SQLException e){
            logger.error("查询客户信息出现异常={}",e);
        }finally {
            DateBaseHelper.closeConnection(connection);
        }
        return customerList;
    }*/

    public List<Customer> getCustomerList(String  keyword){
        String sql = "select * from customer";
        List<Customer> customerList = DateBaseHelper.queryEntityList(Customer.class,sql,null);
        return customerList;
    }


    public Customer getCustomer(long id){
        return null;
    }


    /**
     * 创建
     * @param fieldMap
     * @return
     */
    public boolean createCustomer(Map<String,Object> fieldMap){
        return DateBaseHelper.insertEntity(Customer.class, fieldMap);
    }

    /**
     *
     * @return
     */
    public  boolean updateCustomer(long id,Map<String,Object> fieldMap){
        return DateBaseHelper.updateEntity(Customer.class, id,fieldMap);
    }

    /**
     * 删除用户
     * @param id
     * @return
     */
    public boolean deleteCustomer(long id){
        return DateBaseHelper.deleteEntity(Customer.class,id);
    }



}
