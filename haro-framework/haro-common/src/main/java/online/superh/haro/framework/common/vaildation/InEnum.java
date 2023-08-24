package online.superh.haro.framework.common.vaildation;

import online.superh.haro.framework.common.core.IntArrayValuable;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * @version: 1.0
 * @author: haro
 * @description:
 * @date: 2023-08-24 15:51
 */
@Target({
        ElementType.METHOD,
        ElementType.FIELD,
        ElementType.ANNOTATION_TYPE,
        ElementType.CONSTRUCTOR,
        ElementType.PARAMETER,
        ElementType.TYPE_USE
})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(
        validatedBy = InEnumValidator.class
)
public @interface InEnum {

    String message() default "必须在指定范围 {value}";
    Class<?>[] groups() default {};

    Class<? extends IntArrayValuable> value();

    Class<? extends Payload>[] payload() default {};
}
