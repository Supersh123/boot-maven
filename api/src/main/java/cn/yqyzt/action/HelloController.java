package cn.yqyzt.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

    @RequestMapping("/index")
    public ModelAndView index(ModelAndView mav){
        mav.setViewName("index");
        mav.addObject("title","测试thymeleaf");
        mav.addObject("name","Api-毕加索");
        return mav;
    }
}
