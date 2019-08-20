package com.solar.dao;

import com.solar.pojo.Comment;

import java.util.List;

public interface CommentDao {
    void saveComment(Comment comment);
    List<Comment> findCommentByAuthorId(Integer AuthorId);
    List<Comment> findCommentByArticleId(Integer ArticleId);
    void deleteCommentById(Integer id);
    List<Comment> findAllComment();
}
