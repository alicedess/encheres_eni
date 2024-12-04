package com.eni.encheres.ihm.controller;

import com.eni.encheres.bll.ArticleService;
import com.eni.encheres.bll.CategorieService;
import com.eni.encheres.bo.Article;
import com.eni.encheres.bo.Categorie;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

import static java.lang.Integer.parseInt;

@Controller
@RequestMapping("/articles")
public class ArticleController {

    private final ArticleService articleService;
    private final CategorieService categorieService;

    public ArticleController(ArticleService articleService, CategorieService categorieService) {
        this.articleService = articleService;
        this.categorieService = categorieService;
    }

    @GetMapping("/list")
    public String showHome(@RequestParam(value = "nameFilter", required = false) String nameFilter,
                           @RequestParam(value = "categoryFilter", required = false) Integer categoryFilter,
                           Model model) {
        List<Article> articles = articleService.getArticles(categoryFilter, nameFilter);
        List<Categorie> categories = categorieService.getAll();

        model.addAttribute("articles", articles);
        model.addAttribute("categories", categories);
        model.addAttribute("selectedCategory", categoryFilter);
        model.addAttribute("nameFilter", nameFilter);

        return "home";
    }
}
