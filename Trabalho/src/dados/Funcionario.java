package dados;

import java.util.ArrayList;
import java.util.Arrays;

public class Funcionario extends Pessoa {

	private double salario;
	private String cargo;
	private int codigoFuncionario;

	public Funcionario(String nomePessoa, String cpf, String endereco, int idade, double salario, String cargo,
			int codigoFuncionario) {
		super(nomePessoa, cpf, endereco, idade);
		this.salario = salario;
		this.cargo = cargo;
		this.codigoFuncionario = codigoFuncionario;
	}

	public Funcionario() {
		super();
		this.salario = 0;
		this.cargo = " ";
		this.codigoFuncionario = 0;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public int getCodigoFuncionario() {
		return codigoFuncionario;
	}

	public void setCodigoFuncionario(int codigoFuncionario) {
		this.codigoFuncionario = codigoFuncionario;
	}

	@Override
	public String toString() {
		return super.toString() + ", " + "Salario: R$" + salario + ", " + "Cargo: " + cargo + ", "
				+ "Codigo funcionario: " + codigoFuncionario;
	}

	public static Funcionario fromString(String str) {
		ArrayList<String> parte = new ArrayList<>(Arrays.asList(str.split(", ")));

		System.out.println("Debug: partes da string - " + parte);

		if (parte.size() < 7) { 
			System.err.println("Formato de string inválido para Funcionario: " + str);
			throw new IllegalArgumentException("Formato de string inválido para Funcionario");
		}

		String superString = String.join(", ", parte.subList(0, 4));
		double salario = Double.parseDouble(parte.get(4).replace("Salario: R$", "").trim());
		String cargo = parte.get(5).replace("Cargo: ", "").trim();
		int codigoFuncionario = Integer.parseInt(parte.get(6).replace("Codigo funcionario: ", "").trim());

		Pessoa pessoa = Pessoa.fromString(superString);

		return new Funcionario(pessoa.getNomePessoa(), pessoa.getCpf(), pessoa.getEndereco(), pessoa.getIdade(),
				salario, cargo, codigoFuncionario);
	}
}