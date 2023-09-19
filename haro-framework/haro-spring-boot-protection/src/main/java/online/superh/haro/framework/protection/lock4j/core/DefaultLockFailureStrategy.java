package online.superh.haro.framework.protection.lock4j.core;

import com.baomidou.lock.LockFailureStrategy;
import lombok.extern.slf4j.Slf4j;
import online.superh.haro.framework.common.exception.ServiceException;
import online.superh.haro.framework.common.exception.enums.GlobalErrorCodeConstants;

import java.lang.reflect.Method;

/**
 * @version: 1.0
 * @author: haro
 * @description:
 *          自定义获取锁失败策略，抛出 {@link ServiceException} 异常
 * @date: 2023-09-19 11:17
 */
@Slf4j
public class DefaultLockFailureStrategy  implements LockFailureStrategy {

    @Override
    public void onLockFailure(String key, Method method, Object[] arguments) {
        log.debug("[onLockFailure][线程:{} 获取锁失败，key:{} 获取失败:{} ]", Thread.currentThread().getName(), key, arguments);
        throw new ServiceException(GlobalErrorCodeConstants.LOCKED);
    }

}
