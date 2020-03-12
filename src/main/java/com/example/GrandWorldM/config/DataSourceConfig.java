package com.example.GrandWorldM.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSourceConfig {

//    @Value("${spring.dataSource.druid.driver}")
//    private String driver;
//
//    @Value("${spring.dataSource.druid.url}")
//    private String url;
//
//    @Value("${spring.dataSource.druid.username}")
//    private String username;
//
//    @Value("${spring.dataSource.druid.password}")
//    private String password;


    @Bean("dataSource")
    @ConfigurationProperties("spring.datasource.druid")
    public DruidDataSource druidDataSource(){
        DruidDataSource dataSource = new DruidDataSource();
//        dataSource.setDriverClassName(driver);
        return dataSource;
    }
}
