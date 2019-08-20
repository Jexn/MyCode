package com.solar.dao;

import com.solar.pojo.Article;

import java.util.List;

public interface ArticleDao {
    void saveArticle(Article article);
    // 根据文章id删除文章
    void deleteArticleById(Integer id);
    // 根据作者id,删除其作者所有文章
    void deleteAuthorAllArticleByAuthorId(Integer AuthorId);
    // 根据文章id查找文章
    Article findArticleById(Integer id);
    // 根据作者id，查找其所有文章
    List<Article> findAuthorAllArticleByAuthorId(Integer AuthorId);
    // 根据作者姓名，查找其所有文章
    List<Article> findAuthorAllArticleByAuthorName(String AuthorName);
    // 更新文章信息
    void updateArticleInfo(Article article);
    // 查找最近十篇文章
    List<Article> findArticleLimit();
}
