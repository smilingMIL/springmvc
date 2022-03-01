package com.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author smile
 */
@Controller
public class UserController {

    /**
     * 使用RESTFul模拟用户资源的增删改查
     * /users        GET    查询所有用户信息
     * /user/1      GET    根据用户ID查询用户信息
     * /user        POST   添加用户信息
     * /user/1      DELETE 根据ID删除用户信息
     * /user        PUT   更新用户信息
     */


    /*/users        GET    查询所有用户信息*/
    @RequestMapping(value = "/users",method = RequestMethod.GET)
    public String getAllUser(){
        System.out.println("查询所有用户信息");
        return "success";
    }


    @RequestMapping(value = "/user/{id}",method = RequestMethod.GET)
    public String getUserById(){
        System.out.println("根据ID查询信息");
        return "success";
    }

    @RequestMapping(value = "user",method = RequestMethod.POST)
    public String insertUser(String username,String password){
        System.out.println("添加用户信息："+username+","+password);
        return "success";
    }

    @RequestMapping(value = "/user",method = RequestMethod.PUT)
    public String updateUser(String username,String password){
        System.out.println("更新用户信息："+username+","+password);
        return "success";
    }


}
