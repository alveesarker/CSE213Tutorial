package com.example.practicemid;

import java.time.LocalDate;

public class Article {
    private String title;
    private String author;
    private String articleType;
    private LocalDate publicationDate;
    private String citationStatus;
    private int noOfAuthor;

    public Article(String title, String author, String articleType, LocalDate publicationDate, String citationStatus, int noOfAuthor) {
        this.title = title;
        this.author = author;
        this.articleType = articleType;
        this.publicationDate = publicationDate;
        this.citationStatus = citationStatus;
        this.noOfAuthor = noOfAuthor;
    }

    public Article() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getArticleType() {
        return articleType;
    }

    public void setArticleType(String articleType) {
        this.articleType = articleType;
    }

    public LocalDate getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(LocalDate publicationDate) {
        this.publicationDate = publicationDate;
    }

    public String getCitationStatus() {
        return citationStatus;
    }

    public void setCitationStatus(String citationStatus) {
        this.citationStatus = citationStatus;
    }

    public int getNoOfAuthor() {
        return noOfAuthor;
    }

    public void setNoOfAuthor(int noOfAuthor) {
        this.noOfAuthor = noOfAuthor;
    }

    @Override
    public String toString() {
        return "Article{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", articleType='" + articleType + '\'' +
                ", publicationDate=" + publicationDate +
                ", citationStatus='" + citationStatus + '\'' +
                ", noOfAuthor=" + noOfAuthor +
                '}';
    }

    public int getPublicationYear(){
        return publicationDate.getYear();
    }
}
