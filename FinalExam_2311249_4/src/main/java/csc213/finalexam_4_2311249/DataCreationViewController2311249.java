package csc213.finalexam_4_2311249;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class DataCreationViewController2311249
{
    @javafx.fxml.FXML
    private TextField vehicleRegNoTextField;
    @javafx.fxml.FXML
    private TextField tagIDTextField;
    @javafx.fxml.FXML
    private TextField balanceTextField;
    @javafx.fxml.FXML
    private ComboBox<String> vehicleTypeComboBox;
    @javafx.fxml.FXML
    private CheckBox govtVehicleCheckBox;
    @javafx.fxml.FXML
    private CheckBox utilityVehicleCheckBox;

    @javafx.fxml.FXML
    public void initialize() {
        vehicleTypeComboBox.getItems().addAll("Car", "SUV", "MPV", "Bus", "Truck");
    }

    @javafx.fxml.FXML
    public void handleGoToDataProcessingViewButton(ActionEvent actionEvent) {
        try {
            FXMLLoader myFxmlLoader = new FXMLLoader(MainApplication.class.getResource("DataProcessingView2311249.fxml"));
            Scene nextScene = new Scene(myFxmlLoader.load());
            Stage nextStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            nextStage.setTitle("Data Processing View");
            nextStage.setScene(nextScene);
            nextStage.show();
        }
        catch(Exception e){
            //
        }
    }

    @javafx.fxml.FXML
    public void handleValidateAndAddNewTollPlazaVehicleTagButton(ActionEvent actionEvent) {
        if (utilityVehicleCheckBox.isSelected() && Float.parseFloat(balanceTextField.getText()) != 0){
            Alert a = new Alert(Alert.AlertType.WARNING);
            a.setContentText("For utility vehicle balance must be zero");
            a.showAndWait();
            return;
        }
//        String tagId, String vehicleRegNo, String vehicleType, float balance, boolean isUtilityVehicle, boolean isGovtVehicle
        TollPlazaVehicleTag tollPlazaVehicleTag = new TollPlazaVehicleTag(
                tagIDTextField.getText(),
                vehicleRegNoTextField.getText(),
                vehicleTypeComboBox.getValue(),
                Float.parseFloat(balanceTextField.getText()),
                utilityVehicleCheckBox.isSelected(),
                govtVehicleCheckBox.isSelected()
        );

        if (!utilityVehicleCheckBox.isSelected()){
            if(Float.parseFloat(balanceTextField.getText()) < tollPlazaVehicleTag.getTagMaintenanceFee()){
                Alert a = new Alert(Alert.AlertType.WARNING);
                a.setContentText("For non utility vehicle balance must be greater than or equal to tag maintenance fee.");
                a.showAndWait();
                return;
            }
        }

        File file = new File("tollPlazaVehicleTag.bin");
        boolean exists = file.exists();


        try {
            System.out.println("1");
            FileOutputStream fos = new FileOutputStream(file, true);
            System.out.println("2");
            ObjectOutputStream oos = file.length() == 0 || !exists ?  new ObjectOutputStream(fos) : new AppendableObjectOutputStream(fos);
            System.out.println("3");
            oos.writeObject(tollPlazaVehicleTag);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}