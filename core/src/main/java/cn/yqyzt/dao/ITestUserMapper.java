package cn.yqyzt.dao;

import cn.yqyzt.domain.test.TestUserBean;

import java.util.List;

public interface ITestUserMapper {

    List<TestUserBean> queryAllTestUserList();

    void save(TestUserBean testUserBean);
}
