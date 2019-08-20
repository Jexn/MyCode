package com.solar.service.Impl;

import com.solar.dao.CommentDao;
import com.solar.pojo.Comment;
import com.solar.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    private final CommentDao commentDao;

    @Autowired
    public CommentServiceImpl(CommentDao commentDao) {
        this.commentDao = commentDao;
    }

    @Override
    public void saveComment(Comment comment) {
        commentDao.saveComment(comment);
    }

    @Override
    public List<Comment> findCommentByAuthorId(Integer AuthorId) {
        return commentDao.findCommentByAuthorId(AuthorId);
    }

    @Override
    public List<Comment> findCommentByArticleId(Integer ArticleId) {
        return commentDao.findCommentByArticleId(ArticleId);
    }

    @Override
    public void deleteCommentById(Integer id) {
        commentDao.deleteCommentById(id);
    }

    @Override
    public List<Comment> findAllComment() {
        return commentDao.findAllComment();
    }
}
