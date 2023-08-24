package online.superh.haro.framework.common.pojo;

import lombok.Data;
import online.superh.haro.framework.common.exception.ErrorCode;
import online.superh.haro.framework.common.exception.enums.GlobalErrorCodeConstants;
import org.springframework.util.Assert;

import java.io.Serializable;

/**
 * @version: 1.0
 * @author: haro
 * @description: 通用返回
 * @date: 2023-08-24 15:18
 */
@Data
public class CommonResult<T> implements Serializable {

    private  Integer  code;

    private String msg;

    private T data;


    public static <T> CommonResult<T> error(Integer code, String message) {
        Assert.isTrue(!GlobalErrorCodeConstants.SUCCESS.getCode().equals(code), "code 必须是错误的！");
        CommonResult<T> result = new CommonResult<>();
        result.code = code;
        result.msg = message;
        return result;
    }

    public static <T> CommonResult<T> error(ErrorCode errorCode) {
        return error(errorCode.getCode(), errorCode.getMsg());
    }

    public static <T> CommonResult<T> success(T data) {
        CommonResult<T> result = new CommonResult<>();
        result.code = GlobalErrorCodeConstants.SUCCESS.getCode();
        result.data = data;
        result.msg = GlobalErrorCodeConstants.SUCCESS.getMsg();
        return result;
    }

}
