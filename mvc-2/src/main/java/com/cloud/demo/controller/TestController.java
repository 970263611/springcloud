package com.cloud.demo.controller;

import com.cloud.demo.model.User;
import com.cloud.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
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
        return "mvc-2 filter & " + "param -> " + request.getParameter("gateway-param");
    }

    @RequestMapping("hystrix")
    public String hystrix(HttpServletRequest request) {
        return "mvc-2 hystrix & " + "param -> " + request.getParameter("gateway-param");
    }

    @RequestMapping("/drink")
    public String user(User user) {
        String result = userService.drink(user);
        return result;
    }
}
