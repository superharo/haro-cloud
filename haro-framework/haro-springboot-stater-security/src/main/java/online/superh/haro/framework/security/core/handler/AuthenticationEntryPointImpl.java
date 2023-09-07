package online.superh.haro.framework.security.core.handler;

import lombok.extern.slf4j.Slf4j;
import online.superh.haro.framework.common.pojo.CommonResult;
import online.superh.haro.framework.common.util.servlet.ServletUtils;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static online.superh.haro.framework.common.exception.enums.GlobalErrorCodeConstants.UNAUTHORIZED;

/**
 * @version: 1.0
 * @author: haro
 * @description:
 * @date: 2023-09-05 18:12
 */
@Slf4j
public class AuthenticationEntryPointImpl implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) {
        log.debug("[commence][访问 URL({}) 时，没有登录]", request.getRequestURI(), e);
        // 返回 401
        ServletUtils.writeJSON(response, CommonResult.error(UNAUTHORIZED));
    }

}
