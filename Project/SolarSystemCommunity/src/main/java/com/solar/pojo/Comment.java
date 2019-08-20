package com.solar.pojo;

import java.util.Date;

public class Comment {
    // 此条留言ID
    private Integer id;
    // 文章ID
    private Integer article_id;
    // 创建留言的作者ID
    private Integer author_id;
    // 回复对象
    private Integer reply_id;
    // 回复内容
    private String content;
    // 回复时间
    private Date date;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getArticle_id() {
        return article_id;
    }

    public void setArticle_id(Integer article_id) {
        this.article_id = article_id;
    }

    public Integer getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(Integer author_id) {
        this.author_id = author_id;
    }

    public Integer getReply_id() {
        return reply_id;
    }

    public void setReply_id(Integer reply_id) {
        this.reply_id = reply_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", article_id=" + article_id +
                ", author_id=" + author_id +
                ", reply_id=" + reply_id +
                ", content='" + content + '\'' +
                ", date=" + date +
                '}';
    }
}
