package com.solar.service.Impl;

import com.solar.dao.ArticleDao;
import com.solar.pojo.Article;
import com.solar.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ArticleServiceImpl implements ArticleService {
    private final ArticleDao articleDao;

    @Autowired
    public ArticleServiceImpl(ArticleDao articleDao) {
        this.articleDao = articleDao;
    }

    @Override
    public void saveArticle(Article article) {
        articleDao.saveArticle(article);
    }

    @Override
    public void deleteArticleById(Integer id) {
        articleDao.deleteArticleById(id);
    }

    @Override
    public void deleteAuthorAllArticleByAuthorId(Integer AuthorId) {
        articleDao.deleteArticleById(AuthorId);
    }

    @Override
    public Article findArticleById(Integer id) {
        return articleDao.findArticleById(id);
    }

    @Override
    public List<Article> findAuthorAllArticleByAuthorId(Integer AuthorId) {
        return articleDao.findAuthorAllArticleByAuthorId(AuthorId);
    }

    @Override
    public List<Article> findAuthorAllArticleByAuthorName(String AuthorName) {
        return articleDao.findAuthorAllArticleByAuthorName(AuthorName);
    }

    @Override
    public void updateArticleInfo(Article article) {
        articleDao.updateArticleInfo(article);
    }

    @Override
    public List<Article> findArticleLimit() {
        return articleDao.findArticleLimit();
    }
}
