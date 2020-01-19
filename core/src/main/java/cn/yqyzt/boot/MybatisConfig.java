package cn.yqyzt.boot;

import org.mybatis.spring.annotation.MapperScan;

/**
 *@Author:shenhao on 2020/1/9 23:42
 *@Description: mybatis 统一配置
 */
@MapperScan(value = {"cn.yqyzt.dao"})
public class MybatisConfig {
}
