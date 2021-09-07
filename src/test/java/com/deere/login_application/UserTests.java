package com.deere.login_application;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
class UserTests {

    @Test
    void whenUserCreated() {
        UserService user = new UserService();
        String message = user.create("nilesh", "123456789ar");
        Assert.assertEquals("User successfully created", message);
    }

    @Test
    void whenUsernameEmpty() {
        UserService user = new UserService();
        String message = user.create("", "nilesh");
        Assert.assertEquals("Username is empty", message);
    }

    @Test
    void whenPasswordEmpty() {
        UserService user = new UserService();
        String message = user.create("nilesh", "");
        Assert.assertEquals("Password is empty", message);
    }

    @Test
    void whenUsernameContainsNonalphabets() {
        UserService user = new UserService();
        String message = user.create("nilesh123", "nilesh");
        Assert.assertEquals("Username must contain only alphabets", message);
    }

    @Test
    void whenUsernameLengthNotBetween2And11() {
        UserService user = new UserService();
        String message = user.create("nileshhahahaahahahahah", "nilesh");
        Assert.assertEquals("Username length should be less than 11", message);

        message = user.create("n", "nilesh");
        Assert.assertEquals("Username length should be greater than 1", message);
    }

    @Test
    void whenPasswordLengthIsLessThanEight() {
        UserService user = new UserService();
        String message = user.create("nilesh", "nilesh");
        Assert.assertEquals("Minimum length of password is 8.", message);
    }

    @Test
    void whenPasswordContainsLessThanTwoAlphabets() {
        UserService user = new UserService();
        String message = user.create("nilesh", "n12345677");
        Assert.assertEquals("Password should contain atleast 2 alphabets.", message);
    }


    @Test
    void whenPasswordContainsLessThanTwoNumber() {
        UserService user = new UserService();
        String message = user.create("nilesh", "nileshjha1");
        Assert.assertEquals("Password should contain atleast 2 numbers.", message);
    }


}
