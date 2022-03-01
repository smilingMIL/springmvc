package com.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author smile
 */
@Controller

/*@RequestMapping标识一个类：设置映射请求的请求路径的初始信息
@RequestMapping标识一个方法：设置映射请求请求路径的具体信息*/
//@RequestMapping("/hello")
public class RequestMappingController {

/*@RequestMapping注解的method属性
    @RequestMapping注解的method属性通过请求的请求方式（get或post）匹配请求映射
    @RequestMapping注解的method属性是一个RequestMethod类型的数组，表示该请求映射能够匹配多种请求方式的请求
    若当前请求的请求地址满足请求映射的value属性，但是请求方式不满足method属性，则浏览器报错405：Request method 'POST' not supported*/
    @RequestMapping(
            value = {"/testRequestMapping","/test"},
            method = {RequestMethod.GET,RequestMethod.POST}
    )
    public String success(){
        return "success";
    }

/*1、对于处理指定请求方式的控制器方法，SpringMVC中提供了@RequestMapping的派生注解
    处理get请求的映射-->@GetMapping
    处理post请求的映射-->@PostMapping
    处理put请求的映射-->@PutMapping
    处理delete请求的映射-->@DeleteMapping*/
    @GetMapping("/testGetMapping")
    public String testGetMapping(){
        return "success";
    }

    @RequestMapping(value = "/testPut",method = RequestMethod.PUT)
    public String testPut(){
        return "success";
    }


/*@RequestMapping注解的params属性（了解）
    @RequestMapping注解的params属性通过请求的请求参数匹配请求映射
    @RequestMapping注解的params属性是一个字符串类型的数组，可以通过四种表达式设置请求参数和请求映射的匹配关系
    "param"：要求请求映射所匹配的请求必须携带param请求参数
    "!param"：要求请求映射所匹配的请求必须不能携带param请求参数
    "param=value"：要求请求映射所匹配的请求必须携带param请求参数且param=value
    "param!=value"：要求请求映射所匹配的请求必须携带param请求参数但是param!=value*/

/*@RequestMapping注解的headers属性（了解）
    @RequestMapping注解的headers属性通过请求的请求头信息匹配请求映射
    @RequestMapping注解的headers属性是一个字符串类型的数组，可以通过四种表达式设置请求头信息和请求映射的匹配关系
    "header"：要求请求映射所匹配的请求必须携带header请求头信息
    "!header"：要求请求映射所匹配的请求必须不能携带header请求头信息
    "header=value"：要求请求映射所匹配的请求必须携带header请求头信息且header=value
    "header!=value"：要求请求映射所匹配的请求必须携带header请求头信息且header!=value
    若当前请求满足@RequestMapping注解的value和method属性，但是不满足headers属性，此时页面显示404错误，即资源未找到*/
    @RequestMapping(value = "/testParamsAndHeaders",
            params = {"username"},
            headers = {"Host=localhost:8080"}
            )
    public String testParamsAndHeaders(){
        return "success";
    }


//SpringMVC支持ant风格的路径
//    ？：表示任意的单个字符
//    *：表示任意的0个或多个字符
//    **：表示任意的一层或多层目录
//    注意：在使用**时，只能使用"/**/xxx"的方式

//    @RequestMapping("/a?a/testAnt")
//    @RequestMapping("/a*a/testAnt")
    @RequestMapping("/**/testAnt")
    public String testAnt(){
        return "success";
    }


/*SpringMVC支持路径中的占位符（重点）
    原始方式：/deleteUser?id=1
    rest方式：/deleteUser/1
    SpringMVC路径中的占位符常用于RESTful风格中，当请求路径中将某些数据通过路径的方式传输到服务器中，
    就可以在相应的@RequestMapping注解的value属性中通过占位符{xxx}表示传输的数据，
    在通过@PathVariable注解，将占位符所表示的数据赋值给控制器方法的形参*/
    @RequestMapping("/testPath/{id}")
    public String testPath(@PathVariable("id")Integer id){
        System.out.println("id:"+id);
        return "success";
    }
}
