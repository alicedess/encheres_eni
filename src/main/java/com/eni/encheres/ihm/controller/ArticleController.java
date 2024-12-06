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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.eni.encheres.bo.Categorie;

import java.util.List;


@Controller
@RequestMapping("/articles")
public class ArticleController {

    @Autowired
    ArticleService articleService;

    @Autowired
    private CategorieService categorieService;

    @Autowired
    private AdresseDAO adresseDAO;

    @GetMapping("/list")
    public String showHome(@RequestParam(value = "nameFilter", required = false) String nameFilter,
                           @RequestParam(value = "categoryFilter", required = false) Integer categoryFilter,
                           Model model) {
        List<Article> articles = articleService.getArticles(categoryFilter != null ? categoryFilter : 0, nameFilter);
        List<Categorie> categories = categorieService.getAllCategories();

        model.addAttribute("articles", articles);
        model.addAttribute("categories", categories);
        model.addAttribute("selectedCategory", categoryFilter);
        model.addAttribute("nameFilter", nameFilter);

        return "home";
    }

    @GetMapping
    public String listArticles(Model model, @ModelAttribute("message") String message) {
        model.addAttribute("articles", articleService.getActiveArticles());
        model.addAttribute("message", message);
        return "article/list";
    }

    @GetMapping("/sell")
    public String showSellForm(Model model) {
        model.addAttribute("article", new Article());
        model.addAttribute("categories", categorieService.getAllCategories());
        model.addAttribute("adresses", adresseDAO.findAll());
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

    @PostMapping("/sell")
    public String saveArticle(
            @ModelAttribute("article") @Valid Article article,
            BindingResult result,
            Model model,
            RedirectAttributes redirectAttributes
    ) {
        if (result.hasErrors()) {
            model.addAttribute("categories", categorieService.getAllCategories());
            model.addAttribute("adresses", adresseDAO.findAll());
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
            redirectAttributes.addFlashAttribute("error", "Veuillez sélectionner une adresse.");
            return "redirect:/articles/sell";
        }

        article.setId_utilisateur("currentUser");

        articleService.saveArticle(article);
        redirectAttributes.addFlashAttribute("message", "Article mis en vente avec succès !");
        return "redirect:/articles";
    }
}
