package exercicio3;

public abstract class Funcionario {

	private String nome;
	private int matricula;
	private static double salario_base;

	public Funcionario(String nome, int matricula) {
		super();
		this.nome = nome;
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	public static double getSalario_base() {
		return salario_base;
	}

	public static void setSalario_base(double salario_base) {
		Funcionario.salario_base = salario_base;
	}

	public abstract double calcularSalario();


	public String situacao() {
		return "Nome: " + this.nome + " Matricula: " + this.matricula + " Salário: " + calcularSalario();
	}



}
