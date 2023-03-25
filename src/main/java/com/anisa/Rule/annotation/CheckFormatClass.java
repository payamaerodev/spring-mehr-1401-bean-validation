package com.anisa.Rule.annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.constraints.CheckFormat;

public class CheckFormatClass implements ConstraintValidator<CheckFormat, String> {
    @Override
    public void initialize(CheckFormat constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value.startsWith("f");
    }
}
