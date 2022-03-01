package com.mvc.controller;

import com.mvc.bean.User;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Arrays;

/**
 * @author smile
 */
@Controller
public class ParamController {
/*解决POST获取请求参数的乱码问题
    解决获取请求参数的乱码问题，可以使用SpringMVC提供的编码过滤器CharacterEncodingFilter，但是必须在web.xml中进行注册*/


/*通过ServletAPI获取
    将HttpServletRequest作为控制器方法的形参，此时HttpServletRequest类型的参数表示封装了当前请求的请求报文的对象*/
    @RequestMapping("/testServletAPI")
    //形参位置request表示当前请求
    public String testServletAPI(HttpServletRequest request){
        HttpSession session = request.getSession();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("username="+username+","+"password="+password);
        return "success";
    }


/*通过控制器方法的形参获取请求参数
    在控制器方法的形参位置，设置和请求参数同名的形参，
    当浏览器发送请求，匹配到请求映射时，在DispatcherServlet中就会将请求参数赋值给相应的形参*/
    @RequestMapping("/testParam")
    public String testParam(
/*@RequestParam
    @RequestParam是将请求参数和控制器方法的形参创建映射关系
    @RequestParam注解一共有三个属性：
    1.value：指定为形参赋值的请求参数的参数名
    2.required：设置是否必须传输此请求参数，默认值为true
    若设置为true时，则当前请求必须传输value所指定的请求参数，若没有传输该请求参数，且没有设置defaultValue属性，则页面报错400：Required String parameter 'xxx' is not present；
    若设置为false，则当前请求不是必须传输value所指定的请求参数，若没有传输，则注解所标识的形参的值为null
    3.defaultValue：不管required属性值为true或false，当value所指定的请求参数没有传输或传输的值为""时，则使用默认值为形参赋值*/
            @RequestParam(value = "username",required = true,defaultValue = "abc") String username,
            String password,
            String[] hobby,
/*@RequestHeader
    @RequestHeader是将请求头信息和控制器方法的形参创建映射关系
    @RequestHeader注解一共有三个属性：value、required、defaultValue，用法同@RequestParam*/
            @RequestHeader(value = "Host",required = true) String host,
/*@CookieValue
    @CookieValue是将cookie数据和控制器方法的形参创建映射关系
    @CookieValue注解一共有三个属性：value、required、defaultValue，用法同@RequestParam*/
            @CookieValue(value = "JSESSIONID",required = true) String JSESSIONID){
        //如果请求参数出现多个同名的请求参数，可以在控制器方法的形参位置设置字符串类型或字符串数组接收此请求参数
        //如果使用字符串类型的形参，最终结果为请求参数的每一个值之间使用逗号进行拼接
        System.out.println("username="+username+","+"password="+password+","+"hobby="+ Arrays.toString(hobby));
        System.out.println("Host="+host);
        System.out.println("JSESSIONID="+JSESSIONID);
        return "success";
    }



/*通过POJO获取请求参数
    可以在控制器方法的形参位置设置一个实体类类型的形参，
    此时若浏览器传输的请求参数的参数名和实体类中的属性名一致，那么请求参数就会为此属性赋值*/
    @RequestMapping("/testBean")
    public String testBean(User user){
        System.out.println(user);
        return "success";
    }
}
