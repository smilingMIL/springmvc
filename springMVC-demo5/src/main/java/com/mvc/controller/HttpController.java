package com.mvc.controller;

import com.mvc.bean.User;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author smile
 */

/*@RestController注解
@RestController注解是springMVC提供的一个复合注解，标识在控制器的类上，
就相当于为类添加了@Controller注解，并且为其中的每个方法添加了@ResponseBody注解*/
@Controller
public class HttpController {


/*@RequestBody可以获取请求体，需要在控制器方法设置一个形参，
    使用@RequestBody进行标识，当前请求的请求体就会为当前注解所标识的形参赋值*/
    @RequestMapping("/testRequestBody")
    public String testRequestBody(@RequestBody String requestBody){
        System.out.println("requestBody:"+requestBody);
        return "success";
    }


/*RequestEntity封装请求报文的一种类型，需要在控制器方法的形参中设置该类型的形参，
    当前请求的请求报文就会赋值给该形参，可以通过getHeaders()获取请求头信息，通过getBody()获取请求体信息*/
    @RequestMapping("/testRequestEntity")
    public String testRequestEntity(RequestEntity<String> requestEntity){
        //当前requestEntity表示整个请求报文的信息
        System.out.println("请求头:"+requestEntity.getHeaders());
        System.out.println("请求体:"+requestEntity.getBody());
        return "success";
    }


    @RequestMapping("/testResponse")
    public String testResponse(HttpServletResponse response) throws IOException {
        response.getWriter().print("hello,Response");
        return null;
    }


/*@ResponseBody用于标识一个控制器方法，可以将该方法的返回值直接作为响应报文的响应体响应到浏览器*/
    @RequestMapping("/testResponseBody")
    @ResponseBody
    public String testResponseBody(){
        return "success2";
    }


    @RequestMapping("/testResponseUser")
    @ResponseBody
    public User testResponseUser(){
        return new User(1001,"xxx","123456",20,"男");
    }


    @RequestMapping("testAxios")
    @ResponseBody
    public String testAxios(String username,String password){
        System.out.println(username+","+password);
        return "hello,Axios";
    }


/*ResponseEntity用于控制器方法的返回值类型，该控制器方法的返回值就是响应到浏览器的响应报文*/

}
