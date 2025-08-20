package com.cse.oop.final_section1_1234567;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Scene1DataGenerationController
{
    @javafx.fxml.FXML
    private ComboBox<Integer> diagonalComboBox;
    @javafx.fxml.FXML
    private Text errorText;
    @javafx.fxml.FXML
    private ComboBox<String> resolutionComboBox;
    @javafx.fxml.FXML
    private TableColumn<Monitor, Integer> diagCol;
    @javafx.fxml.FXML
    private TextField priceTextField;
    @javafx.fxml.FXML
    private TextField modelTextField;
    @javafx.fxml.FXML
    private TableView<Monitor> monitorTableView;
    @javafx.fxml.FXML
    private TableColumn<Monitor, String> resCol;
    @javafx.fxml.FXML
    private TableColumn<Monitor, String> modelCol;
    @javafx.fxml.FXML
    private TableColumn<Monitor, Float> priceCol;

    @javafx.fxml.FXML
    public void initialize() {
        resolutionComboBox.getItems().addAll("HD", "HD+", "FULL-HD", "QHD");
        diagonalComboBox.getItems().addAll(17, 19, 22, 24);

        priceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
        modelCol.setCellValueFactory(new PropertyValueFactory<>("model"));
        diagCol.setCellValueFactory(new PropertyValueFactory<>("diagonal"));
        resCol.setCellValueFactory(new PropertyValueFactory<>("resolution"));
    }

    @javafx.fxml.FXML
    public void handleNextButton(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("scene2-data-processing.fxml"));
        Stage stage =(Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @javafx.fxml.FXML
    public void handleAddMonitorButton(ActionEvent actionEvent) {
        if(priceTextField.getText().isEmpty()){
            errorText.setText("Enter price");
            return;
        }

        if(modelTextField.getText().isEmpty()){
            errorText.setText("Enter Model");
            return;
        }

        if(diagonalComboBox.getValue() == null){
            errorText.setText("Select a diagonal");
            return;
        }

        if (resolutionComboBox.getValue() == null){
            errorText.setText("Select a resolution");
            return;
        }

        Monitor monitor = new Monitor(
                modelTextField.getText(),
                resolutionComboBox.getValue(),
                diagonalComboBox.getValue(),
                Float.parseFloat(priceTextField.getText())
        );

        monitorTableView.getItems().add(monitor);
    }

    @javafx.fxml.FXML
    public void handleSaveBinButton(ActionEvent actionEvent) {
        File file = new File("monitors.bin");

        try{
            boolean exist = file.exists();
            FileOutputStream fos = new FileOutputStream(file, true);
            ObjectOutputStream oos = exist ? new AppendableObjectOutputStream(fos) : new ObjectOutputStream(fos);

            for (Monitor m: monitorTableView.getItems()){
                oos.writeObject(m);
            }

            fos.close();
            oos.close();
        } catch (IOException e){
//
        }

    }
}