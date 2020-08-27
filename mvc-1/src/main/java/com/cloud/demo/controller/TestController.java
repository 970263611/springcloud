package com.cloud.demo.controller;

import com.cloud.demo.model.User;
import com.cloud.demo.service.UserService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author dingwq
 * @Date 2020/8/24 17:09
 * @Description
 */
@RestController
public class TestController {

    @Autowired
    private UserService userService;

    @RequestMapping("filter")
    public String test(HttpServletRequest request) {
        return "mvc-1 filter & " + "param -> " + request.getParameter("gateway-param");
    }

    @RequestMapping("hystrix")
    public String hystrix(HttpServletRequest request) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "mvc-1 hystrix & " + "param -> " + request.getParameter("gateway-param");
    }

    @RequestMapping("/drink")
    //设定hystrix回调方法，须保持入参和返回值类型一致，否则异常
//    @HystrixCommand(fallbackMethod = "fail")
    public String user(User user) {
        String result = userService.drink(user);
        return result;
    }

//    public String fail(User user) {
//        return "hystrix default fallBack";
//    }

}
