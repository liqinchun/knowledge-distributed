package com.liqinchun.knowledge.distributed;

import com.liqinchun.knowledge.distributed.autoconfig.ShedLockAutoConfiguration;
import com.liqinchun.knowledge.distributed.task.ScheduledTask;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.FilterType;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class KnowledgeDistributedApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context =
                SpringApplication.run(KnowledgeDistributedApplication.class, args);

        System.out.println(context);

    }

}
