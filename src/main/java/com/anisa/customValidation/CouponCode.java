package com.anisa.customValidation;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.NotNull;
import java.lang.annotation.Documented;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.ElementType.TYPE_USE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({ METHOD, FIELD })
@Retention(RUNTIME)
@Constraint(validatedBy =  CouponCodeConstraintValidator.class )
public @interface CouponCode {

    String value() default "OFF";
    String message() default "code with OFF";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
