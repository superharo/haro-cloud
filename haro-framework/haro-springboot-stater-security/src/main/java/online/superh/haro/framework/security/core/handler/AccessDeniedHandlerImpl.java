package online.superh.haro.framework.security.core.handler;

import lombok.extern.slf4j.Slf4j;
import online.superh.haro.framework.common.exception.enums.GlobalErrorCodeConstants;
import online.superh.haro.framework.common.pojo.CommonResult;
import online.superh.haro.framework.common.util.servlet.ServletUtils;
import online.superh.haro.framework.security.core.util.SecurityFrameworkUtils;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static online.superh.haro.framework.common.exception.enums.GlobalErrorCodeConstants.FORBIDDEN;

/**
 * @version: 1.0
 * @author: haro
 * @description:
 *  访问一个需要认证的 URL 资源，已经认证（登录）但是没有权限的情况下，返回 {@link GlobalErrorCodeConstants#FORBIDDEN} 错误码。
 * @date: 2023-09-05 18:10
 */
@Slf4j
public class AccessDeniedHandlerImpl implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        // 打印 warn 的原因是，不定期合并 warn，看看有没恶意破坏
        log.warn("[commence][访问 URL({}) 时，用户({}) 权限不够]", request.getRequestURI(), SecurityFrameworkUtils.getLoginUserId(), accessDeniedException);
        // 返回 403
        ServletUtils.writeJSON(response, CommonResult.error(FORBIDDEN));
    }
}
