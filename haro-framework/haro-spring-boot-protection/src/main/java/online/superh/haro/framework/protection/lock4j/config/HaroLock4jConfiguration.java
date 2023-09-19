package online.superh.haro.framework.protection.lock4j.config;

import com.baomidou.lock.spring.boot.autoconfigure.LockAutoConfiguration;
import online.superh.haro.framework.protection.lock4j.core.DefaultLockFailureStrategy;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;

/**
 * @version: 1.0
 * @author: haro
 * @description:
 * @date: 2023-09-19 11:20
 */
@AutoConfiguration(before = LockAutoConfiguration.class)
public class HaroLock4jConfiguration {

    @Bean
    public DefaultLockFailureStrategy lockFailureStrategy() {
        return new DefaultLockFailureStrategy();
    }

}
