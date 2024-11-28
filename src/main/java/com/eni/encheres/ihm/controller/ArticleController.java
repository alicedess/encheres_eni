package com.eni.encheres.ihm.controller;

import com.eni.encheres.bo.Article;
import com.eni.encheres.bll.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/articles")
public class ArticleController {
    @Autowired
    ArticleService articleService;

    @GetMapping("/new")
    public String showSellForm(Model model) {
        model.addAttribute("article", new Article());
        return "article/sell";
    }

    @PostMapping("/new")
    public String saveArticle(@ModelAttribute("article") Article article, BindingResult result) {
        if (result.hasErrors()) {
            return "article/sell";
        }

        article.setId_utilisateur("currentUser");
        article.setNo_adresse_retrait(1);
        articleService.saveArticle(article);

        return "redirect:/articles";
    }
}