package com.liqinchun.knowledge.distributed.autoconfig;
import com.mongodb.client.MongoClient;
import net.javacrumbs.shedlock.core.LockProvider;
import net.javacrumbs.shedlock.provider.mongo.MongoLockProvider;
import net.javacrumbs.shedlock.spring.annotation.EnableSchedulerLock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.SchedulingConfiguration;

/**
 * @author liqinchun
 */
@Configuration
@EnableConfigurationProperties(NezhaShedLockProperties.class)
@EnableSchedulerLock(defaultLockAtMostFor = "PT10m")
@ConditionalOnBean(value = SchedulingConfiguration.class)
@AutoConfigureAfter(SchedulingConfiguration.class)
@ConditionalOnProperty("nezha.shedlock.enable")
public class ShedLockAutoConfiguration {

    @Autowired
    NezhaShedLockProperties nezhaShedLockProperties;
    @Value("${spring.application.name:shedLock}")
    private String appName;
    @Autowired
    ConfigurableApplicationContext context;

    @Bean(destroyMethod = "")
    public LockProvider lockProvider(MongoClient mongo) {
        context.getEnvironment().getProperty("spring.application.name");
        return new MongoLockProvider(mongo.getDatabase("schedule").getCollection(appName));
    }

}
