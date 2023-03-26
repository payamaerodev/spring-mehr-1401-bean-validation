package com.anisa.controller;

import com.anisa.entity.Product;

import com.anisa.entity.User;
import jakarta.transaction.Transactional;
import org.hibernate.SessionFactory;
import org.hibernate.validator.internal.engine.messageinterpolation.LocalizedMessage;
import org.jboss.logging.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Locale;
import java.util.ResourceBundle;

@Controller
@RequestMapping("/")
public class ProductController {

    @Autowired
    public SessionFactory sessionFactory;

    @GetMapping("user")
    @Transactional
    public ModelAndView getUser(@RequestParam("id") String id) {
        User user = sessionFactory.getCurrentSession().find(User.class, id);
//        model.addAttribute(user);
        ModelAndView model = new ModelAndView();
        model.addObject(user);
        return model;
    }

    @GetMapping("/showForm")
    public String getAllProducts(Model model) {

        model.addAttribute("product", new Product());
        return "product";
    }

    //add product
    @PostMapping(value = "/processForm")
    public String processForm(@Valid @ModelAttribute("product") Product product, BindingResult bindingResult) {
        System.out.println("Binding Result is" + bindingResult);
        if (bindingResult.hasErrors()) return "product";
        else return "product-ok";
    }

    @PostMapping("/exc")
    public void exception() throws Exception {
//        throw new Exception(ResourceBundle.getBundle("messages").getString("error.message")) ;
        throw new Exception(ResourceBundle.getBundle("messages").getString("error.message")) ;
    }

    @InitBinder
    public void initBinder(@NotNull WebDataBinder dataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }
}
