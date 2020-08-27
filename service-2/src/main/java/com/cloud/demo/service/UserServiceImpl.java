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
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return user.toString() + " -> service-2 drink";
    }
}
