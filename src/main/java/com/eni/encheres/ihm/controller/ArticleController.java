package com.eni.encheres.ihm.controller;

import com.eni.encheres.bll.ArticleService;
import com.eni.encheres.bll.CategorieService;
import com.eni.encheres.bo.Article;
import jakarta.validation.Valid;
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

    @Autowired
    private CategorieService categorieService;

//    @Autowired
//    private AdresseService adresseService;

    @GetMapping
    public String listArticles(Model model) {
        model.addAttribute("articles", articleService.getActiveArticles());
        return "article/list";
    }

    @GetMapping("/new")
    public String showSellForm(Model model) {
        model.addAttribute("article", new Article());
        model.addAttribute("categories", categorieService.getAllCategories());
//        model.addAttribute("addresses", adresseService.getAvailableAddresses("currentUser"));
        return "article/sell";
    }

    @GetMapping("/cancel/{articleId}")
    public String cancelArticle(@PathVariable Integer articleId) {
        articleService.deleteArticle(articleId);
        return "redirect:/articles";
    }

    @GetMapping("/cancel")
    public String cancel() {
        return "redirect:/";
    }

    @PostMapping("/new")
    public String saveArticle(@ModelAttribute("article") @Valid Article article, BindingResult result) {
        if (result.hasErrors()) {
            return "article/sell";
        }

        article.setId_utilisateur("currentUser"); // Utilisateur connecté
        articleService.saveArticle(article);
        return "redirect:/articles/photo/" + article.getNo_article();
    }
}