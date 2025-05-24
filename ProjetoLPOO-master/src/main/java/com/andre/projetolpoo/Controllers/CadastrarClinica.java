package com.andre.projetolpoo.Controllers;

import com.andre.projetolpoo.Logical.TxTOperations;
import com.andre.projetolpoo.Models.Clinica;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import static com.andre.projetolpoo.Logical.TxTOperations.buscarClinicaPorCnpj;

public class CadastrarClinica {
    String filePath = "src/main/resources/com/andre/projetolpoo/Data/Clinicas.txt";

    @FXML
    private Button cadastrarClinicaButton;

    @FXML
    private TextField cnpjField;

    @FXML
    private TextField enderecoField;

    @FXML
    private TextField nomeField;

    @FXML
    private TextField telefoneField;

    @FXML
    private Label errorLabel;

    @FXML
    void cadastrarClinica(ActionEvent event) {
        if(nomeField.getText().isEmpty() || cnpjField.getText().isEmpty() || telefoneField.getText().isEmpty() || enderecoField.getText().isEmpty()){
            errorLabel.setText("Preencha todos os campos");
            return;
        }

        if(buscarClinicaPorCnpj(filePath, cnpjField.getText()) != null){
            errorLabel.setText("Clinica já cadastrada");
            return;
        }

        Clinica clinica = new Clinica(nomeField.getText(), cnpjField.getText(), telefoneField.getText(), enderecoField.getText());
        TxTOperations.salvarTxt(clinica.toString(), "src/main/resources/com/andre/projetolpoo/Data/Clinicas.txt");
        ((Stage) cadastrarClinicaButton.getScene().getWindow()).close();
    }
}
