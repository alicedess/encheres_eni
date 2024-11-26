package com.eni.encheres.ihm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
public class TestController {


    @GetMapping
    public String showTest(Model model) {
        // Ajout des films dans le modèle
        return "view-test";
    }


}
