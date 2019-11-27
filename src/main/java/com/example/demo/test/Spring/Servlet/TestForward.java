package com.example.demo.test.Spring.Servlet;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description
 * @Date 2019/11/15 14:27
 * @Author cly
 **/
@Controller
public class TestForward {
    @ResponseBody
    @RequestMapping("/test/get")
    public void controller(HttpServletRequest request, HttpServletResponse response){
        System.out.println("test");
       // ApplicationContext applicationContext=new ClassPathXmlApplicationContext("");
//        try {
//            request.getRequestDispatcher("").forward(request,response);//请求转发
//        } catch (ServletException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        try {
//            response.sendRedirect("404.jsp");//重定向
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        ModelAndView modelAndView=new ModelAndView();
        //Beans beans=new Beans();
        //beans.setName("chen");
       // return beans;
    }
}
