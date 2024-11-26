package com.eni.encheres.ihm.controller;

import com.eni.encheres.bo.Utilisateur;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.List;

@SessionAttributes({"userSession"})
@Controller
@RequestMapping("/")
public class TestController {


    @GetMapping
    public String showTest(Model model, @ModelAttribute("userSession") Utilisateur userSession) {
        // Ajout des films dans le modèle
        model.addAttribute("user", userSession);
        return "view-test";
    }


}
