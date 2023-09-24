package com.example.photosapp.asset;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Article {
    @SerializedName("article_id")
    @Expose
    private int article_id;

    @SerializedName("article_title")
    @Expose
    private String article_title;

    @SerializedName("article_image")
    @Expose
    private String article_image;

    @SerializedName("article_description")
    @Expose
    private String article_desc;

    public Article(int article_id, String article_title, String article_image, String article_desc) {
        this.article_id = article_id;
        this.article_title = article_title;
        this.article_image = article_image;
        this.article_desc = article_desc;
    }

    public int getArticle_id() {
        return article_id;
    }

    public String getArticle_title() {
        return article_title;
    }

    public String getArticle_image() {
        return article_image;
    }

    public String getArticle_desc() {
        return article_desc;
    }

    public void setArticle_id(int article_id) {
        this.article_id = article_id;
    }

    public void setArticle_title(String article_title) {
        this.article_title = article_title;
    }

    public void setArticle_image(String article_image) {
        this.article_image = article_image;
    }

    public void setArticle_desc(String article_desc) {
        this.article_desc = article_desc;
    }
}
