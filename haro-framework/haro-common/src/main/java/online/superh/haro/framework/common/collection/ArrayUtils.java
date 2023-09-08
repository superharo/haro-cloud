package online.superh.haro.framework.common.collection;

/**
 * @version: 1.0
 * @author: haro
 * @description:
 * @date: 2023-09-07 16:43
 */
public class ArrayUtils {

    public static <T> T get(T[] array, int index) {
        if (null == array || index >= array.length) {
            return null;
        }
        return array[index];
    }

}
