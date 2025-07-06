package com.example.midterm_2311249_sec5;

import java.time.LocalDate;

public class Article {
    private String title, author, articleType, citationStatus;
    private LocalDate publicationDate;
    private int noOfAuthor;

    public Article(String title, String author, String articleType, String citationStatus, LocalDate publicationDate, int noOfAuthor) {
        this.title = title;
        this.author = author;
        this.articleType = articleType;
        this.citationStatus = citationStatus;
        this.publicationDate = publicationDate;
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

    public int getNoOfAuthor() {
        return noOfAuthor;
    }

    public void setNoOfAuthor(int noOfAuthor) {
        this.noOfAuthor = noOfAuthor;
    }

    public int getPublicationYear(){
        return this.publicationDate.getYear();
    }

    @Override
    public String toString() {
        return "Article{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", articleType='" + articleType + '\'' +
                ", citationStatus='" + citationStatus + '\'' +
                ", publicationDate=" + publicationDate +
                ", noOfAuthor=" + noOfAuthor +
                '}';
    }
}
