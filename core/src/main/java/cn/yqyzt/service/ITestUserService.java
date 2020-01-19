package cn.yqyzt.service;


import cn.yqyzt.domain.test.TestUserBean;

import java.util.List;

public interface ITestUserService {

    List<TestUserBean> queryAllTestUserList();

    void save(TestUserBean testUserBean);
}
