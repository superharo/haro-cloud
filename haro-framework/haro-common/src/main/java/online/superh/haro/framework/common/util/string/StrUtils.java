package online.superh.haro.framework.common.util.string;

import cn.hutool.core.util.StrUtil;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @version: 1.0
 * @author: haro
 * @description:
 * @date: 2023-09-08 15:06
 */
public class StrUtils {

    public static List<Long> splitToLong(String value, CharSequence separator) {
        long[] longs = StrUtil.splitToLong(value, separator);
        return Arrays.stream(longs).boxed().collect(Collectors.toList());
    }

    public static List<Integer> splitToInteger(String value, CharSequence separator) {
        int[] integers = StrUtil.splitToInt(value, separator);
        return Arrays.stream(integers).boxed().collect(Collectors.toList());
    }

}
