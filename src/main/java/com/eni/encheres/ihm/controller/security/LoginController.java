package com.eni.encheres.ihm.controller.security;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {


    @GetMapping("/login")
    public String login(Model model) {
        return "login";
    }

//    @GetMapping("/session")
//    public String connexion(@ModelAttribute("userSession") Utilisateur userSession, Principal principal) {
//        String pseudo = principal.getName();
//        return "redirect:/";
//    }

//    @ModelAttribute("userSession")
//    public Utilisateur addUserSession() {
//        System.out.println("Add user in session");
//        return new Utilisateur();
//    }
}
