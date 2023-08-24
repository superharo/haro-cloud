package online.superh.haro.framework.banner.config;

import online.superh.haro.framework.banner.core.BannerApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @version: 1.0
 * @author: haro
 * @description:
 * @date: 2023-08-24 16:32
 */
@Configuration(proxyBeanMethods = false)
public class HaroBannerAutoConfiguration {

    @Bean
    public BannerApplicationRunner bannerApplicationRunner(){
        return new BannerApplicationRunner();
    }


}
