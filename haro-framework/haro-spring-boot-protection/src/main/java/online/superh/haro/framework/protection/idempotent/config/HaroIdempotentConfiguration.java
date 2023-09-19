package online.superh.haro.framework.protection.idempotent.config;

import online.superh.haro.framework.protection.idempotent.core.aop.IdempotentAspect;
import online.superh.haro.framework.protection.idempotent.core.keyresolver.IdempotentKeyResolver;
import online.superh.haro.framework.protection.idempotent.core.keyresolver.impl.DefaultIdempotentKeyResolver;
import online.superh.haro.framework.protection.idempotent.core.keyresolver.impl.ExpressionIdempotentKeyResolver;
import online.superh.haro.framework.protection.idempotent.core.redis.IdempotentRedisDAO;
import online.superh.haro.framework.redis.config.HaroRedisAutoConfiguration;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.List;

/**
 * @version: 1.0
 * @author: haro
 * @description:
 * @date: 2023-09-19 11:10
 */
@AutoConfiguration(after = HaroRedisAutoConfiguration.class)
public class HaroIdempotentConfiguration {

    @Bean
    public IdempotentAspect idempotentAspect(List<IdempotentKeyResolver> keyResolvers, IdempotentRedisDAO idempotentRedisDAO) {
        return new IdempotentAspect(keyResolvers, idempotentRedisDAO);
    }

    @Bean
    public IdempotentRedisDAO idempotentRedisDAO(StringRedisTemplate stringRedisTemplate) {
        return new IdempotentRedisDAO(stringRedisTemplate);
    }

    // ========== 各种 IdempotentKeyResolver Bean ==========

    @Bean
    public DefaultIdempotentKeyResolver defaultIdempotentKeyResolver() {
        return new DefaultIdempotentKeyResolver();
    }

    @Bean
    public ExpressionIdempotentKeyResolver expressionIdempotentKeyResolver() {
        return new ExpressionIdempotentKeyResolver();
    }

}
