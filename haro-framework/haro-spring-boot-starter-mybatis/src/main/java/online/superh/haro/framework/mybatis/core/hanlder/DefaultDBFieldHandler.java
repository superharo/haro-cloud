package online.superh.haro.framework.mybatis.core.hanlder;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import online.superh.haro.framework.web.core.util.WebFrameworkUtils;
import org.apache.ibatis.reflection.MetaObject;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * @version: 1.0
 * @author: haro
 * @description:
 * 通用参数填充实现类：
 *             如果没有显式的对通用参数进行赋值，这里会对通用参数进行填充、赋值
 * @date: 2023-09-07 12:07
 */
public class DefaultDBFieldHandler implements MetaObjectHandler {


    @Override
    public void insertFill(MetaObject metaObject) {

    }

    @Override
    public void updateFill(MetaObject metaObject) {
        // 更新时间为空，则以当前时间为更新时间
        Object modifyTime = getFieldValByName("updateTime", metaObject);
        if (Objects.isNull(modifyTime)) {
            setFieldValByName("updateTime", LocalDateTime.now(), metaObject);
        }
        // 当前登录用户不为空，更新人为空，则当前登录用户为更新人
        Object modifier = getFieldValByName("updater", metaObject);
        Long userId = WebFrameworkUtils.getLoginUserId();
        if (Objects.nonNull(userId) && Objects.isNull(modifier)) {
            setFieldValByName("updater", userId.toString(), metaObject);
        }
    }
}
