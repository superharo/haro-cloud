package online.superh.haro.framework.common.exception;

import lombok.Data;

/**
 * @version: 1.0
 * @author: haro
 * @description: 服务器异常
 * @date: 2023-08-24 15:07
 */
@Data
public class ServerException extends RuntimeException{


    private Integer code;


    private String message;


    public ServerException(ErrorCode errorCode) {
        this.code = errorCode.getCode();
        this.message = errorCode.getMsg();
    }

    public ServerException(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

}
