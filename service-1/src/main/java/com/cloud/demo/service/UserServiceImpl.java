package com.cloud.demo.service;

import com.cloud.demo.model.User;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author dingwq
 * @Date 2020/8/25 17:54
 * @Description
 */
@RestController
public class UserServiceImpl implements UserService {

    @Override
    public String drink(User user) {
        return user.toString() + " -> service-1 drink";
    }
}
