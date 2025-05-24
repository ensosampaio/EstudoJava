package model;

import java.util.ArrayList;
import java.util.Arrays;

public class ClinicaHospitalar extends Clinica {

	public String especializacao;

	public ClinicaHospitalar(String nome, String cpnj, String endereco, String telefone, String especializacao) {
		super(nome, cpnj, endereco, telefone);
		this.especializacao = especializacao;

	}

	public String getEspecializacao() {
		return especializacao;
	}

	public void setEspecializacao(String especializacao) {
		this.especializacao = especializacao;
	}

	@Override
	public String toString() {
		return super.toString() + ", " + "Especialização: " + this.especializacao;
	}

	public static ClinicaHospitalar fromString(String str) {

		ArrayList<String> parte = new ArrayList<>(Arrays.asList(str.split(", ")));

		System.out.println("Debug: partes da string - " + parte);

		if (parte.size() < 4) {
			System.err.println("Formato de string inválido para Clinica Odontologica: " + str);
			throw new IllegalArgumentException("Formato de string inválido para Clinica Odontologica");
		}

		String superString = String.join(", ", parte.subList(0, 3));
		String especializacao = parte.get(4).replace("Especialização: ", "").trim();

		Clinica clinica = Clinica.fromString(superString);

		return new ClinicaHospitalar(clinica.getNome(),clinica.getCpnj(),clinica.getEndereco(),clinica.getTelefone(),especializacao);
	}
	






}
