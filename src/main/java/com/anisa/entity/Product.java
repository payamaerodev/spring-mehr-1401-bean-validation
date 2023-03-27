package com.anisa.entity;

import com.anisa.customValidation.CouponCode;
import lombok.*;


import javax.validation.constraints.*;
import javax.validation.constraints.CheckFormat;
import java.math.BigDecimal;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Product {

//    private Long id;
//    @NonNull
//    @NotNull
//    @Size(min = 1, message = "in field lazeme!")
//    private String name;
//    @NonNull
//    private String description;
//    @NonNull
//    @NotNull
//    @Min(value = 1000)
//    @Max(value = 100000)
//    private BigDecimal price;
//
//    @Pattern(regexp = "[a-zA-Z0-9]{10}", message = "only 10 number or char")
//    private String regx;
//
//
//    //Custom validation
//    @CouponCode(value = "takhfif", message = "bayad ba takhfif shoro beshe")
//    private String couponCode;

    private String price;

    //Custom validation
    @CheckFormat(value = "f", message = "bayad ba takhfif shoro beshe")
    private String format;
}
