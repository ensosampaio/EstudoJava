package com.andre.projetolpoo.Controllers;

import com.andre.projetolpoo.Logical.TxTOperations;
import com.andre.projetolpoo.Models.Clinica;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        Clinica clinica = new Clinica("Clincia", "123456789", "123456789", "Rua 1");
        TxTOperations.salvarTxt(clinica.toString(), "src/main/resources/com/andre/projetolpoo/Data/Clinicas.txt");
    }
}