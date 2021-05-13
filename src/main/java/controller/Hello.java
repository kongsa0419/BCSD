package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Hello {

    @ResponseBody
    @RequestMapping(value = "/hello")
    public String responseHello(){
        return "hello, world!!!!!!!";
    }
}
