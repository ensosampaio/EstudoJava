package com.andre.projetolpoo.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainScreen {

    @FXML
    void clinicas(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/andre/projetolpoo/Views/clinicaScreen.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 1024, 768);
            Stage stage = new Stage();
            stage.setTitle("Clinicas");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void consultas(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/andre/projetolpoo/Views/consultaScreen.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 1024, 768);
            Stage stage = new Stage();
            stage.setTitle("Consultas");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void medicos(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/andre/projetolpoo/Views/medicoScreen.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 1024, 768);
            Stage stage = new Stage();
            stage.setTitle("Medicos");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    @FXML
    void pacientes(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/andre/projetolpoo/Views/pacienteScreen.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 1024, 768);
            Stage stage = new Stage();
            stage.setTitle("Pacientes");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
