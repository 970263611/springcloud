package com.cloud.demo.service;

import com.cloud.demo.model.User;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author dingwq
 * @Date 2020/8/25 17:34
 * @Description
 */

@FeignClient(name = "service-user")
public interface UserService {

    @RequestMapping(value = "/user-drink")
    String drink(@RequestBody User user);
}
