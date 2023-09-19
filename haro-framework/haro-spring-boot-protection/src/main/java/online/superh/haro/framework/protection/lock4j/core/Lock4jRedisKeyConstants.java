package online.superh.haro.framework.protection.lock4j.core;

/**
 * @version: 1.0
 * @author: haro
 * @description:
 * @date: 2023-09-19 11:16
 */
public interface Lock4jRedisKeyConstants {

    /**
     * 分布式锁
     * KEY 格式：lock4j:%s // 参数来自 DefaultLockKeyBuilder 类
     * VALUE 数据格式：HASH // RLock.class：Redisson 的 Lock 锁，使用 Hash 数据结构
     * 过期时间：不固定
     */
    String LOCK4J = "lock4j:%s";

}
