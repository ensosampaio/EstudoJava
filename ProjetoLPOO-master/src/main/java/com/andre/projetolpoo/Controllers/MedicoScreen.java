package com.andre.projetolpoo.Controllers;

import com.andre.projetolpoo.Logical.TxTOperations;
import com.andre.projetolpoo.Models.Medico;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class MedicoScreen implements Initializable {

    @FXML
    private TableColumn<Medico, String> colunaCPF;

    @FXML
    private TableColumn<Medico, String> colunaCRM;

    @FXML
    private TableColumn<Medico, String> colunaEspecialidade;

    @FXML
    private TableColumn<Medico, String> colunaNome;

    @FXML
    private TableColumn<Medico, String> colunaTelefone;

    @FXML
    private Button novoMedicoButton;

    @FXML
    private Button recarregarLista;

    @FXML
    private TableView<Medico> tabelaMedicos;

    @FXML
    void novoMedico(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/andre/projetolpoo/Views/cadastrarMedico.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 1024, 768);
            Stage stage = new Stage();
            stage.setTitle("Cadastrar Médico");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void recarregarLista(ActionEvent event) {
        carregarDadosNaTabela();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Configurar as colunas da tabela
        colunaNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colunaCPF.setCellValueFactory(new PropertyValueFactory<>("cpf"));
        colunaTelefone.setCellValueFactory(new PropertyValueFactory<>("telefone"));
        colunaCRM.setCellValueFactory(new PropertyValueFactory<>("crm"));
        colunaEspecialidade.setCellValueFactory(new PropertyValueFactory<>("especialidade"));

        // Preencher a tabela com os dados
        carregarDadosNaTabela();

    }

    private void carregarDadosNaTabela() {
        // Caminho do arquivo (modifique conforme necessário)
        String filePath = "src/main/resources/com/andre/projetolpoo/Data/Medicos.txt";

        // Carregar os dados do arquivo
        List<Medico> listaMedicos = TxTOperations.lerTxtMedicos(filePath);

        // Converter para ObservableList
        ObservableList<Medico> observableList = FXCollections.observableArrayList(listaMedicos);

        // Adicionar os dados à TableView
        tabelaMedicos.setItems(observableList);
    }
}
