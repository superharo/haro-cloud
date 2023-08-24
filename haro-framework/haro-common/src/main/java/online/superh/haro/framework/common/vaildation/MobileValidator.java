package online.superh.haro.framework.common.vaildation;

import cn.hutool.core.util.PhoneUtil;
import cn.hutool.core.util.StrUtil;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @version: 1.0
 * @author: haro
 * @description:
 * @date: 2023-08-24 16:05
 */
public class MobileValidator implements ConstraintValidator<Mobile, String> {

    @Override
    public void initialize(Mobile annotation) {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        // 如果手机号为空，默认不校验，即校验通过
        if (StrUtil.isEmpty(value)) {
            return true;
        }
        // 校验手机
        return PhoneUtil.isMobile(value);
    }

}
