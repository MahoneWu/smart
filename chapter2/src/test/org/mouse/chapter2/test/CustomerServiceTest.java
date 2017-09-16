package org.mouse.chapter2.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mouse.chapter2.helper.DateBaseHelper;
import org.mouse.chapter2.model.Customer;
import org.mouse.chapter2.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Mahone Wu on 2017/8/23.
 */
public class CustomerServiceTest {


    public static final Logger logger = LoggerFactory.getLogger(CustomerServiceTest.class);


    private final CustomerService customerService;


    public CustomerServiceTest(){
        this.customerService = new CustomerService();
    }



    //@Before
    public void init(){
        DateBaseHelper.executeSqlFile("sql/customer_init.sql");
    }



    @Test
    public void getCustomerListTest() throws Exception{
        List<Customer> customerList = customerService.getCustomerList(null);
        Assert.assertEquals(2,customerList.size());

    }

    @Test
    public void getCustomerTest() throws Exception{
        long id = 1;
        Customer customer = customerService.getCustomer(id);
        Assert.assertNotNull(customer);
    }


    @Test
    public void createCustomerTest() throws Exception{
        Map<String, Object> fieldMap = new HashMap<String, Object>();
        fieldMap.put("name", "customer-test");
        fieldMap.put("contact", "test");
        fieldMap.put("telephone", "12301201012");
        boolean result = customerService.createCustomer(fieldMap);
        Assert.assertTrue(result);
    }


    public void updateCustomerTest() throws Exception{
        long id = 1;
        Map<String, Object> fieldMap = new HashMap<String, Object>();
        fieldMap.put("name", "customer-test-update");
        boolean result = customerService.updateCustomer(id,fieldMap);
        Assert.assertTrue(result);
    }

    /**
     * 删除测试
     * @throws Exception
     */
    public void deleteCustomer() throws Exception{
        long id = 1;
        boolean result = customerService.deleteCustomer(id);
        Assert.assertTrue(result);
    }




    @Test
    public void testlogger(){
        try{
            double  i =  1 / 0;
            logger.info("123");
        }catch (Exception e){
            logger.debug("--"+e);
            logger.error("--"+e);
        }
    }



}
