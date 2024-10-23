package exercicio3;

public class Vendedor extends Funcionario {

	private double comissão;

	public Vendedor(String nome, int matricula, double comissão) {
		super(nome, matricula);
		this.comissão = comissão;
	}

	@Override
	public double calcularSalario() {
		return (getSalario_base() + this.comissão);
	}
	
	@Override
	public String situacao() {
		return super.situacao() + " Comissão: " + this.comissão;
	}

}


