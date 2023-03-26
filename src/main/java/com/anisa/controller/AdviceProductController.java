package com.anisa.controller;

import com.anisa.entity.Product;
import com.anisa.entity.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@ControllerAdvice
@RequestMapping("/advice")
public class AdviceProductController {

    @Autowired
    public SessionFactory sessionFactory;

    @ModelAttribute("payam")
    public List<String> modelAttribute() {
        return List.of("TENNIS,FOOTBALL");
    }


    @GetMapping("user")
//    @Transactional
    public ModelAndView getUser(@RequestParam("id") String id) {
        User user = sessionFactory.getCurrentSession().find(User.class, id);
//        model.addAttribute(user);
        ModelAndView model = new ModelAndView();
        model.addObject(user);
        return model;
    }

    @ExceptionHandler(Exception.class)
    public String exceptionHandler(Exception ex, Model model) {
        model.addAttribute("message", ex.getMessage());
        return "exception";
    }

    @GetMapping("/showForm")
    public String getAllProducts(Model model) {

        model.addAttribute("product", new Product());
        return "product";
    }

    //add product
    @PostMapping(value = "/processForm")
    public String processForm(@Valid @ModelAttribute("product") Product product, BindingResult bindingResult) {

        System.out.println("---------------");

        System.out.println("---------------" + bindingResult.getModel());
        System.out.println("Binding Result is" + bindingResult);
        System.out.println("------------------" + bindingResult.getModel());
        if (bindingResult.hasErrors()) return "product";
        else return "product-ok";
    }

    @InitBinder
    public void initBinder(@NotNull WebDataBinder dataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }


}
