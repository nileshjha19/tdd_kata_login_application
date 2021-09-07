package com.deere.login_application;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@SpringBootTest
class AuthenticationTests {

    @Test
    void LoginFailureWhenUsernameEmpty()
    {
        LoginService loginService = new LoginService();
        String message = loginService.login("", "12345");
        Assert.assertEquals("Login failed. Username is empty", message);
    }

    @Test
    void LoginFailureWhenPasswordEmpty()
    {
        LoginService loginService = new LoginService();
        String message = loginService.login("nilesh", "");
        Assert.assertEquals("Login failed. Password is empty", message);
    }

    @Test
    void LoginFailureWhenUsernameInvalid()
    {
        LoginService loginService = new LoginService();
        UserService userService = new UserService();
        userService.create("nilesh", "123456");
        userService.create("riddhi", "123456");
        String message = loginService.login("nileshhh", "1234");
        Assert.assertEquals("Login failed. Username is invalid", message);
    }

    @Test
    void LoginFailureWhenPasswordInvalid()
    {
        LoginService loginService = new LoginService();
        UserService userService = new UserService();
        userService.create("nilesh", "123456");
        userService.create("riddhi", "1234567");
        String message = loginService.login("nilesh", "1234567");
        Assert.assertEquals("Login failed. Password is invalid", message);
    }

    @Test
    void LoginSuccess()
    {
        LoginService loginService = new LoginService();
        UserService userService = new UserService();
        userService.create("nilesh", "123456nilesh");
        userService.create("riddhi", "123456riddhi");
        String message = loginService.login("nilesh", "123456nilesh");
        Assert.assertEquals("Login successful", message);
    }
}
