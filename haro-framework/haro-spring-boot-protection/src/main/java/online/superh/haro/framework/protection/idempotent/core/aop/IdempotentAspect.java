package online.superh.haro.framework.protection.idempotent.core.aop;

import lombok.extern.slf4j.Slf4j;
import online.superh.haro.framework.common.exception.ServiceException;
import online.superh.haro.framework.common.exception.enums.GlobalErrorCodeConstants;
import online.superh.haro.framework.common.util.collection.CollectionUtils;
import online.superh.haro.framework.protection.idempotent.core.annotation.Idempotent;
import online.superh.haro.framework.protection.idempotent.core.keyresolver.IdempotentKeyResolver;
import online.superh.haro.framework.protection.idempotent.core.redis.IdempotentRedisDAO;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Map;

/**
 * @version: 1.0
 * @author: haro
 * @description:
 * @date: 2023-09-19 10:53
 */
@Aspect
@Slf4j
public class IdempotentAspect {

    /**
     * IdempotentKeyResolver 集合
     */
    private final Map<Class<? extends IdempotentKeyResolver>, IdempotentKeyResolver> keyResolvers;

    private final IdempotentRedisDAO idempotentRedisDAO;

    public IdempotentAspect(List<IdempotentKeyResolver> keyResolvers, IdempotentRedisDAO idempotentRedisDAO) {
        this.keyResolvers = CollectionUtils.convertMap(keyResolvers, IdempotentKeyResolver::getClass);
        this.idempotentRedisDAO = idempotentRedisDAO;
    }

    @Before("@annotation(idempotent)")
    public void beforePointCut(JoinPoint joinPoint, Idempotent idempotent) {
        // 获得 IdempotentKeyResolver
        IdempotentKeyResolver keyResolver = keyResolvers.get(idempotent.keyResolver());
        Assert.notNull(keyResolver, "找不到对应的 IdempotentKeyResolver");
        // 解析 Key
        String key = keyResolver.resolver(joinPoint, idempotent);

        // 锁定 Key。
        boolean success = idempotentRedisDAO.setIfAbsent(key, idempotent.timeout(), idempotent.timeUnit());
        // 锁定失败，抛出异常
        if (!success) {
            log.info("[beforePointCut][方法({}) 参数({}) 存在重复请求]", joinPoint.getSignature().toString(), joinPoint.getArgs());
            throw new ServiceException(GlobalErrorCodeConstants.REPEATED_REQUESTS.getCode(), idempotent.message());
        }
    }


}
