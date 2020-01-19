package cn.yqyzt.action;


import cn.yqyzt.domain.test.TestUserBean;
import cn.yqyzt.service.ITestUserService;
import cn.yqyzt.utils.HttpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/test/user")
public class TestUserController {

    @Autowired
    private ITestUserService testUserService;

    @RequestMapping("/list")
    @ResponseBody
    public List<TestUserBean> list(){
        return testUserService.queryAllTestUserList();
    }

    @RequestMapping("/save")
    @ResponseBody
    public String  save(){
        testUserService.save(new TestUserBean());
        return "保存成功!";
    }

    @RequestMapping("/req")
    @ResponseBody
    public String req(){
        Map<String,String> paramsMap = new HashMap<>();
        paramsMap.put("province","北京");
        paramsMap.put("city","北京市");
        paramsMap.put("district","东城区");
        paramsMap.put("address","测试地址不发货");
        String resp = HttpUtil.send("https://shop.xwtec.cn/tmall/queryAddress/qgjpVld","POST",paramsMap);
        return resp;
    }
}
