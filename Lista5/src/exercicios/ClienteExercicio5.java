package exercicios;

public class ClienteExercicio5 {
	private String nome;
	private double valorEmprestimo;
	private double jurosMes;

	public ClienteExercicio5(String nome, double valorEmprestimo, double jurosMes) {

		this.nome = nome;
		this.valorEmprestimo = valorEmprestimo;
		this.jurosMes = jurosMes;
	}

	public ClienteExercicio5() {

		this.nome = " ";
		this.valorEmprestimo = 0;
		this.jurosMes = 0;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getValorEmprestimo() {
		return valorEmprestimo;
	}

	public void setValorEmprestimo(double valorEmprestimo) {
		this.valorEmprestimo = valorEmprestimo;
	}

	public double getJurosMes() {
		return jurosMes;
	}

	public void setJurosMes(double jurosMes) {
		this.jurosMes = jurosMes;

	}

	@Override
	public String toString() {
	    return "Cliente: \n" +
	           "  Nome: " + nome + "\n" +
	           "  Valor do Empréstimo: R$" + valorEmprestimo + "\n" +
	           "  Juros ao mês: " + jurosMes + "%\n";
	}

}
