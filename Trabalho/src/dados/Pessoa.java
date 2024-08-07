package dados;

import java.util.ArrayList;
import java.util.Arrays;

public class Pessoa {
	private String nomePessoa;
	private String cpf;
	private String endereco;
	private int idade;

	public Pessoa(String nomePessoa, String cpf, String endereco, int idade) {
		this.nomePessoa = nomePessoa;
		this.cpf = cpf;
		this.endereco = endereco;
		this.idade = idade;
	}

	public Pessoa() {
		this.nomePessoa = " ";
		this.cpf = " ";
		this.endereco = " ";
		this.idade = 0;
	}

	public String getNomePessoa() {
		return nomePessoa;
	}

	public void setNomePessoa(String nomePessoa) {
		this.nomePessoa = nomePessoa;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	@Override
	public String toString() {
		return "Nome: " + nomePessoa + ", " + "CPF: " + cpf + ", " + "Endereço: " + endereco + ", " + "Idade: " + idade;
	}

	public static Pessoa fromString(String str) {
		ArrayList<String> parts = new ArrayList<>(Arrays.asList(str.split(", ")));

		if (parts.size() < 4) {
			System.err.println("Formato de string inválido para Pessoa: " + str);
			throw new IllegalArgumentException("Formato de string inválido para Pessoa");
		}

		String nomePessoa = parts.get(0).replace("Nome: ", "").trim();
		String cpf = parts.get(1).replace("CPF: ", "").trim();
		String endereco = parts.get(2).replace("Endereço: ", "").trim();
		int idade = Integer.parseInt(parts.get(3).replace("Idade: ", "").trim());

		return new Pessoa(nomePessoa, cpf, endereco, idade);
	}
}