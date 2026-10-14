package com.example.practicemid;

import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;
import java.util.ArrayList;

public class ArticleViewController {
    @javafx.fxml.FXML
    private TableColumn<Article, String> titleCol;
    @javafx.fxml.FXML
    private CheckBox searchCitationStatusCheckBox;
    @javafx.fxml.FXML
    private ComboBox<String> articleTypeComboBox;
    @javafx.fxml.FXML
    private TableColumn<Article, String> authorCom;
    @javafx.fxml.FXML
    private TextField firstYearTextField;
    @javafx.fxml.FXML
    private DatePicker publicationDateDatePicker;
    @javafx.fxml.FXML
    private Label errorMessage;
    @javafx.fxml.FXML
    private TextField lastYearTextField;
    @javafx.fxml.FXML
    private TextArea hNoOfAuthorTextArea;
    @javafx.fxml.FXML
    private TextField titleTextField;
    @javafx.fxml.FXML
    private TableColumn<Article, Integer> noOfAuthorCol;
    @javafx.fxml.FXML
    private ComboBox<String> searchArticleTypeComboBox;
    @javafx.fxml.FXML
    private TableView<Article> articleTableView;
    @javafx.fxml.FXML
    private TableColumn<Article, String> articleTypeCol;
    @javafx.fxml.FXML
    private TextField noOfAuthorTextField;
    @javafx.fxml.FXML
    private TableColumn<Article, LocalDate> publicationDateCol;
    @javafx.fxml.FXML
    private CheckBox citationStatusCheckBox;
    @javafx.fxml.FXML
    private TableColumn<Article, String> citationStatusCol;
    @javafx.fxml.FXML
    private TextField authorTextField;
    private ArrayList<Article> articleList = new ArrayList<>();

    @javafx.fxml.FXML
    public void initialize() {
        articleTypeCol.setCellValueFactory(new PropertyValueFactory<>("articleType"));
        citationStatusCol.setCellValueFactory(new PropertyValueFactory<>("citationStatus"));
        noOfAuthorCol.setCellValueFactory(new PropertyValueFactory<>("noOfAuthor"));
        publicationDateCol.setCellValueFactory(new PropertyValueFactory<>("publicationDate"));
        titleCol.setCellValueFactory(new PropertyValueFactory<>("title"));
        authorCom.setCellValueFactory(new PropertyValueFactory<>("author"));

        articleTypeComboBox.getItems().addAll("Review", "Book", "Case");
        searchArticleTypeComboBox.getItems().addAll("Review", "Book", "Case");
    }

    @javafx.fxml.FXML
    public void handleSearchArticleButton() {
        articleTableView.getItems().clear();

        String cs = "";
        if (searchCitationStatusCheckBox.isSelected()) {
            cs = "Yes";
        } else {
            cs = "No";
        }

        for( Article article: articleList){
            if (searchArticleTypeComboBox.getValue().equals(article.getArticleType()) && cs.equals(article.getCitationStatus())){
                articleTableView.getItems().add(article);
            }
        }
    }

    @javafx.fxml.FXML
    public void handleYearFilterButton() {
        articleTableView.getItems().clear();

        for( Article article: articleList){
            if (Integer.parseInt(firstYearTextField.getText()) <= article.getPublicationYear() && Integer.parseInt(lastYearTextField.getText()) >= article.getPublicationYear()){
                articleTableView.getItems().add(article);
            }
        }
    }

    @javafx.fxml.FXML
    public void addArticleButtonMouseOnClicked() {
//
//        String title, String author, String articleType, LocalDate publicationDate, String citationStatus, int noOfAuthor
        try {
            int no_of_author = Integer.parseInt(noOfAuthorTextField.getText());
        } catch (Exception e){
            errorMessage.setText("No of author must be a number!");
            return;
        }

        for ( Article article : articleList ){
            if (article.getTitle().equals(titleTextField.getText())){
                errorMessage.setText("Title is duplicate");
                return;
            }
        }

        String cs = "";
        if (citationStatusCheckBox.isSelected()) {
            cs = "Yes";
        } else {
            cs = "No";
        }



        Article a = new Article(
                titleTextField.getText(),
                authorTextField.getText(),
                articleTypeComboBox.getValue(),
                publicationDateDatePicker.getValue(),
                cs,
                Integer.parseInt(noOfAuthorTextField.getText())
        );

        articleList.add(a);
        articleTableView.getItems().clear();
        articleTableView.getItems().addAll(articleList);

        errorMessage.setText("Article added successfully.");

    }

    @javafx.fxml.FXML
    public void showArticleWithHighestAuthorButtonMouseOnClickedshowArticleWithHighestAuthorButtonMouseOnClicked() {
        Article h_n_a_article = articleList.getFirst();
        for ( Article article: articleList){
            if (h_n_a_article.getNoOfAuthor() < article.getNoOfAuthor()){
                h_n_a_article = article;
            }
        }

        hNoOfAuthorTextArea.setText(h_n_a_article.getTitle());
    }
}