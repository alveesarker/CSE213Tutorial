package csc213.finalexam_4_2311249;

import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DataProcessingViewController2311249
{
    @javafx.fxml.FXML
    private TableColumn<TollPlazaVehicleTag, Boolean> isGovtVehcleCol;
    @javafx.fxml.FXML
    private TableColumn<TollPlazaVehicleTag, Boolean> isUtilityVehicleCol;
    @javafx.fxml.FXML
    private TableView<TollPlazaVehicleTag> tollPlazaVehicleTagTableView;
    @javafx.fxml.FXML
    private TableColumn<TollPlazaVehicleTag, String> tagIDCol;
    @javafx.fxml.FXML
    private TableColumn<TollPlazaVehicleTag, String> vehicleRegNoCol;
    @javafx.fxml.FXML
    private TableColumn<TollPlazaVehicleTag, Float> balanceCol;
    @javafx.fxml.FXML
    private ComboBox<String> vehicleTypeComboBox;
    @javafx.fxml.FXML
    private TableColumn<TollPlazaVehicleTag, String> vehicleTypeCol;
    @javafx.fxml.FXML
    private TableColumn<TollPlazaVehicleTag, Float> tagMaintenanceFeeCol;

    @javafx.fxml.FXML
    public void initialize() {
        vehicleTypeComboBox.getItems().addAll("Car", "SUV", "MPV", "Bus", "Truck");

        balanceCol.setCellValueFactory(new PropertyValueFactory<>("balance"));
        isGovtVehcleCol.setCellValueFactory(new PropertyValueFactory<>("govtVehicle"));
        isUtilityVehicleCol.setCellValueFactory(new PropertyValueFactory<>("utilityVehicle"));
        tagIDCol.setCellValueFactory(new PropertyValueFactory<>("tagId"));
        vehicleRegNoCol.setCellValueFactory(new PropertyValueFactory<>("vehicleRegNo"));
        vehicleTypeCol.setCellValueFactory(new PropertyValueFactory<>("vehicleType"));
        tagMaintenanceFeeCol.setCellValueFactory(new PropertyValueFactory<>("tagMaintenanceFee"));
    }

    @javafx.fxml.FXML
    public void handleLoadTableWithTollPlazaVehicleTagButton(ActionEvent actionEvent) {
        tollPlazaVehicleTagTableView.getItems().clear();
        try{
            FileInputStream fis = new FileInputStream("tollPlazaVehicleTag.bin");
            ObjectInputStream ois = new ObjectInputStream(fis);
            while (true){
                try{
                    TollPlazaVehicleTag tpvt = (TollPlazaVehicleTag) ois.readObject();
                    if(vehicleTypeComboBox.getValue().equals(tpvt.getVehicleType()) && !(tpvt.isGovtVehicle() && tpvt.isUtilityVehicle())){
                        tollPlazaVehicleTagTableView.getItems().add(tpvt);
                    }
                } catch (EOFException e){
                    break;
                }
            }

        } catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}