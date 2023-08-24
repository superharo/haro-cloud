package online.superh.haro.framework.common.pojo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @version: 1.0
 * @author: haro
 * @description:
 * @date: 2023-08-24 15:47
 */
@Schema(description = "分页结果")
@Data
@AllArgsConstructor
public class PageResult<T> implements Serializable {

    @Schema(description = "数据", requiredMode = Schema.RequiredMode.REQUIRED)
    private List<T> list;

    @Schema(description = "总量", requiredMode = Schema.RequiredMode.REQUIRED)
    private Long total;


    public PageResult(Long total) {
        this.list = new ArrayList<>();
        this.total = total;
    }

}
