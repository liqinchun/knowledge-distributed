package com.liqinchun.knowledge.distributed.task;

import net.javacrumbs.shedlock.core.LockAssert;
import net.javacrumbs.shedlock.spring.annotation.EnableSchedulerLock;
import net.javacrumbs.shedlock.spring.annotation.SchedulerLock;
import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Component
public class ScheduledTask {

    @Scheduled(cron = "*/5 * * * * MON-FRI")
    @SchedulerLock(name = "printCurrentTimes")
    public void printCurrentTime() throws InterruptedException {
        LockAssert.assertLocked();
        System.out.println(new Date());
        Thread.sleep(6000);
    }


}
