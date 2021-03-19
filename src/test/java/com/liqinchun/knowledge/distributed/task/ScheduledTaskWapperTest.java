package com.liqinchun.knowledge.distributed.task;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ScheduledTaskWapperTest {

    @Autowired
    ScheduledTask scheduledTask;

    @Test
    public void printCurrentTime() throws InterruptedException {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5,10,20, TimeUnit.SECONDS,new LinkedBlockingQueue<>());
        for (int i = 0;i <100 ;i++ ){
            executor.submit(new ScheduledTaskWapper(scheduledTask));
        }
        while (executor.getCompletedTaskCount()<100) {
            System.out.println("线程池已完成任务"+executor.getCompletedTaskCount());
            Thread.sleep(3000);
        }
    }

}