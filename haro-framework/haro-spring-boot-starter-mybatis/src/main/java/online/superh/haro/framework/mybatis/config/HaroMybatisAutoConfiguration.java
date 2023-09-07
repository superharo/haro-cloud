package online.superh.haro.framework.mybatis.config;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.AutoConfiguration;

/**
 * @version: 1.0
 * @author: haro
 * @description:
 * @date: 2023-09-07 11:00
 */
@AutoConfiguration
@MapperScan(value = "${haro.info.base-package}", annotationClass = Mapper.class,
        lazyInitialization = "${mybatis.lazy-initialization:false}") // Mapper 懒加载，目前仅用于单元测试
public class HaroMybatisAutoConfiguration {



}
