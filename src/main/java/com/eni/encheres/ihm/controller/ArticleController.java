package com.eni.encheres.ihm.controller;

import com.eni.encheres.bll.ArticleService;
import com.eni.encheres.bll.CategorieService;
import com.eni.encheres.bo.Article;
import com.eni.encheres.dao.AdresseDAO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/articles")
public class ArticleController {
    @Autowired
    ArticleService articleService;

    @Autowired
    private CategorieService categorieService;

    @Autowired
    private AdresseDAO adresseDAO;

    @GetMapping
    public String listArticles(Model model, @ModelAttribute("message") String message) {
        model.addAttribute("articles", articleService.getActiveArticles());
        model.addAttribute("message", message);
        model.addAttribute("addresses", adresseDAO.findAll());
        return "article/list";
    }

    @GetMapping("/new")
    public String showSellForm(Model model) {
        model.addAttribute("article", new Article());
        model.addAttribute("categories", categorieService.getAllCategories());
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
    public String saveArticle(
            @ModelAttribute("article") @Valid Article article,
            BindingResult result,
            Model model,
            RedirectAttributes redirectAttributes
    ) {
        if (result.hasErrors()) {
            model.addAttribute("categories", categorieService.getAllCategories());
            model.addAttribute("addresses", adresseDAO.findAll());
            return "article/sell";
        }

        System.out.println("Article description before saving: " + article.getDescription());

        if (article.getStatut_enchere() == null) {
            article.setStatut_enchere(0);
        }

        if (article.getDescription() == null || article.getDescription().isEmpty()) {
            article.setDescription("Description non fournie");
        }

        if (article.getNo_adresse_retrait() == null) {
            article.setNo_adresse_retrait(0);
        }

        article.setId_utilisateur("currentUser");
        articleService.saveArticle(article);
//        return "redirect:/articles/photo/" + article.getNo_article();
        redirectAttributes.addFlashAttribute("message", "Article mis en vente avec succès !");
        return "redirect:/articles";
    }
}
