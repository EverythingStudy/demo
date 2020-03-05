package com.example.demo.test.Spring.Servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

/**
 * @Description ServletContext
 * servlet上下文，又名application，对于web项目来说，全局唯一的一个servletContext对象。
 * 用途：
 *  1.获取全局配置文件的参数
 *  2.获取web项目的绝对路径
 *  3.用于获取WebRoot文件夹下的文件(.JSP,.PNG,.html,.doc,)资源
 * @Date 2020/2/27 7:37
 * @Author cly
 **/
public class LearnServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
        //获取到servletContext对象1   (从当前Servlet对象获得)
        ServletContext c1=this.getServletContext();

        //获取到servletContext对象2  (从ServletConfig对象获得)
        ServletContext c2=this.getServletConfig().getServletContext();

        //获取到servletContext对象3   (从会话对象获取到，这是常用的方式)
        ServletContext c3=req.getSession().getServletContext();

        //判断对象是不是全局唯一
        System.out.println(c1==c2);
        System.out.println("对象标识："+c1.hashCode()+"---"+c2.hashCode()+"---"+c3.hashCode());
        InputStream inputStream=req.getSession().getServletContext().getResourceAsStream("application.yml");
    }
}
