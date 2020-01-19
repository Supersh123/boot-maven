package cn.yqyzt.boot;

import cn.yqyzt.interceptors.TestInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 *@Author:shenhao on 2020/1/9 23:41
 *@Description: main
 */
@SpringBootApplication
@Import({MybatisConfig.class,WebMvcConfig.class})
@ComponentScan(basePackages = {"cn.yqyzt.action","cn.yqyzt.enhance","cn.yqyzt.service.impl"})
@Slf4j
public class WebApp {

    /**
     *@Author:shenhao on 2020/1/10 0:06
     *@Description: WebApp启动方法
     */
    public static void main( String[] args )
    {
        SpringApplication application = new SpringApplication(WebApp.class);
        //application.setBannerMode(Banner.Mode.OFF);
        application.run(args);
        log.info("WebApp has started!");
    }
}
