package com.example.midexampractice;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;
import java.util.ArrayList;

public class ArticleView
{
    @FXML
    private ComboBox<String> articleTypeComboBox;
    @FXML
    private TableColumn<Article, String> authorCol;
    @FXML
    private DatePicker publicationDatePicker;
    @FXML
    private TableColumn<Article, LocalDate> pubDateCol;
    @FXML
    private TextField titleTextField;
    @FXML
    private TableColumn<Article, Integer> noOfAuthorCol;
    @FXML
    private TableView<Article> articleTableView;
    @FXML
    private CheckBox citeStatusCheckBox;
    @FXML
    private TableColumn<Article, String> citeStatusCol;
    @FXML
    private TableColumn<Article, String> articleTypeCol;
    @FXML
    private TextField noOfAuthorTextField;
    @FXML
    private TextField authorTextField;
    @FXML
    private TableColumn<Article, String> titleCol;
    private ArrayList<Article> articleList = new ArrayList<>();
    @FXML
    private ComboBox<String> articleTypeComboBoxF;
    @FXML
    private CheckBox citeStatusCheckBoxF;
    @FXML
    private TextField firstYear;
    @FXML
    private TextField lastYear;
    @FXML
    private TextArea titleTextArea;

    @FXML
    public void initialize() {
        authorCol.setCellValueFactory(new PropertyValueFactory<>("Author"));
        titleCol.setCellValueFactory(new PropertyValueFactory<>("Title"));
        articleTypeCol.setCellValueFactory(new PropertyValueFactory<>("ArticleType"));
        citeStatusCol.setCellValueFactory(new PropertyValueFactory<>("CitationStatus"));
        noOfAuthorCol.setCellValueFactory(new PropertyValueFactory<>("NoOfAuthors"));
        pubDateCol.setCellValueFactory(new PropertyValueFactory<>("PublicationDate"));

        articleTypeComboBox.getItems().addAll("Review", "Book", "Case");
        articleTypeComboBoxF.getItems().addAll("Review", "Book", "Case");
    }

    @FXML
    public void addArticleButtonMouseOnClicked(ActionEvent actionEvent) {
        int numOfAut;
        try {
            numOfAut = Integer.parseInt(noOfAuthorTextField.getText());
        } catch (NumberFormatException e){
            System.out.println("Num of Author is not a number!");
            return;
        }

        String title = titleTextField.getText();
        for(Article a: articleList){
            if (a.getTitle().equals(title)){
                System.out.println("Duplicate Title");
                return;
            }
        }

        String citestatus;
        if (citeStatusCheckBox.isSelected()){
            citestatus = "Yes";
        } else{
            citestatus = "No";
        }
//        String title, String author, String articleType, String citationStatus, LocalDate publicationDate, int noOfAuthors
        Article a = new Article(
                titleTextField.getText(),
                authorTextField.getText(),
                articleTypeComboBox.getValue(),
                citestatus,
                publicationDatePicker.getValue(),
                numOfAut
        );

        articleList.add(a);

        articleTableView.getItems().clear();
        articleTableView.getItems().addAll(articleList);

    }

    @FXML
    public void searchArticleButton(ActionEvent actionEvent) {
        String citestatus;
        if (citeStatusCheckBoxF.isSelected()){
            citestatus = "Yes";
        } else{
            citestatus = "No";
        }
        articleTableView.getItems().clear();
        for (Article a: articleList){
            if (citestatus.equals(a.getCitationStatus()) && articleTypeComboBoxF.getValue().equals(a.getArticleType())){
                articleTableView.getItems().add(a);
            }
        }
    }

    @FXML
    public void yearFilterButton(ActionEvent actionEvent) {
        int fy = Integer.parseInt(firstYear.getText());
        int ly = Integer.parseInt(lastYear.getText());
        articleTableView.getItems().clear();
        for (Article a: articleList){
            if (a.getPublicationDate().getYear() >= fy && a.getPublicationYear() <= ly){
                articleTableView.getItems().add(a);
            }
        }
    }

    @FXML
    public void showArticleWithHighestAuthorButtonMouseOnClicked(ActionEvent actionEvent) {
        Article highestNumOfAutArticle = articleList.getFirst();
        for (Article a: articleList){
            if (highestNumOfAutArticle.getNoOfAuthors() < a.getNoOfAuthors()){
                highestNumOfAutArticle = a;
            }
        }

        String titles = "";
        for (Article a: articleList){
            if (highestNumOfAutArticle.getNoOfAuthors() == a.getNoOfAuthors()){
                 titles = titles + a.getTitle();
            }
        }

        titleTextArea.setText(titles);
    }


}