package online.superh.haro.framework.protection.idempotent.core.keyresolver;

import online.superh.haro.framework.protection.idempotent.core.annotation.Idempotent;
import org.aspectj.lang.JoinPoint;

/**
 * @version: 1.0
 * @author: haro
 * @description:  幂等 Key 解析器接口
 * @date: 2023-09-19 10:34
 */
public interface IdempotentKeyResolver {

    /**
     * 解析一个 Key
     *
     * @param idempotent 幂等注解
     * @param joinPoint  AOP 切面
     * @return Key
     */
    String resolver(JoinPoint joinPoint, Idempotent idempotent);

}
