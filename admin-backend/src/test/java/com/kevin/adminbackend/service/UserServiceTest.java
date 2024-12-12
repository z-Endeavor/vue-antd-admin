package com.kevin.adminbackend.service;
import java.util.Date;

import com.kevin.adminbackend.model.domain.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 用户服务测试
 */
@SpringBootTest
public class UserServiceTest {

    @Resource
    private UserService userService;

    @Test
    public void testAddUser() {
        User user = new User();
        user.setUsername("test");
        user.setUserAccount("123");
        user.setAvatarUrl("");
        user.setGender(0);
        user.setUserPassword("123");
        user.setPhone("123");
        user.setEmail("456");

        boolean res = userService.save(user);
        System.out.println(user.getId());
        assertTrue(res);
    }

    @Test
    void userRegister() {
        String userAccount = "kevin";
        String userPassword = "";
        String checkPassword = "12345678";
        long res = userService.userRegister(userAccount, userPassword, checkPassword);
        assertEquals(-1, res);

        userAccount = "ke";
        userPassword = "12345678";
        res = userService.userRegister(userAccount, userPassword, checkPassword);
        assertEquals(-1, res);

        userAccount = "kevin";
        userPassword = "123456";
        checkPassword = "123456";
        res = userService.userRegister(userAccount, userPassword, checkPassword);
        assertEquals(-1, res);

        userPassword = "12345678";
        checkPassword = "123456789";
        res = userService.userRegister(userAccount, userPassword, checkPassword);
        assertEquals(-1, res);

        userAccount = "ke vin";
        checkPassword = "12345678";
        res = userService.userRegister(userAccount, userPassword, checkPassword);
        assertEquals(-1, res);

        userAccount = "kevin";
        res = userService.userRegister(userAccount, userPassword, checkPassword);
        assertTrue(res > 0);
    }
}