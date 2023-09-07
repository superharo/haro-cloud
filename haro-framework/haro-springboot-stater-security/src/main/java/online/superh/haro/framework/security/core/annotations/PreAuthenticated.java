package online.superh.haro.framework.security.core.annotations;

import java.lang.annotation.*;

/**
 * @version: 1.0
 * @author: haro
 * @description:
 * @date: 2023-09-05 13:42
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface PreAuthenticated {
}
