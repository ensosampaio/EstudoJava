package control;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import model.ClinicaHospitalar;

public class ClinicaHospitalarController {

	private List<ClinicaHospitalar> hospitais;
	private String arquivoHospital;

	public ClinicaHospitalarController(String arquivoHospital) {
		this.hospitais = new ArrayList<ClinicaHospitalar>();
		this.arquivoHospital = arquivoHospital;
		carregarDoArquivo();
	}

	public boolean cadastrarHospitais(ClinicaHospitalar hospital) {
		hospitais.add(hospital);
		salvarNoArquivo();
		return true;
	}

	public ClinicaHospitalar buscarPorCNPJ(String cpnj) {
		for (ClinicaHospitalar clinica : hospitais) {
			if (clinica.getCpnj().equals(cpnj)) {
				return clinica;
			}
		}
		return null;
	}

	public String atualizarHospital(String cpnj, String novoNome, String novoEndereco, String novoTelefone,
			String novaEspecializacao) {
		ClinicaHospitalar clinica = buscarPorCNPJ(cpnj);
		if (clinica != null) {
			clinica.setNome(novoNome);
			clinica.setEndereco(novoEndereco);
			clinica.setTelefone(novoTelefone);
			clinica.setEspecializacao(novaEspecializacao);
			salvarNoArquivo();
			return "Hospital " + clinica.getNome() + " atualizada com sucesso!";
		}
		return "Não foi possível atualizar";
	}

	public boolean removerClinica(String cnpj) {
		ClinicaHospitalar clinica = buscarPorCNPJ(cnpj);
		if (clinica != null) {
			hospitais.remove(clinica);
			salvarNoArquivo();
			return true;
		} else {
			return false;
		}
	}

	public List<ClinicaHospitalar> getHospital() {
		return hospitais;
	}

	private void carregarDoArquivo() {
		try (BufferedReader ler = new BufferedReader(new FileReader(arquivoHospital))) {
			String linha;
			StringBuilder clinicaString = new StringBuilder();
			while ((linha = ler.readLine()) != null) {

				if (linha.trim().isEmpty()) {
					if (clinicaString.length() > 0) {

						ClinicaHospitalar clinica = ClinicaHospitalar.fromString(clinicaString.toString().trim());
						hospitais.add(clinica);
						clinicaString.setLength(0);
					}
				} else {

					clinicaString.append(linha).append("\n");
				}
			}

			if (clinicaString.length() > 0) {
				ClinicaHospitalar clinica = ClinicaHospitalar.fromString(clinicaString.toString().trim());
				hospitais.add(clinica);
			}

		} catch (IOException e) {
			System.err.println("Erro ao ler o arquivo de hospitais: " + e.getMessage());
		}
	}

	private void salvarNoArquivo() {
		try (BufferedWriter escrever = new BufferedWriter(new FileWriter(arquivoHospital))) {
			for (ClinicaHospitalar clinica : hospitais) {

				escrever.write(clinica.toString());
				escrever.newLine();
				escrever.newLine();
			}
		} catch (IOException e) {
			System.err.println("Erro ao escrever no arquivo de hospitais: " + e.getMessage());
		}
	}

}
