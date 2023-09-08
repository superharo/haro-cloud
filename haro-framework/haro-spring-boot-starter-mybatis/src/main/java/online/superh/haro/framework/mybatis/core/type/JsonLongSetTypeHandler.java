package online.superh.haro.framework.mybatis.core.type;

import com.baomidou.mybatisplus.extension.handlers.AbstractJsonTypeHandler;
import com.fasterxml.jackson.core.type.TypeReference;
import online.superh.haro.framework.common.util.json.JsonUtils;

import java.util.Set;

/**
 * @version: 1.0
 * @author: haro
 * @description:
 *          在我们将字符串反序列化为 Set 并且泛型为 Long 时，如果每个元素的数值太小，会被处理成 Integer 类型，导致可能存在隐性的 BUG。
 * @date: 2023-09-08 15:09
 */
public class JsonLongSetTypeHandler extends AbstractJsonTypeHandler<Object> {

    private static final TypeReference<Set<Long>> TYPE_REFERENCE = new TypeReference<Set<Long>>(){};
    @Override
    protected Object parse(String json) {
        return JsonUtils.parseObject(json, TYPE_REFERENCE);
    }

    @Override
    protected String toJson(Object obj) {
        return JsonUtils.toJsonString(obj);
    }
}
