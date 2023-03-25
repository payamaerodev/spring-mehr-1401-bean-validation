package com.anisa.config;


import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.util.UrlPathHelper;
import org.w3c.dom.Text;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sound.sampled.AudioFormat;
import java.util.List;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.anisa"})
public class WebConfig implements WebMvcConfigurer {


    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/view/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        UrlPathHelper urlPathHelper = new UrlPathHelper();
        urlPathHelper.setRemoveSemicolonContent(false);
        configurer.setUrlPathHelper(urlPathHelper);
    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {

        //converters.add(new StringHttpMessageConverter());
        //converters.add(new Jaxb2RootElementHttpMessageConverter());
        converters.add(new MappingJackson2HttpMessageConverter());
    }

    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("messages");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }

//    @Bean(name = "messageSource")
//    public ResourceBundleMessageSource messageSource() {
//        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
//        messageSource.setBasename("messages");
//        messageSource.setDefaultEncoding("UTF-8");
//        messageSource.setUseCodeAsDefaultMessage(true);
//        return messageSource;
//    }

    /* @Bean
    public HandlerExceptionResolver handlerExceptionResolver()
    {
        return  new HandlerExceptionResolver() {
            @Override
            public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {

                ModelAndView modelAndView=new ModelAndView();
                modelAndView.setViewName("error-page");
                modelAndView.addObject("exceptionType",ex);
                return modelAndView;
            }
        };
    }*/

   /* @Bean
    public HandlerExceptionResolver handlerExceptionResolver()
    {
        SimpleMappingExceptionResolver resolver=new SimpleMappingExceptionResolver();


        //mapping based on error
        Properties mapping=new Properties();
        mapping.put("java.lang.NullPointerException","error1");
        mapping.put("java.lang.ArithmeticException","error2");
        //mapping base on statusCode
        Properties mapping2=new Properties();
        mapping2.put("error-page","400");
        mapping2.put("error-page2","500");

        resolver.setExceptionMappings(mapping);

        return resolver;
    }*/


    //4


}
