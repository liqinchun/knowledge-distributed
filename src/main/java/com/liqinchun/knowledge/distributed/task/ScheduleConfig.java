package com.liqinchun.knowledge.distributed.task;

import com.mongodb.client.MongoClient;
import net.javacrumbs.shedlock.core.LockProvider;
import net.javacrumbs.shedlock.provider.mongo.MongoLockProvider;
import net.javacrumbs.shedlock.provider.redis.spring.RedisLockProvider;
import net.javacrumbs.shedlock.spring.annotation.EnableSchedulerLock;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.AdviceMode;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.annotation.PreDestroy;

import static net.javacrumbs.shedlock.spring.annotation.EnableSchedulerLock.InterceptMode.PROXY_SCHEDULER;

//@Configuration
//@EnableScheduling
//@EnableSchedulerLock(defaultLockAtMostFor = "10m")
public class ScheduleConfig {


//    @Bean
//    public LockProvider lockProvider(RedisConnectionFactory connectionFactory) {
//        return new RedisLockProvider(connectionFactory);
//    }


    @Bean(destroyMethod = "")
    public LockProvider lockProvider(MongoClient mongo) {

        return new MongoLockProvider(mongo.getDatabase("nmonos"));
    }

    public void lockProviderDestroy() {

    }
}
