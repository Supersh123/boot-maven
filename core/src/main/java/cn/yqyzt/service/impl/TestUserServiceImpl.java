package cn.yqyzt.service.impl;


import cn.yqyzt.dao.ITestUserMapper;
import cn.yqyzt.domain.test.TestUserBean;
import cn.yqyzt.service.ITestUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TestUserServiceImpl implements ITestUserService {

    @Resource
    private ITestUserMapper testUserMapper;

    @Resource
    private RedisTemplate<Object,Object> redisTemplate;

    @Override
    public List<TestUserBean> queryAllTestUserList() {
        //字符串的序列化器
        StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
        redisTemplate.setKeySerializer(stringRedisSerializer);
        //高并发下会有缓存穿透的问题，导致大批量请求没查到redis结果而直接下一步查询数据库
        List<TestUserBean> list = (List<TestUserBean>)redisTemplate.opsForValue().get("userList");
        if(list!=null){
            return list;
        }
        list = testUserMapper.queryAllTestUserList();
        if(list!=null && list.size()>=1){
            redisTemplate.opsForValue().set("userList",list);
        }
        return list;
    }

    @Override
    public void save(TestUserBean testUserBean) {
        testUserMapper.save(testUserBean);
        int i = 1/0;
    }
}
