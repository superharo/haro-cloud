package online.superh.haro.framework.security.config;

import org.springframework.core.Ordered;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;

/**
 * @version: 1.0
 * @author: haro
 * @description: 自定义的 URL 的安全配置
 * @date: 2023-09-06 11:25
 */
public abstract class AuthorizeRequestsCustomizer  implements Customizer<ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry>, Ordered {

    @Override
    public int getOrder() {
        return 0;
    }

}
