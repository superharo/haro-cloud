package online.superh.haro.framework.security.core.aop;

import lombok.extern.slf4j.Slf4j;
import online.superh.haro.framework.common.exception.ServiceException;
import online.superh.haro.framework.security.core.annotations.PreAuthenticated;
import online.superh.haro.framework.security.core.util.SecurityFrameworkUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import static online.superh.haro.framework.common.exception.enums.GlobalErrorCodeConstants.UNAUTHORIZED;

/**
 * @version: 1.0
 * @author: haro
 * @description:
 * @date: 2023-09-05 17:25
 */
@Aspect
@Slf4j
public class PreAuthenticatedAspect {

    @Around("@annotation(preAuthenticated)")
    public Object around(ProceedingJoinPoint joinPoint, PreAuthenticated preAuthenticated) throws Throwable {
        if (SecurityFrameworkUtils.getLoginUser() == null) {
            throw new ServiceException(UNAUTHORIZED);
        }
        return joinPoint.proceed();
    }

}
