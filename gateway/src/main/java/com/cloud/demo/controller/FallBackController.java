package com.cloud.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author dingwq
 * @Date 2020/8/26 11:09
 * @Description hystrix 超时回调
 */
@RestController
public class FallBackController {

    @RequestMapping("hystrix/fail")
    public String fail() {
        return "hystrix -> mvc fail";
    }
}
