package online.superh.haro.framework.web.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @version: 1.0
 * @author: haro
 * @description:
 * @date: 2023-08-28 15:11
 */

@ConfigurationProperties(prefix = "haro.web")
@Validated
@Data
public class WebProperties implements WebMvcConfigurer {


}
