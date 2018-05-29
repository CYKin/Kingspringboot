package com.king;

import com.king.config.Config;
import com.king.utils.BaseMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableScheduling;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author wangchangyong
 * @create 2018/05/14 16:10
 *
 * @EnableScheduling 启动定时任务，作用是发现注解@Scheduled的任务并后台执行
 */
@SpringBootApplication
//@EnableScheduling
@MapperScan(basePackages = "com.king.mapper",markerInterface = BaseMapper.class)
@EnableConfigurationProperties({Config.class})
public class Application extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(Application.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}
