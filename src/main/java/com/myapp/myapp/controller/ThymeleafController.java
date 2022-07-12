package com.myapp.myapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.myapp.myapp.service.impl.GeneralService;

@Controller
public class ThymeleafController{

    @Autowired
    GeneralService service;

    @GetMapping("/index")
    public String getModel(Model model){
        model.addAttribute("persons", service.getAllPerson());
        return "/index.html";
    }
}