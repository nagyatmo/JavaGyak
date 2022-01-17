package com.udemy.udemyspring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/hello")
public class HelloController {

        @GetMapping
        public ModelAndView helloController(){
            ModelAndView mv = new ModelAndView();
            mv.setViewName("welcome");
            mv.getModel().put("data","Welcome home man");
            return mv;
    }
}
