package com.liqinchun.knowledge.distributed.autoconfig;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author liqinchun
 */
@Data
@ConfigurationProperties("nezha.shedlock")
public class NezhaShedLockProperties {
    boolean enable = true;
}
