package com.andre.projetolpoo.Controllers;

import com.andre.projetolpoo.Logical.TxTOperations;
import com.andre.projetolpoo.Models.Medico;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CadastrarMedico {
    String filePath = "src/main/resources/com/andre/projetolpoo/Data/Medicos.txt";
    @FXML
    private Button cadastrarMedicoButton;

    @FXML
    private TextField cpfField;

    @FXML
    private TextField crmField;

    @FXML
    private TextField especialidadeField;

    @FXML
    private TextField nomeField;

    @FXML
    private TextField telefoneField;

    @FXML
    private Label errorLabel;

    @FXML
    void cadastrarMedico(ActionEvent event) {
        if(nomeField.getText().isEmpty() || cpfField.getText().isEmpty() || crmField.getText().isEmpty() || telefoneField.getText().isEmpty() || especialidadeField.getText().isEmpty()){
            errorLabel.setText("Preencha todos os campos");
            return;
        }

        if(TxTOperations.buscarMedicoPorCPF(filePath, cpfField.getText()) != null || TxTOperations.buscarMedicoPorCRM(filePath, crmField.getText()) != null){
            errorLabel.setText("Médico já cadastrado");
            return;
        }

        Medico medico = new Medico(nomeField.getText(), cpfField.getText(), crmField.getText(), telefoneField.getText(), especialidadeField.getText());
        TxTOperations.salvarTxt(medico.toString(), filePath);
        ((Stage) cadastrarMedicoButton.getScene().getWindow()).close();
    }

}
