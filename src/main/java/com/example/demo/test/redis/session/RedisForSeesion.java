package com.example.demo.test.redis.session;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;

/**
 * @Description spring-session测试
 * @Date 2020/7/27 13:25
 * @Author cly
 **/
@RestController
public class RedisForSeesion {
    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String printSession(HttpServletRequest request, String name) {
        String storedName = (String) request.getSession().getAttribute("name");
        if (storedName == null) {
            request.getSession().setAttribute("name", name);
            System.out.println("=1=="+request.getSession().getId());
            storedName = name;
        }
        return "hello " + storedName;
    }
    @RequestMapping(value = "/logout",method = RequestMethod.GET)
    public void logout(HttpServletRequest request){
        String storedName = (String) request.getSession().getAttribute("name");
        if(storedName!=null){
            System.out.println("=2="+request.getSession().getId());
            request.getSession().invalidate();
        }
    }
}
