package com.eni.encheres.ihm.controller;

import com.eni.encheres.bll.UtilisateurService;
import com.eni.encheres.bo.Utilisateur;
import com.eni.encheres.exception.BusinessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import jakarta.validation.Valid;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;

@Controller
public class RegistrationController {


    private UtilisateurService utilisateurService;

    public RegistrationController(UtilisateurService utilisateurService) {
        this.utilisateurService = utilisateurService;
    }

    @GetMapping("/registration")
    public String registration(Model model) {
        Utilisateur utilisateur = new Utilisateur();
        model.addAttribute("utilisateur", utilisateur);
        return "registration";
    }

    @PostMapping("/registration")
    public String registration(@Valid @ModelAttribute("utilisateur") Utilisateur utilisateur, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "registration";
        } else {
            System.out.println(utilisateur.getMotDePasse());
            utilisateur.setMotDePasse(PasswordEncoderFactories.createDelegatingPasswordEncoder().encode(utilisateur.getMotDePasse()));

            try {
                utilisateurService.createUtilisateur(utilisateur);
                return "/login";
            } catch (BusinessException e) {
                e.getErreurs().forEach(err -> {
                            System.out.println(err);

                            ObjectError error = new ObjectError("globalError", err);
                            bindingResult.addError(error);
                        }
                );
                return "registration";
            }
        }
    }
}
