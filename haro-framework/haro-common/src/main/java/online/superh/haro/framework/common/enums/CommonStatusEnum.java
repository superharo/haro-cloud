package online.superh.haro.framework.common.enums;


import lombok.AllArgsConstructor;
import lombok.Getter;
import online.superh.haro.framework.common.core.IntArrayValuable;

import java.util.Arrays;

/**
 * @version: 1.0
 * @author: haro
 * @description:
 * @date: 2023-08-24 14:53
 */

@Getter
@AllArgsConstructor
public enum CommonStatusEnum implements IntArrayValuable {

    ENABLE(0, "开启"),
    DISABLE(1, "关闭");

    /**
     * 状态值
     */
    private final Integer status;

    /**
     * 状态名
     */
    private final String name;


    public static final int[] ARRAYS = Arrays.stream(values()).mapToInt(CommonStatusEnum::getStatus).toArray();

    /**
     * @return int 数组
     */
    @Override
    public int[] array() {
        return ARRAYS;
    }
}
