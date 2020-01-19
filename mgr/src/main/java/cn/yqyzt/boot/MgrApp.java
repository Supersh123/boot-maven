package cn.yqyzt.boot;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

/**
 *@Author:shenhao on 2020/1/9 23:42
 *@Description: main
 */
@SpringBootApplication
@Import({MybatisConfig.class})
@ComponentScan(basePackages = {"cn.yqyzt.action","cn.yqyzt.enhance","cn.yqyzt.service.impl"})
@Slf4j
public class MgrApp
{

    /**
     *@Author:shenhao on 2020/1/10 0:07
     *@Description: MgrApp启动方法
     */
    public static void main( String[] args )
    {
        SpringApplication application = new SpringApplication(MgrApp.class);
        //application.setBannerMode(Banner.Mode.OFF);
        application.run(args);
        log.info("MgrApp has started!");
    }
}
