package com.andre.projetolpoo.Controllers;

import com.andre.projetolpoo.Logical.TxTOperations;
import com.andre.projetolpoo.Models.Clinica;
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

public class ClinicaScreen implements Initializable {

    @FXML
    private TableColumn<Clinica, String> colunaCnpj;

    @FXML
    private TableColumn<Clinica, String> colunaEndereco;

    @FXML
    private TableColumn<Clinica, String> colunaNome;

    @FXML
    private TableColumn<Clinica, String> colunaTelefone;

    @FXML
    private Button novaClinicaButton;

    @FXML
    private Button recarregarLista;

    @FXML
    private TableView<Clinica> tabelaClinicas;


    @FXML
    void novaClinica(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/andre/projetolpoo/Views/cadastrarClinica.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 1024, 768);
            Stage stage = new Stage();
            stage.setTitle("Cadastrar Clinica");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Configurar as colunas da tabela
        colunaNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colunaCnpj.setCellValueFactory(new PropertyValueFactory<>("cnpj"));
        colunaTelefone.setCellValueFactory(new PropertyValueFactory<>("telefone"));
        colunaEndereco.setCellValueFactory(new PropertyValueFactory<>("endereco"));

        // Preencher a tabela com os dados
        carregarDadosNaTabela();
    }

    private void carregarDadosNaTabela() {
        // Caminho do arquivo (modifique conforme necessário)
        String filePath = "src/main/resources/com/andre/projetolpoo/Data/Clinicas.txt";

        // Carregar os dados do arquivo
        List<Clinica> listaClinicas = TxTOperations.lerTxtClinicas(filePath);

        // Converter para ObservableList
        ObservableList<Clinica> observableList = FXCollections.observableArrayList(listaClinicas);

        // Adicionar os dados à TableView
        tabelaClinicas.setItems(observableList);
    }

    @FXML
    void recarregarLista(ActionEvent event) {
        carregarDadosNaTabela();
    }
}
