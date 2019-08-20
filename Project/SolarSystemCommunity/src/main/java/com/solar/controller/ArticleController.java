package com.solar.controller;

import com.alibaba.fastjson.JSON;
import com.solar.pojo.Article;
import com.solar.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/article")
public class ArticleController {

    private final ArticleService articleService;

    @Autowired
    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping("writeArticle")
    public String writeArticle(){
        return "/WEB-INF/Pages/writeArticle";
    }

    @PostMapping("addArticle")
    public String addArticle(Article article){
        System.out.println(article);
        article.setCreate_date(new Date());
        article.setModify_date(new Date());
        articleService.saveArticle(article);
        return "/WEB-INF/Pages/home";
    }

    @GetMapping(value = "getAllArticle",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String getAllArticle(){
        List<Article> articles = articleService.findArticleLimit();
        return JSON.toJSONString(articles);
    }

    @GetMapping("getArticle/{id}")
    public String getArticle(@PathVariable Integer id, Model model){
        Article article = articleService.findArticleById(id);
        System.out.println(article);
        model.addAttribute("article",article);
        return "/WEB-INF/Pages/detail";
    }
}
