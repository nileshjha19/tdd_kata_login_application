package com.deere.login_application;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {


    static List<User> userList = new ArrayList<>();

    public List<User> getUserList() {
        return userList;
    }

    public String create(String userName, String password) {

        String userNameCheck = validateUserName(userName);
        if ("Username is valid".equals(userNameCheck)) {
            String passwordCheck = validatePassword(password);
            if ("Password is valid".equals(passwordCheck)) {
                User user = new User(userName, password);
                addToStore(user);
                return "User successfully created";
            } else
                return passwordCheck;
        } else {
            return userNameCheck;
        }
    }

    private String validateUserName(String userName) {
        String message = "Username is valid";
        if (userName.isEmpty())
            message = "Username is empty";
        else {
            if (userName.length() < 2)
                message = "Username length should be greater than 1";
            else if (userName.length() > 10)
                message = "Username length should be less than 11";
            else if (!isStringAlphabetical(userName))
                message = "Username must contain only alphabets";
        }
        return message;
    }

    private String validatePassword(String password) {
        String message = "Password is valid";
        if (password.isEmpty())
            message = "Password is empty";
        else if (password.length() < 8) {
            message = "Minimum length of password is 8.";
        } else {
            int count = 0;
            int intCount = 0;
            for (int i = 0; i < password.length(); i++) {
                if (Character.isLetter(password.charAt(i)))
                    count++;
                if (Character.isDigit(password.charAt(i)))
                    intCount++;
            }
            if (count < 2) {
                message = "Password should contain atleast 2 alphabets.";
            } else if (intCount < 2) {
                message = "Password should contain atleast 2 numbers.";
            }
        }
        return message;

    }

    private boolean isStringAlphabetical(String userName) {
        return (userName.matches("^[a-zA-Z]*$"));
    }

    public boolean addToStore(User user) {
        //DB code
        return userList.add(user);
    }
}


