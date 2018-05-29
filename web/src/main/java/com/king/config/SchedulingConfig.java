package com.king.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * 定时任务
 * @author wangchangyong
 * @create 2018/05/25 9:16
 */
@Configuration
public class SchedulingConfig {

    @Scheduled(cron = "0/5 * * * * ?") // 每5秒执行一次
    public void scheduler() {
        System.out.println(">>>>>>>>> SchedulingConfig execution....");
    }
}
