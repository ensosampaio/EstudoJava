package control;

import model.Paciente;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PacienteController {

	private List<Paciente> pacientes;
	private String arquivoPaciente;

	public PacienteController(String arquivoPaciente) {
		this.pacientes = new ArrayList<Paciente>();
		this.arquivoPaciente = arquivoPaciente;
		carregarDoArquivo();
	}

	public boolean cadastrar(Paciente paciente) {
		pacientes.add(paciente);
		salvarNoArquivo();
		return true;

	}

	public Paciente procurarPorCpf(String cpf) {
		for (Paciente paciente : pacientes) {
			if (paciente.getCpf().equals(cpf)) {
				return paciente;
			}
		}

		return null;
	}

	public String atualizarPaciente(String nome, int idade, String cpf, String historico, String endereco,
			String telefone) {

		Paciente paciente = procurarPorCpf(cpf);

		if (paciente != null) {
			paciente.setNome(nome);
			paciente.setIdade(idade);
			paciente.setHistorico(historico);
			paciente.setEndereco(endereco);
			paciente.setTelefone(telefone);
			salvarNoArquivo();
			return "Paciente" + paciente.getNome() + " atualizado com sucesso!";
		} else {
			return "Não foi possivel atualizar paciente";
		}
	}

	public boolean deletar(String cpf) {
		Paciente paciente = procurarPorCpf(cpf);
		if (paciente != null) {
			pacientes.remove(paciente);
			salvarNoArquivo();
			return true;
		} else {
			return false;
		}
	}

	public List<Paciente> getPaciente() {
		return pacientes;
	}

	private void carregarDoArquivo() {
		try (BufferedReader ler = new BufferedReader(new FileReader(arquivoPaciente))) {
			String linha;
			StringBuilder pacienteString = new StringBuilder();
			while ((linha = ler.readLine()) != null) {

				if (linha.trim().isEmpty()) {
					if (pacienteString.length() > 0) {

						Paciente paciente = Paciente.fromString(pacienteString.toString().trim());
						pacientes.add(paciente);
						pacienteString.setLength(0);
					}
				} else {

					pacienteString.append(linha).append("\n");
				}
			}

			if (pacienteString.length() > 0) {
				Paciente paciente = Paciente.fromString(pacienteString.toString().trim());
				pacientes.add(paciente);
			}

		} catch (IOException e) {
			System.err.println("Erro ao ler o arquivo de pacientes: " + e.getMessage());
		}
	}

	private void salvarNoArquivo() {
		try (BufferedWriter escrever = new BufferedWriter(new FileWriter(arquivoPaciente))) {
			for (Paciente paciente : pacientes) {

				escrever.write(paciente.toString());
				escrever.newLine();
				escrever.newLine();
			}
		} catch (IOException e) {
			System.err.println("Erro ao escrever no arquivo de pacientes: " + e.getMessage());
		}
	}

}
