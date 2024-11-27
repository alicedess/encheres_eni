package com.eni.encheres.ihm.controller;

import com.eni.encheres.bll.ArticleService;
import com.eni.encheres.bo.ArticleAVendre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/articles")
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @GetMapping("/list")
    public String showHome(Model model) {
        List<ArticleAVendre> articles = articleService.getAll();
        model.addAttribute("articles", articles);
        return "home";
    }
}
