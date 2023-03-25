package com.anisa.customValidation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.annotation.Annotation;

public class CouponCodeConstraintValidator implements ConstraintValidator<CouponCode,String> {

    String couponPrefix;
    @Override
    public void initialize(CouponCode couponCode) {
        couponPrefix=couponCode.value();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value.startsWith(couponPrefix);
    }
}
