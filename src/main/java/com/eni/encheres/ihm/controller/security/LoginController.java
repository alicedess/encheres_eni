package com.eni.encheres.ihm.controller.security;


import com.eni.encheres.bll.contexte.ContexteService;
import com.eni.encheres.bo.Utilisateur;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.security.Principal;

@SessionAttributes({"userSession"})
@Controller
public class LoginController {

    private ContexteService contexteService;

    public LoginController(ContexteService contexteService) {
        this.contexteService = contexteService;
    }

    @GetMapping("/login")
    public String login(Model model) {
        return "login";
    }

    @GetMapping("/session")
    public String connexion(@ModelAttribute("userSession") Utilisateur userSession, Principal principal) {
        String pseudo = principal.getName();
        Utilisateur utilisateur = this.contexteService.charger(pseudo);
        System.out.println(utilisateur);
        if (utilisateur != null) {
            userSession.setPublicUser(utilisateur);
//            userSession.setNom(utilisateur.getNom());
//            userSession.setPrenom(utilisateur.getPrenom());
//            userSession.setPseudo(utilisateur.getPseudo());
//            userSession.setAdministrateur(utilisateur.getAdministrateur());
        } else {
            userSession.setNom(null);
            userSession.setPrenom(null);
            userSession.setPseudo(null);
            userSession.setAdministrateur(false);
        }
        return "redirect:/";
    }

    @ModelAttribute("userSession")
    public Utilisateur addUserSession() {
        System.out.println("Add user in session");
        return new Utilisateur();
    }
}
