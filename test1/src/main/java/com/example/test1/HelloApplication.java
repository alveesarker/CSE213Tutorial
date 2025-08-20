package com.example.test1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.*;
import java.rmi.StubNotFoundException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("create-trip-schedule-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
//        launch();
        Student s = new Student(123, "iotrtkl");
        File file = new File("data.bin");
        try {
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);

            while (true) {
                try {
                    Student student = (Student) ois.readObject();
                    System.out.println(student);
                } catch (EOFException e) {
                    break;
                }
            }
        } catch (IOException | ClassNotFoundException e) {
//            return;
        }
//        try {
//            FileOutputStream fos = new FileOutputStream(file);
//            DataOutputStream dos = new DataOutputStream(fos);
//            dos.writeInt(12);
//            dos.writeBoolean(true);
//            dos.writeFloat(4.34f);
//        } catch (IOException e){
//
//        }
//        try {
//            FileInputStream fis = new FileInputStream(file);
//            DataInputStream dis = new DataInputStream(fis);
//
//            int num = dis.readInt();
//            float num1 = dis.readFloat();
//            boolean bool = dis.readBoolean();
//            System.out.println(num);
//            System.out.println(num1);
//            System.out.println(bool);
//        } catch (IOException e){
//
//        }

//        try{
//            boolean exist = file.exists();
//            FileOutputStream fos = new FileOutputStream(file, true);
//            ObjectOutputStream oos = exist ? new AppendableObjectOutputStream(fos) : new ObjectOutputStream(fos);
//
//            oos.writeObject(s);
//            oos.close();
//            fos.close();
//
//        } catch (IOException e){
//            e.printStackTrace();
//        }

        try {
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);

            while (true) {
                try {
                    Student student = (Student) ois.readObject();
                    System.out.println(student);
                } catch (EOFException e) {
                    break;
                }
            }
        } catch (IOException | ClassNotFoundException e) {
//            throw new RuntimeException(e);
        }
    }
}