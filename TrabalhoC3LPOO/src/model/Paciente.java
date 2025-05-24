package model;

import java.util.ArrayList;
import java.util.Arrays;

public class Paciente {

	private String nome;
	private int idade;
	private String cpf;
	private String historico;
	private String endereco;
	private String telefone;

	public Paciente(String nome, int idade, String cpf, String historico, String endereco, String telefone) {
		super();
		this.nome = nome;
		this.idade = idade;
		this.cpf = cpf;
		this.historico = historico;
		this.endereco = endereco;
		this.telefone = telefone;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getHistorico() {
		return historico;
	}

	public void setHistorico(String historico) {
		this.historico = historico;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	@Override
	public String toString() {
		return "Nome: " + this.nome + ", " + "Idade: " + this.idade + ", " + "CPF: " + this.cpf + ", " + "Historico: "
				+ this.historico + ", " + "Endereço: " + this.endereco + ", " + "Telefone: " + this.telefone;
	}

	public static Paciente fromString(String str) {
		ArrayList<String> parts = new ArrayList<>(Arrays.asList(str.split(", ")));

		if (parts.size() < 5) {
			System.err.println("Formato de string inválido para Clinica: " + str);
			throw new IllegalArgumentException("Formato de string inválido para Clinica");
		}

		String nome = parts.get(0).replace("Nome: ", "").trim();
		int idade = Integer.parseInt(parts.get(1).replace("Idade: ", "").trim());
		String cpf = parts.get(2).replace("CPF: ", "").trim();
		String historico = parts.get(3).replace("Historico: ", "").trim();
		String endereco = parts.get(4).replace("Endereço: ", "").trim();
		String telefone = parts.get(5).replace("Telefone: ", "").trim();

		return new Paciente(nome, idade, cpf, historico, endereco, telefone);
	}

}
