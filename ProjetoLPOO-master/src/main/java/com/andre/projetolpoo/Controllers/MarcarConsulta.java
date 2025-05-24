package com.andre.projetolpoo.Controllers;

import com.andre.projetolpoo.Logical.TxTOperations;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import com.andre.projetolpoo.Models.Consulta;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;


public class MarcarConsulta implements Initializable {

    @FXML
    private ChoiceBox<String> clinicaChoiceBox;

    @FXML
    private DatePicker data;

    @FXML
    private TextField hora;

    @FXML
    private ChoiceBox<String> medicoChoiceBox;

    @FXML
    private ChoiceBox<String> pacienteChoiceBox;

    @FXML
    private Label errorLabel;

    @FXML
    void marcarConulta(ActionEvent event) {
        if(pacienteChoiceBox.getValue() == null || medicoChoiceBox.getValue() == null || clinicaChoiceBox.getValue() == null || data.getValue() == null || hora.getText().isEmpty()){
            errorLabel.setText("Preencha todos os campos");
            return;
        }

        if(hora.getLength() != 5 || hora.getText().charAt(2) != ':'){
            errorLabel.setText("Hora inválida, por favor digite no formato HH:MM");
            return;
        }


        System.out.println(data.getValue().getDayOfMonth() + "-" + data.getValue().getMonthValue() + "-" + data.getValue().getYear());
        Consulta consulta = new Consulta(pacienteChoiceBox.getValue(), medicoChoiceBox.getValue(), clinicaChoiceBox.getValue(), data.getValue().getDayOfMonth() + "-" + data.getValue().getMonthValue() + "-" + data.getValue().getYear(), hora.getText());
        TxTOperations.salvarTxt(consulta.toString(), "src/main/resources/com/andre/projetolpoo/Data/Consultas.txt");
        ((Stage) errorLabel.getScene().getWindow()).close();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        pacienteChoiceBox.getItems().addAll(TxTOperations.armazenarNomesPaciente());
        medicoChoiceBox.getItems().addAll(TxTOperations.armazenarNomesMedico());
        clinicaChoiceBox.getItems().addAll(TxTOperations.armazenarNomesClinica());
    }
}
