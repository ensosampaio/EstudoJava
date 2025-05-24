package model;

import java.util.ArrayList;
import java.util.Arrays;


public class ClinicaOdontologica extends Clinica {

	public String especializacao;

	public ClinicaOdontologica(String nome, String cnpj, String endereco, String telefone, String especializacao) {
		super(nome, cnpj, endereco, telefone);
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
		return super.toString() + ", " + "Especialização: ";
	}


	public static ClinicaOdontologica fromString(String str) {

		ArrayList<String> parte = new ArrayList<>(Arrays.asList(str.split(", ")));

		System.out.println("Debug: partes da string - " + parte);

		if (parte.size() < 5) {
			System.err.println("Formato de string inválido para Clinica Odontologica: " + str);
			throw new IllegalArgumentException("Formato de string inválido para Clinica Odontologica");
		}

		String superString = String.join(", ", parte.subList(0, 3));
		String especializacao = parte.get(4).replace("Especialização: ", "").trim();

		Clinica clinica = Clinica.fromString(superString);

		return new ClinicaOdontologica(clinica.getNome(),clinica.getCpnj(),clinica.getEndereco(),clinica.getTelefone(),especializacao);
	}
	







}
