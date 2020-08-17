package com.anchorage.web.oop;

class OopArticle {
    private int articleId; // 글번호
    private String title, content, writer,redDate;
    public int getArticleId() {
        return articleId;
    }
    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public String getWriter() {
        return writer;
    }
    public void setWriter(String writer) {
        this.writer = writer;
    }
    public String getRedDate() {
        return redDate;
    }
    public void setRedDate(String redDate) {
        this.redDate = redDate;
    }
    @Override
    public String toString() {
        return "Article [articleId=" + articleId + ", title=" + title + ", content=" + content + ", writer=" + writer
                + ", redDate=" + redDate + "]";
    }


}