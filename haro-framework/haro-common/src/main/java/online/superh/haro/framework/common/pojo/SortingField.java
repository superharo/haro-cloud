package online.superh.haro.framework.common.pojo;

import java.io.Serializable;

/**
 * @version: 1.0
 * @author: haro
 * @description:
 *          类名加了 ing 的原因是，避免和 ES SortField 重名
 * @date: 2023-09-07 16:17
 */
public class SortingField implements Serializable {

    /**
     * 顺序 - 升序
     */
    public static final String ORDER_ASC = "asc";
    /**
     * 顺序 - 降序
     */
    public static final String ORDER_DESC = "desc";

    /**
     * 字段
     */
    private String field;
    /**
     * 顺序
     */
    private String order;

    // 空构造方法，解决反序列化
    public SortingField() {
    }

    public SortingField(String field, String order) {
        this.field = field;
        this.order = order;
    }

    public String getField() {
        return field;
    }

    public SortingField setField(String field) {
        this.field = field;
        return this;
    }

    public String getOrder() {
        return order;
    }

    public SortingField setOrder(String order) {
        this.order = order;
        return this;
    }

}
