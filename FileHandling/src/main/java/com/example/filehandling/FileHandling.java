package com.example.filehandling;

import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.io.*;

public class FileHandling {
    @javafx.fxml.FXML
    private Text resultText;
    @javafx.fxml.FXML
    private TextField num1TextField;
    @javafx.fxml.FXML
    private TextField num2TextField;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void handleAddButton(ActionEvent actionEvent) {
        int result = Integer.parseInt(num1TextField.getText()) + Integer.parseInt(num2TextField.getText());
        resultText.setText(Integer.toString(result));
    }

    @javafx.fxml.FXML
    public void handleAddToFileButton(ActionEvent actionEvent) {
        History history = new History(
                Integer.parseInt(num1TextField.getText()),
                Integer.parseInt(num2TextField.getText()),
                Integer.parseInt(num1TextField.getText()) + Integer.parseInt(num2TextField.getText())
        );

//        "data/history.bin"
        File file = new File("data/history.bin");
        try {
            boolean exists = file.exists();
            FileOutputStream fos = new FileOutputStream(file, true);



            ObjectOutputStream oos = exists? new AppendableObjectOutputStream(fos) : new ObjectOutputStream(fos);
            oos.writeObject(history);
            oos.close();
            System.out.println("Object stored successfully!");
        } catch (IOException e) {
            System.out.println("Failed to write object!");
        }

    }

    @javafx.fxml.FXML
    public void handleReadFile(ActionEvent actionEvent) {
        File file = new File("data/history.bin");
        try {
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);


            while (true){
                try {
                    History history = (History) ois.readObject();
                    System.out.println(history);
                } catch (EOFException e){
                    System.out.println("File read successfully");
                    break;
                }
            }

        } catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}