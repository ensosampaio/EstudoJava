package com.andre.projetolpoo.Controllers;

import com.andre.projetolpoo.Logical.TxTOperations;
import com.andre.projetolpoo.Models.Consulta;
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

public class ConsultaScreen implements Initializable {

    @FXML
    private Button agendarConsultaButton;

    @FXML
    private TableColumn<Consulta, String>colunaClinica;

    @FXML
    private TableColumn<Consulta, String> colunaData;

    @FXML
    private TableColumn<Consulta, String> colunaHora;

    @FXML
    private TableColumn<Consulta, String> colunaMedico;

    @FXML
    private TableColumn<Consulta, String> colunaPaciente;

    @FXML
    private Button recarregarLista;

    @FXML
    private TableView<Consulta> tabelaConsultas;

    @FXML
    void agendarConsulta(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/andre/projetolpoo/Views/marcarConsulta.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 1024, 768);
            Stage stage = new Stage();
            stage.setTitle("Marcar Consulta");
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
        colunaPaciente.setCellValueFactory(new PropertyValueFactory<>("paciente"));
        colunaMedico.setCellValueFactory(new PropertyValueFactory<>("medico"));
        colunaClinica.setCellValueFactory(new PropertyValueFactory<>("clinica"));
        colunaData.setCellValueFactory(new PropertyValueFactory<>("data"));
        colunaHora.setCellValueFactory(new PropertyValueFactory<>("hora"));
        // Preencher a tabela com os dados
        carregarDadosNaTabela();
    }

    private void carregarDadosNaTabela() {
        // Caminho do arquivo (modifique conforme necessário)
        String filePath = "src/main/resources/com/andre/projetolpoo/Data/Consultas.txt";

        // Carregar os dados do arquivo
        List<Consulta> listaConsulta = TxTOperations.lerTxtConsultas(filePath);

        // Converter para ObservableList
        ObservableList<Consulta> observableList = FXCollections.observableArrayList(listaConsulta);

        // Adicionar os dados à TableView
        tabelaConsultas.setItems(observableList);
    }
}
