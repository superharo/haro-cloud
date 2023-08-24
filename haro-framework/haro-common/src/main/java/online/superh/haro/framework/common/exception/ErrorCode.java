package online.superh.haro.framework.common.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @version: 1.0
 * @author: haro
 * @description: 错误码
 * @date: 2023-08-24 15:04
 */
@Data
@AllArgsConstructor
public class ErrorCode {

    private final Integer code;

    private final String msg;

}
