package com.cse.oop.final_section1_1234567;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.event.ActionEvent;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.*;

public class Scene2DataProcessingController
{
    @javafx.fxml.FXML
    private Text errorText;
    @javafx.fxml.FXML
    private TableColumn<Monitor, Integer> diagCol;
    @javafx.fxml.FXML
    private TableView<Monitor> monitorTableView;
    @javafx.fxml.FXML
    private TableColumn<Monitor, String> resCol;
    @javafx.fxml.FXML
    private TableColumn<Monitor, String> modelCol;
    @javafx.fxml.FXML
    private TableColumn<Monitor, Integer> ppiCol;
    @javafx.fxml.FXML
    private TableColumn<Monitor, Float> priceCol;

    @javafx.fxml.FXML
    public void initialize() {
        priceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
        modelCol.setCellValueFactory(new PropertyValueFactory<>("model"));
        diagCol.setCellValueFactory(new PropertyValueFactory<>("diagonal"));
        resCol.setCellValueFactory(new PropertyValueFactory<>("resolution"));
        ppiCol.setCellValueFactory(new PropertyValueFactory<>("ppi"));
    }

    @javafx.fxml.FXML
    public void handleBackButton(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("scene1-data-generation.fxml"));
        Stage stage =(Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @javafx.fxml.FXML
    public void handleLoadBinData(ActionEvent actionEvent) {
        File file = new File("monitors.bin");
        try{
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);

            while (true){
                try{
                    Monitor m = (Monitor) ois.readObject();
                    monitorTableView.getItems().add(m);
                } catch (EOFException e){
                    break;
                }
            }
        } catch (IOException | ClassNotFoundException e){
//
        }
    }
}