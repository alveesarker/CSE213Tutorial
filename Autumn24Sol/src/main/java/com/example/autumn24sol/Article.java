package com.example.autumn24sol;

import java.time.LocalDate;

public class Article {
    private String title, author, articleType, citationStatus;
    private LocalDate publicationDate;
    private int numOfAuthor;

    public Article(String title, String author, String articleType, String citationStatus, LocalDate publicationDate, int numOfAuthor) {
        this.title = title;
        this.author = author;
        this.articleType = articleType;
        this.citationStatus = citationStatus;
        this.publicationDate = publicationDate;
        this.numOfAuthor = numOfAuthor;
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

    public String getCitationStatus() {
        return citationStatus;
    }

    public void setCitationStatus(String citationStatus) {
        this.citationStatus = citationStatus;
    }

    public LocalDate getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(LocalDate publicationDate) {
        this.publicationDate = publicationDate;
    }

    public int getNumOfAuthor() {
        return numOfAuthor;
    }

    public void setNumOfAuthor(int numOfAuthor) {
        this.numOfAuthor = numOfAuthor;
    }

    @Override
    public String toString() {
        return "Article{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", articleType='" + articleType + '\'' +
                ", citationStatus='" + citationStatus + '\'' +
                ", publicationDate=" + publicationDate +
                ", numOfAuthor=" + numOfAuthor +
                '}';
    }

    public int getPublicationYear(){
        return this.publicationDate.getYear();
    }
}
