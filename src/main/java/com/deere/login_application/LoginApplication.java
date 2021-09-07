package com.deere.login_application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

/*
    Identify behaviour : User account
    Identify test case scnearios based on ZOMBIE -> zero/one/multiple outputs, Boundary behaviours, Interface definition, Exception handling
 */
@SpringBootApplication
public class LoginApplication {

    public static void main(String[] args) {

        System.out.println("Enter username : ");
        Scanner sc = new Scanner(System.in);
        String userName = sc.next();

        System.out.println("Enter Password : ");
        String password = sc.next();

        UserService userService = new UserService();
        String message = userService.create(userName, password);
        System.out.println(message);

        System.out.println("Try logging in");
        System.out.println("Enter username : ");
        String userName1 = sc.next();

        System.out.println("Enter Password : ");
        String password1 = sc.next();

        LoginService loginService = new LoginService();
        String loginMessage = loginService.login(userName1, password1);
        System.out.println(loginMessage);



    }

}
