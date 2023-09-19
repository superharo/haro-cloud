package online.superh.haro.framework.protection.idempotent.core.keyresolver.impl;

import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;
import online.superh.haro.framework.protection.idempotent.core.annotation.Idempotent;
import online.superh.haro.framework.protection.idempotent.core.keyresolver.IdempotentKeyResolver;
import org.aspectj.lang.JoinPoint;

/**
 * @version: 1.0
 * @author: haro
 * @description:
 *      默认幂等 Key 解析器，使用方法名 + 方法参数，组装成一个 Key,为了避免 Key 过长，使用 MD5 进行“压缩”
 * @date: 2023-09-19 10:36
 */
public class DefaultIdempotentKeyResolver implements IdempotentKeyResolver {


    /**
     * 解析一个 Key
     *
     * @param joinPoint  AOP 切面
     * @param idempotent 幂等注解
     * @return Key
     */
    @Override
    public String resolver(JoinPoint joinPoint, Idempotent idempotent) {
        String methodName = joinPoint.getSignature().toString();
        String argsStr = StrUtil.join(",", joinPoint.getArgs());
        return SecureUtil.md5(methodName + argsStr);
    }

}
