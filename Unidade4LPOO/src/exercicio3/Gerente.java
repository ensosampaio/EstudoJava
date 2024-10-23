package exercicio3;

public class Gerente extends Funcionario {

	public Gerente(String nome, int matricula) {
		super(nome, matricula);
	}

	@Override
	public double calcularSalario() {
		return getSalario_base()*2;
	}

	@Override
	public String situacao() {
		return super.situacao();
	}

}
