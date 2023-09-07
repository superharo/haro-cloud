package online.superh.haro.framework.common.exception;

import lombok.Data;

/**
 * @version: 1.0
 * @author: haro
 * @description: 业务逻辑异常
 * @date: 2023-08-24 15:06
 */
@Data
public class ServiceException extends RuntimeException{

    private Integer code;


    private String message;


    public ServiceException(ErrorCode errorCode) {
        this.code = errorCode.getCode();
        this.message = errorCode.getMsg();
    }

    public ServiceException(Integer code, String message) {
        this.code = code;
        this.message = message;
    }


}
