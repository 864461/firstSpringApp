package com.todoapplication.myfirstwebapp;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {



    @RequestMapping("/say-hello")
    @ResponseBody
    public String sayHello(){
        return "Hello what are you learning today?";

    }

    @RequestMapping("/say-hello-html")
    @ResponseBody
    public String sayHelloHtml(){
        StringBuffer sb =  new StringBuffer();
        sb.append("<html>");
        sb.append("<head>");
        sb.append("<title> My first spring title</title>");
        sb.append("</head>");
        sb.append("<body>");
        sb.append("My first htm page in spring");
        sb.append("</body>");
        sb.append("</html>");


        return sb.toString();

    }

//    jsp


    @RequestMapping("/say-hello-jsp")
    public String sayHelloJsp(){
        return "sayHello";

    }
}
