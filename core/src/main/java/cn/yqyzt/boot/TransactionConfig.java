package cn.yqyzt.boot;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 *@Author:shenhao on 2020/1/9 23:43
 *@Description: 事务配置 引入配置文件applicationContext-tx.xml，开启aop添加事务管理
 */
@EnableTransactionManagement
@ImportResource("classpath:applicationContext-tx.xml")
public class TransactionConfig {

    /**
     *@Author:shenhao on 2020/1/9 23:44
     *@param: DataSource
     *@return: PlatformTransactionManager
     *@Description: 配置配置文件需要的事务管理器transaction-manager到spring上下文中
     */
    @Bean
    public PlatformTransactionManager txManager(DataSource dataSource){
        DataSourceTransactionManager txManager = new DataSourceTransactionManager();
        txManager.setDataSource(dataSource);
        return txManager;
    }
}
