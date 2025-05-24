package com.andre.projetolpoo.Controllers;

import com.andre.projetolpoo.Logical.TxTOperations;
import com.andre.projetolpoo.Models.Paciente;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class CadastrarPaciente {
    String filePath = "src/main/resources/com/andre/projetolpoo/Data/Pacientes.txt";

    @FXML
    private TextField alergiasField;

    @FXML
    private Button cadastrarPacienteButton;

    @FXML
    private TextField convenioField;

    @FXML
    private TextField cpfField;

    @FXML
    private TextField nomeField;

    @FXML
    private TextField observacoesField;

    @FXML
    private TextField telefoneField;

    @FXML
    private TextField tipoSanguinioField;

    @FXML
    private Label errorLabel;

    @FXML
    void cadastrarPaciente(ActionEvent event) {
        if(nomeField.getText().isEmpty() || cpfField.getText().isEmpty() || telefoneField.getText().isEmpty() || alergiasField.getText().isEmpty() || convenioField.getText().isEmpty() || observacoesField.getText().isEmpty() || tipoSanguinioField.getText().isEmpty()){
            errorLabel.setText("Preencha todos os campos");
            return;
        }

        if(TxTOperations.buscarPacientePorCpf(filePath, cpfField.getText()) != null){
            errorLabel.setText("Paciente já cadastrado");
            return;
        }

        Paciente paciente = new Paciente(nomeField.getText(), cpfField.getText(), telefoneField.getText(), alergiasField.getText(), convenioField.getText(), observacoesField.getText(), tipoSanguinioField.getText());
        TxTOperations.salvarTxt(paciente.toString(), filePath);
        ((Stage) cadastrarPacienteButton.getScene().getWindow()).close();
    }

}
