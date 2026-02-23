package com.example.midexampractice;

import java.time.LocalDate;

public class Article {
    private String Title, Author, ArticleType, CitationStatus;
    private LocalDate PublicationDate ;
    private int NoOfAuthors;

    public Article(String title, String author, String articleType, String citationStatus, LocalDate publicationDate, int noOfAuthors) {
        Title = title;
        Author = author;
        ArticleType = articleType;
        CitationStatus = citationStatus;
        PublicationDate = publicationDate;
        NoOfAuthors = noOfAuthors;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public String getArticleType() {
        return ArticleType;
    }

    public void setArticleType(String articleType) {
        ArticleType = articleType;
    }

    public String getCitationStatus() {
        return CitationStatus;
    }

    public void setCitationStatus(String citationStatus) {
        CitationStatus = citationStatus;
    }

    public LocalDate getPublicationDate() {
        return PublicationDate;
    }

    public void setPublicationDate(LocalDate publicationDate) {
        PublicationDate = publicationDate;
    }

    public int getNoOfAuthors() {
        return NoOfAuthors;
    }

    public void setNoOfAuthors(int noOfAuthors) {
        NoOfAuthors = noOfAuthors;
    }

    public int getPublicationYear(){
        return this.getPublicationDate().getYear();
    }


    @Override
    public String toString() {
        return "Article{" +
                "Title='" + Title + '\'' +
                ", Author='" + Author + '\'' +
                ", ArticleType='" + ArticleType + '\'' +
                ", CitationStatus='" + CitationStatus + '\'' +
                ", PublicationDate=" + PublicationDate +
                ", NoOfAuthors=" + NoOfAuthors +
                '}';
    }
}
