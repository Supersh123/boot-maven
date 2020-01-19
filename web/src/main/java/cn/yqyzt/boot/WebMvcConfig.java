package cn.yqyzt.boot;

import cn.yqyzt.interceptors.TestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author by shenhao on 2020/1/11
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(testInterceptor()).addPathPatterns("/*");
    }

    @Bean
    public TestInterceptor testInterceptor(){
        return new TestInterceptor();
    }

}
