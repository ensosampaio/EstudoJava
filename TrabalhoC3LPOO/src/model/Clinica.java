package model;

import java.util.ArrayList;
import java.util.Arrays;


public  class Clinica {

	private String nome;
	private String cnpj;
	private String endereco;
	private String telefone;

	public Clinica(String nome, String cnpj, String endereco, String telefone) {
		super();
		this.nome = nome;
		this.cnpj = cnpj;
		this.endereco = endereco;
		this.telefone = telefone;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpnj() {
		return cnpj;
	}

	public void setCpnj(String cpnj) {
		this.cnpj = cpnj;
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
		return "Nome: " + this.nome + ", " + "CNPJ: " + this.cnpj + ", " + "Endereço: " + this.endereco + ", " + "Telefone: " + this.telefone;
	}

	public static Clinica fromString(String str) {
		ArrayList<String> parts = new ArrayList<>(Arrays.asList(str.split(", ")));

		if (parts.size() < 4) {
			System.err.println("Formato de string inválido para Clinica: " + str);
			throw new IllegalArgumentException("Formato de string inválido para Clinica");
		}

		String nome = parts.get(0).replace("Nome: ", "").trim();
		String cnpj = parts.get(1).replace("CNPJ: ", "").trim();
		String endereco = parts.get(2).replace("Endereço: ", "").trim();
		String telefone = parts.get(3).replace("Telefone: ", "").trim();

		return new Clinica(nome, cnpj, endereco, telefone);
	}

}
