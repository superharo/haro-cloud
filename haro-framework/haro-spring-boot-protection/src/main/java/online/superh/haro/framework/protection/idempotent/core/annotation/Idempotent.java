package online.superh.haro.framework.protection.idempotent.core.annotation;

import online.superh.haro.framework.protection.idempotent.core.keyresolver.IdempotentKeyResolver;
import online.superh.haro.framework.protection.idempotent.core.keyresolver.impl.DefaultIdempotentKeyResolver;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.concurrent.TimeUnit;

/**
 * @version: 1.0
 * @author: haro
 * @description: 幂等注解
 * @date: 2023-09-19 10:28
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Idempotent {

    /**
     * 幂等的超时时间，默认为 1 秒
     * 注意，如果执行时间超过它，请求还是会进来
     */
    int timeout() default 1;

    /**
     * 时间单位，默认为 SECONDS 秒
     */
    TimeUnit timeUnit() default TimeUnit.SECONDS;

    /**
     * 提示信息，正在执行中的提示
     */
    String message() default "重复请求，请稍后重试";

    /**
     * 使用的 Key 解析器
     */
    Class<? extends IdempotentKeyResolver> keyResolver() default DefaultIdempotentKeyResolver.class;
    /**
     * 使用的 Key 参数
     */
    String keyArg() default "";




}
