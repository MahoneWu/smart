package org.mouse.framework;

import org.mouse.framework.bean.Data;
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
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.Date;
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
        //获取请求方法与请求路径
        String requestMethod = request.getMethod().toLowerCase();

        String requestPath = request.getPathInfo();
        //获取action处理器
        Handler handler = ControllerHelper.getHander(requestMethod,requestPath);

        if(null != handler){
            //获取Controller类及其Bean实列
            Class<?> controllerClass = handler.getControllerClass();

            Object controllerBean = BeanHelper.getBean(controllerClass);
            //创建请求参数对象
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
            //调用action方法
            Method actionMethod = handler.getActionMethod();
            Object result = ReflectionUtil.invokeMethod(controllerBean, actionMethod, param);
            //处理Action方法返回值
            if(request instanceof View){
                //返回jsp页面
                View view = (View) result;
                String path = view.getPath();
                if(StringUtil.isNotEmpty(path)){
                    if(path.startsWith("/")){
                        response.sendRedirect(request.getContextPath() + path);
                    }else {
                        Map<String, Object> model = view.getModel();

                        for (Map.Entry<String, Object> entry : model.entrySet()) {
                            request.setAttribute(entry.getKey(), entry.getValue());
                        }
                        request.getRequestDispatcher(ConfigHelper.getAppJspPath() + path).forward(request, response);
                    }
                }else if(result instanceof Data){
                    Data data = (Data) result;
                    Object model = data.getModel();
                    if(null != model){
                        response.setContentType("application/json");
                        response.setCharacterEncoding("UTF-8");
                        PrintWriter writer = response.getWriter();
                        String json = JsonUtil.toJson(model);
                        writer.write(json);
                        writer.flush();
                        writer.close();
                    }
                }
            }
        }
    }


}
