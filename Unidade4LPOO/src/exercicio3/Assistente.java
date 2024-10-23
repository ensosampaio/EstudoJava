package exercicio3;

public class Assistente extends Funcionario {

	public Assistente(String nome, int matricula) {
		super(nome, matricula);
	}

	@Override
	public double calcularSalario() {
		return getSalario_base();
	}

	@Override
	public String situacao() {
		return super.situacao();
	}


}
