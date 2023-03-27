package com.anisa.config;


import com.anisa.entity.Product;
import com.mysql.cj.util.StringUtils;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.util.UrlPathHelper;

import javax.validation.ConstraintViolation;
import java.util.List;
import java.util.Set;

@Component
public class Validator implements org.springframework.validation.Validator {


    @Override
    public boolean supports(Class<?> clazz) {
        return true;
    }

    @Override
    public void validate(Object target, Errors errors) {
        Product product = (Product) target;
        errors.reject("400");
        if (StringUtils.isEmptyOrWhitespaceOnly(((Product) target).getPrice()))
            System.out.println(((Product) target).getPrice());
        errors.rejectValue("price","price");
    }
}
