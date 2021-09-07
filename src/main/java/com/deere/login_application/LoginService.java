package com.deere.login_application;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginService {


    public String login(String userName, String password) {

        String message = "";
        if(userName.isEmpty())
            return "Login failed. Username is empty";
        if(password.isEmpty())
            return "Login failed. Password is empty";

        userList.forEach((user) -> System.out.println(user.getUserName() + "" + user.getPassword()));
        if(!(userList.stream().anyMatch(user -> user.getUserName().equals(userName)))) {
            message = "Login failed. Username is invalid";
            return message;
        }
        else {
            if(userList.stream()
                    .noneMatch(user -> (user.getUserName().equals(userName) && user.getPassword().equals(password)))) {
                message = "Login failed. Password is invalid";
                return message;
            }
            else{
                message = "Login successful";
            }
        }
        return message;

    }
}
