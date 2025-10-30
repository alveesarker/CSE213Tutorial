package com.example.autumn24sol;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;
import java.util.ArrayList;

public class ArticleViewController
{
    @javafx.fxml.FXML
    private TableColumn<Article, String> titleCol;
    @javafx.fxml.FXML
    private TextField firstYear;
    @javafx.fxml.FXML
    private ComboBox<String> articleTypeComboBox;
    @javafx.fxml.FXML
    private Label articleTitleLabel;
    @javafx.fxml.FXML
    private ComboBox<String> filterArticleTypeComboBox;
    @javafx.fxml.FXML
    private CheckBox filterCitationCheckBox;
    @javafx.fxml.FXML
    private TableColumn<Article, String> authorCol;
    @javafx.fxml.FXML
    private DatePicker publicationDatePicker;
    @javafx.fxml.FXML
    private CheckBox citationCheckBox;
    @javafx.fxml.FXML
    private TableView<Article> articleTableview;
    @javafx.fxml.FXML
    private TextField titleTextField;
    @javafx.fxml.FXML
    private TableColumn<Article, Integer> numOfAuthorCol;
    @javafx.fxml.FXML
    private TextField lastYear;
    @javafx.fxml.FXML
    private TableColumn<Article, String> articleTypeCol;
    @javafx.fxml.FXML
    private TextField numOfAuthorTextField;
    @javafx.fxml.FXML
    private TableColumn<Article, LocalDate> publicationDateCol;
    @javafx.fxml.FXML
    private TableColumn<Article, String> citationStatusCol;
    @javafx.fxml.FXML
    private Label errorLabel;
    @javafx.fxml.FXML
    private TextField authorTextField;
    private final ArrayList<Article> articleList = new ArrayList<>();

    @javafx.fxml.FXML
    public void initialize() {
        articleTypeComboBox.getItems().addAll("Review", "Book", "Case");
        filterArticleTypeComboBox.getItems().addAll("Review", "Book", "Case");

        articleTypeCol.setCellValueFactory(new PropertyValueFactory<>("articleType"));
        authorCol.setCellValueFactory(new PropertyValueFactory<>("author"));
        citationStatusCol.setCellValueFactory(new PropertyValueFactory<>("citationStatus"));
        numOfAuthorCol.setCellValueFactory(new PropertyValueFactory<>("numOfAuthor"));
        publicationDateCol.setCellValueFactory(new PropertyValueFactory<>("publicationDate"));
        titleCol.setCellValueFactory(new PropertyValueFactory<>("title"));
    }

    @javafx.fxml.FXML
    public void handleSearchArticleButton(ActionEvent actionEvent) {
        String citationStatus;
        if (filterCitationCheckBox.isSelected()){
            citationStatus = "Yes";
        } else{
            citationStatus = "No";
        }

        articleTableview.getItems().clear();
        for(Article a: articleList){
            if(a.getArticleType().equals(filterArticleTypeComboBox.getValue()) && a.getCitationStatus().equals(citationStatus)){
                articleTableview.getItems().add(a);
            }
        }
    }

    @javafx.fxml.FXML
    public void handleYearFilterButton(ActionEvent actionEvent) {
        articleTableview.getItems().clear();
        for(Article a: articleList){
            if (a.getPublicationDate().getYear() >= Integer.parseInt(firstYear.getText()) && a.getPublicationDate().getYear() <= Integer.parseInt(lastYear.getText())){
                articleTableview.getItems().add(a);
            }
        }
    }

    @javafx.fxml.FXML
    public void addArticleButtonMouseOnClicked(ActionEvent actionEvent) {
//        String title, String author, String articleType, String citationStatus, LocalDate publicationDate, int numOfAuthor

        try{
            int numOfAuthor = Integer.parseInt(numOfAuthorTextField.getText());
        } catch (Exception e){
            errorLabel.setText("Number of author must be an Integer number.");
            return;
        }

        for (Article a: articleList){
            if (a.getTitle().equals(titleTextField.getText())){
                errorLabel.setText("Article title needs to be unique!");
                return;
            }
        }

        String citationStatus;
        if (citationCheckBox.isSelected()){
            citationStatus = "Yes";
        } else{
            citationStatus = "No";
        }

        Article article = new Article(
                titleTextField.getText(),
                authorTextField.getText(),
                articleTypeComboBox.getValue(),
                citationStatus,
                publicationDatePicker.getValue(),
                Integer.parseInt(numOfAuthorTextField.getText())
        );

        articleList.add(article);
        articleTableview.getItems().add(article);
        errorLabel.setText("Article added successfully");
    }

    @FXML
    public void showArticleWithHighestAuthorButtonMouseOnClicked(ActionEvent actionEvent) {
        Article articleWithHighestNOA = articleTableview.getItems().getFirst();
        for(Article article: articleTableview.getItems()){
            if(articleWithHighestNOA.getNumOfAuthor() < article.getNumOfAuthor()){
                articleWithHighestNOA = article;
            }
        }

        String titles = "";
        for (Article a: articleTableview.getItems()){
            if(a.getNumOfAuthor() == articleWithHighestNOA.getNumOfAuthor()){
                titles += a.getTitle() + ", ";
            }
        }
        articleTitleLabel.setText(titles);
    }
}