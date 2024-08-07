package exercicios;

public class ContaExercicio6 {
	private int numeroConta;
	private String nomeCliente;
	private double saldo;

	public ContaExercicio6(int numeroConta, String nomeCliente, double saldo) {
		this.numeroConta = numeroConta;
		this.nomeCliente = nomeCliente;
		this.saldo = saldo;
	}

	public ContaExercicio6() {
		this.numeroConta = 0;
		this.nomeCliente = " ";
		this.saldo = 0;
	}

	public int getNumeroConta() {
		return numeroConta;
	}

	public void setNumeroConta(int numeroConta) {
		this.numeroConta = numeroConta;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	@Override
	public String toString() {
	    return "Cliente: \n" +
	           "  Nome: " + nomeCliente + "\n" +
	           "  Numero da conta: " + numeroConta + "\n" +
	           "  Saldo: " + saldo + "\n";
	}

}
