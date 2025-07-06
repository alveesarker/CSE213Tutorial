package com.example.midterm_2311249_sec5;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;
import java.util.ArrayList;

public class ArticleController {
    @javafx.fxml.FXML
    private ComboBox<String> filteredArticleTypeComboBox;
    @javafx.fxml.FXML
    private TableColumn<Article, String> titleCol;
    @javafx.fxml.FXML
    private Label errorMsgText;
    @javafx.fxml.FXML
    private ComboBox<String> articleTypeComboBox;
    @javafx.fxml.FXML
    private TableColumn<Article, String> authorCol;
    @javafx.fxml.FXML
    private TableColumn<Article, LocalDate> pubDateCol;
    @javafx.fxml.FXML
    private TextField initYear;
    @javafx.fxml.FXML
    private TextField titleTextField;
    @javafx.fxml.FXML
    private CheckBox filteredCitationStatusCheckBox;
    @javafx.fxml.FXML
    private DatePicker publicationDataPicker;
    @javafx.fxml.FXML
    private TableColumn<Article, Integer> noOfAuthorCol;
    @javafx.fxml.FXML
    private TextArea hNoOFAuthTextArea;
    @javafx.fxml.FXML
    private TableView<Article> articleTableView;
    @javafx.fxml.FXML
    private TableColumn<Article, String> articleTypeCol;
    @javafx.fxml.FXML
    private TextField noOfAuthorTextField;
    @javafx.fxml.FXML
    private CheckBox citationStatusCheckBox;
    @javafx.fxml.FXML
    private TableColumn<Article, String> citationStatusCol;
    @javafx.fxml.FXML
    private TextField finalYear;
    @javafx.fxml.FXML
    private TextField authorTextField;
    private ArrayList<Article> articleList = new ArrayList<>();

    @javafx.fxml.FXML
    public void initialize() {
        articleTypeCol.setCellValueFactory(new PropertyValueFactory<>("articleType"));
        authorCol.setCellValueFactory(new PropertyValueFactory<>("author"));
        citationStatusCol.setCellValueFactory(new PropertyValueFactory<>("citationStatus"));
        noOfAuthorCol.setCellValueFactory(new PropertyValueFactory<>("noOfAuthor"));
        pubDateCol.setCellValueFactory(new PropertyValueFactory<>("publicationDate"));
        titleCol.setCellValueFactory(new PropertyValueFactory<>("title"));

        articleTypeComboBox.getItems().addAll("Review", "Book", "Case");
        filteredArticleTypeComboBox.getItems().addAll("Review", "Book", "Case");
    }


    @javafx.fxml.FXML
    public void handleSearchArticleButton(ActionEvent actionEvent) {
        String citStatus = "Yes";
        if (filteredCitationStatusCheckBox.isSelected()) {
            citStatus = "Yes";
        } else {
            citStatus = "No";
        }

        articleTableView.getItems().clear();
        for (Article a : articleList) {
            if (a.getArticleType().equals(filteredArticleTypeComboBox.getValue()) && a.getCitationStatus().equals(citStatus)) {
                articleTableView.getItems().add(a);
            }
        }
    }

    @javafx.fxml.FXML
    public void handleYearFilterButton(ActionEvent actionEvent) {
        articleTableView.getItems().clear();

        for (Article a : articleList) {
            if (Integer.parseInt(initYear.getText()) <= a.getPublicationDate().getYear() && Integer.parseInt(finalYear.getText()) >= a.getPublicationDate().getYear()) {
                articleTableView.getItems().add(a);
            }
        }
    }

    @javafx.fxml.FXML
    public void handleHighestNoOfAuthorButton(ActionEvent actionEvent) {
        Article highestNoOfArticle = articleList.getFirst();
        for (Article a : articleList) {
            if (a.getNoOfAuthor() > highestNoOfArticle.getNoOfAuthor()) {
                highestNoOfArticle = a;
            }
        }

        String titles = "";
        for (Article article : articleList) {
            if (highestNoOfArticle.getNoOfAuthor() == article.getNoOfAuthor()) {
                titles = titles + article.getTitle() + ", ";
            }
        }

        hNoOFAuthTextArea.setText(titles);
    }

    @javafx.fxml.FXML
    public void addArticleButtonMouseOnClicked(ActionEvent actionEvent) {
        try {
            int numOfAuthor = Integer.parseInt(noOfAuthorTextField.getText());
        } catch (Exception e) {
            errorMsgText.setText("Number of author must be number!");
            return;
        }

        for (Article a : articleList) {
            if (a.getTitle().equals(titleTextField.getText())) {
                errorMsgText.setText("Title must be unique!");
                return;
            }
        }

        String citStatus = "Yes";
        if (citationStatusCheckBox.isSelected()) {
            citStatus = "Yes";
        } else {
            citStatus = "No";
        }

        Article article = new Article(
                titleTextField.getText(),
                authorTextField.getText(),
                articleTypeComboBox.getValue(),
                citStatus,
                publicationDataPicker.getValue(),
                Integer.parseInt(noOfAuthorTextField.getText())
        );

        articleList.add(article);

        articleTableView.getItems().clear();
        for (Article a : articleList) {
            articleTableView.getItems().add(a);
        }
    }
}