package control;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import model.ClinicaOdontologica;

public class ClinicaOdontologicaController {

	private List<ClinicaOdontologica> odontologia;
	private String arquivoOdontologia;

	public ClinicaOdontologicaController(String arquivoOdontologia) {
		this.odontologia = new ArrayList<ClinicaOdontologica>();
		this.arquivoOdontologia = arquivoOdontologia;
		carregarDoArquivo();
	}

	public boolean cadastrarClinicaOdontologica(ClinicaOdontologica odonto) {
		odontologia.add(odonto);
		salvarNoArquivo();
		return true;
	}

	public ClinicaOdontologica buscarPorCnpj(String cnpj) {
		for (ClinicaOdontologica clinica : odontologia) {
			if (clinica.getCpnj().equals(cnpj)) {
				return clinica;
			}
		}
		return null;
	}

	public String atualizarOdontologia(String cnpj, String novoNome, String novoEndereco, String novoTelefone,
			String novaEspecializacao) {

		ClinicaOdontologica clinica = buscarPorCnpj(cnpj);

		if (clinica != null) {
			clinica.setNome(novoNome);
			clinica.setEndereco(novoEndereco);
			clinica.setTelefone(novoTelefone);
			clinica.setEspecializacao(novaEspecializacao);
			salvarNoArquivo();
			return "Clinica Odontologica " + clinica.getNome() + " atualizada com sucesso!";
		}
		return "Não foi possível atualizar";
	}

	public boolean removerClinica(String cnpj) {
		ClinicaOdontologica clinica = buscarPorCnpj(cnpj);
		if (clinica != null) {
			odontologia.remove(clinica);
			salvarNoArquivo();
			return true;
		} else {
			return false;
		}
	}

	public List<ClinicaOdontologica> getOdontologia() {
		return odontologia;
	}

	private void carregarDoArquivo() {
		try (BufferedReader ler = new BufferedReader(new FileReader(arquivoOdontologia))) {
			String linha;
			StringBuilder clinicaString = new StringBuilder();
			while ((linha = ler.readLine()) != null) {

				if (linha.trim().isEmpty()) {
					if (clinicaString.length() > 0) {

						ClinicaOdontologica clinica = ClinicaOdontologica.fromString(clinicaString.toString().trim());
						odontologia.add(clinica);
						clinicaString.setLength(0);
					}
				} else {

					clinicaString.append(linha).append("\n");
				}
			}

			if (clinicaString.length() > 0) {
				ClinicaOdontologica clinica = ClinicaOdontologica.fromString(clinicaString.toString().trim());
				odontologia.add(clinica);
			}

		} catch (IOException e) {
			System.err.println("Erro ao ler o arquivo de clientes: " + e.getMessage());
		}
	}

	private void salvarNoArquivo() {
		try (BufferedWriter escrever = new BufferedWriter(new FileWriter(arquivoOdontologia))) {
			for (ClinicaOdontologica clinica : odontologia) {

				escrever.write(clinica.toString());
				escrever.newLine();
				escrever.newLine();
			}
		} catch (IOException e) {
			System.err.println("Erro ao escrever no arquivo de clientes: " + e.getMessage());
		}
	}

}
