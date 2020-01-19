package cn.yqyzt.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @RequestMapping("/test")
    @ResponseBody
    public String hello(){
        int i = 1/0;
        return "hello mgr";
    }
}
