package org.mouse.framework;

import org.mouse.framework.bean.Handler;
import org.mouse.framework.bean.Param;
import org.mouse.framework.bean.View;
import org.mouse.framework.helper.BeanHelper;
import org.mouse.framework.helper.ConfigHelper;
import org.mouse.framework.helper.ControllerHelper;
import org.mouse.framework.helper.HelperLoader;
import org.mouse.framework.util.*;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by xn066797 on 2017/8/31.
 */
@WebServlet(urlPatterns = "/*",loadOnStartup = 0)
public class DispatcherServlet extends HttpServlet {


    public void init(ServletConfig servletConfig) throws ServletException{

        //初始化相关Helper
        HelperLoader.init();

        //获取 ServletContext 对象（用于注册Servlet）
        ServletContext servletContext = servletConfig.getServletContext();
        //注册处理jsp的Servlet
        ServletRegistration jspServlet = servletContext.getServletRegistration("jsp");

        jspServlet.addMapping(ConfigHelper.getAppAssetPath() + "*");
        //注册处理静态资源默认的Servlet
        ServletRegistration defaultServlet = servletContext.getServletRegistration("default");

        defaultServlet.addMapping(ConfigHelper.getAppAssetPath() + "*");

    }


    public void service(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException {

        String requestMethod = request.getMethod().toLowerCase();

        String requestPath = request.getPathInfo();

        Handler handler = ControllerHelper.getHander(requestMethod,requestPath);

        if(null != handler){

            Class<?> controllerClass = handler.getControllerClass();

            Object controllerBean = BeanHelper.getBean(controllerClass);

            Map<String, Object> paramMap = new HashMap<String, Object>();

            Enumeration<String> paramNames = request.getParameterNames();

            while (paramNames.hasMoreElements()){
                String paramName = paramNames.nextElement();
                String paramValue = request.getParameter(paramName);
                paramMap.put(paramName, paramValue);
            }
            String body = CodecUtil.decodeURL(StreamUtil.getString(request.getInputStream()));
            if(StringUtil.isNotEmpty(body)){
                String[] params = StringUtil.spiltString(body,"&");
                if(ArrayUtil.isNotEmpty(params)){
                    for(String param  : params){
                        String[] array = StringUtil.spiltString(param, "=");

                        if(ArrayUtil.isNotEmpty(array) && array.length == 2 ){
                            String paramName = array[0];
                            String paramValue = array[1];
                            paramMap.put(paramName, paramValue);
                        }

                    }
                }
            }

            Param param = new Param(paramMap);
            Method actionMethod = handler.getActionMethod();
            Object result = ReflectionUtil.invokeMethod(controllerBean, actionMethod, param);

            if(request instanceof View){

            }



        }




    }




}
