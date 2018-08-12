package com.example.springboottask.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

//定时任务
@Service
public class ScheduledService {

    /*
    * second,minute,hour,day of month,month,day of week
    *
    * */
//    @Scheduled(cron = "0 * * * * MON-SAT")
//    @Scheduled(cron = "0,1,2,3,4 * * * * MON-SAT")
//    @Scheduled(cron = "0-4 * * * * MON-SAT")
//    @Scheduled(cron = "0/4 * * * * MON-SAT") //每4秒执行一次
    public void hello(){
        System.out.println("hello...");
    }
}
