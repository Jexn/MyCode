package com.solar.controller;

import com.alibaba.fastjson.JSON;
import com.solar.pojo.Comment;
import com.solar.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/comment")
public class CommentController {
    private final CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("saveComment")
    public String saveComment(Comment comment){
        comment.setDate(new Date());
        commentService.saveComment(comment);
        System.out.println(comment);
        return "redirect:/article/getArticle/"+comment.getArticle_id();
    }

    @PostMapping(value = "getComment/{id}",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String getComment(@PathVariable Integer id){
        List<Comment> comments = commentService.findCommentByArticleId(id);
        return JSON.toJSONString(comments);
    }
}
