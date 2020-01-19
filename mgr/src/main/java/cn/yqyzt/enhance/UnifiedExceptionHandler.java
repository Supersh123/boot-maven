package cn.yqyzt.enhance;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.HandlerMethod;

/**
 * @author shenhao on 2020-01-09 23:32:00
 * @Description:统一异常处理增强处理
 */
@ControllerAdvice
@Slf4j
public class UnifiedExceptionHandler {

    /**
     *@Author:shenhao on 2020/1/9 23:34
     *@Description: 统一异常处理
     */
    @ExceptionHandler
    public void ExceptionHandler(Exception ex, HandlerMethod handlerMethod){
        log.error("统一异常处理: {} | {} |{}",String.valueOf(handlerMethod.getBean().getClass()),handlerMethod.getMethod().getName(),ex.getMessage());
        ex.printStackTrace();
    }

}
