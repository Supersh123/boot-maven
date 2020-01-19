package cn.yqyzt.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

    @RequestMapping("/test")
    @ResponseBody
    public String hello(){
        return "hello web";
    }

    @RequestMapping("/index")
    public ModelAndView index(ModelAndView mav){
        mav.setViewName("index");
        mav.addObject("title","测试thymeleaf");
        mav.addObject("name","蒙娜丽莎");
        return mav;
    }
}
