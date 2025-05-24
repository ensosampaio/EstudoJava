package com.andre.projetolpoo.Controllers;

import com.andre.projetolpoo.Logical.TxTOperations;
import com.andre.projetolpoo.Models.Medico;
import com.andre.projetolpoo.Models.Paciente;
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

public class PacienteScreen implements Initializable {

    @FXML
    private TableColumn<Paciente, String> colunaAlergias;

    @FXML
    private TableColumn<Paciente, String> colunaCPF;

    @FXML
    private TableColumn<Paciente, String> colunaConvenio;

    @FXML
    private TableColumn<Paciente, String> colunaNome;

    @FXML
    private TableColumn<Paciente, String> colunaObservacoes;

    @FXML
    private TableColumn<Paciente, String> colunaTelefone;

    @FXML
    private TableColumn<Paciente, String> colunaTipoSanguinio;

    @FXML
    private Button novoPacienteButton;

    @FXML
    private Button recarregarLista;

    @FXML
    private TableView<Paciente> tabelaPacientes;

    @FXML
    void novoPaciente(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/andre/projetolpoo/Views/cadastrarPaciente.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 1024, 768);
            Stage stage = new Stage();
            stage.setTitle("Cadastrar Paciente");
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
        colunaNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colunaCPF.setCellValueFactory(new PropertyValueFactory<>("cpf"));
        colunaTelefone.setCellValueFactory(new PropertyValueFactory<>("telefone"));
        colunaConvenio.setCellValueFactory(new PropertyValueFactory<>("convenio"));
        colunaTipoSanguinio.setCellValueFactory(new PropertyValueFactory<>("tipoSanguineo"));
        colunaAlergias.setCellValueFactory(new PropertyValueFactory<>("alergias"));
        colunaObservacoes.setCellValueFactory(new PropertyValueFactory<>("observacoes"));

        carregarDadosNaTabela();
    }

    private void carregarDadosNaTabela() {
        // Caminho do arquivo (modifique conforme necessário)
        String filePath = "src/main/resources/com/andre/projetolpoo/Data/Pacientes.txt";

        // Carregar os dados do arquivo
        List<Paciente> listaPacientes = TxTOperations.lerTxtPacientes(filePath);

        // Converter para ObservableList
        ObservableList<Paciente> observableList = FXCollections.observableArrayList(listaPacientes);

        // Adicionar os dados à TableView
        tabelaPacientes.setItems(observableList);
    }
}
