package dados;

import java.util.ArrayList;
import java.util.Arrays;

public class Cliente extends Pessoa {

	private double saldo;
	private double debito;
	private String historico;
	private int codigoCliente;

	public Cliente(String nomePessoa, String cpf, String endereco, int idade, double saldo, double debito,
			String historico, int codigoCliente) {
		super(nomePessoa, cpf, endereco, idade);
		this.saldo = saldo;
		this.debito = debito;
		this.historico = historico;
		this.codigoCliente = codigoCliente;
	}

	public Cliente() {
		super();
		this.saldo = 0;
		this.debito = 0;
		this.historico = " ";
		this.codigoCliente = 0;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public double getDebito() {
		return debito;
	}

	public void setDebito(double debito) {
		this.debito = debito;
	}

	public String getHistorico() {
		return historico;
	}

	public void setHistorico(String historico) {
		this.historico = historico;
	}

	public int getCodigoCliente() {
		return codigoCliente;
	}

	public void setCodigoCliente(int codigoCliente) {
		this.codigoCliente = codigoCliente;
	}

	@Override
	public String toString() {
		return super.toString() +", "+ "Saldo: R$"  +saldo + ", " + "Débito: R$" + debito +", " +"Histórico:" + historico
				+ ", " + "Código Cliente: " + codigoCliente;
	}

	public static Cliente fromString(String str) {

		ArrayList<String> parte = new ArrayList<>(Arrays.asList(str.split(", ")));

		System.out.println("Debug: partes da string - " + parte);

		if (parte.size() < 8) {
			System.err.println("Formato de string inválido para Cliente: " + str);
			throw new IllegalArgumentException("Formato de string inválido para Cliente");
		}

		String superString = String.join(", ", parte.subList(0, 4));
		double saldo = Double.parseDouble(parte.get(4).replace("Saldo: R$", "").trim());
		double debito = Double.parseDouble(parte.get(5).replace("Débito: R$", "").trim());
		String historico = parte.get(6).replace("Histórico:", "").trim();
		int codigoCliente = Integer.parseInt(parte.get(7).replace("Código Cliente: ", "").trim());

		Pessoa pessoa = Pessoa.fromString(superString);

		return new Cliente(pessoa.getNomePessoa(), pessoa.getCpf(), pessoa.getEndereco(), pessoa.getIdade(), saldo,
				debito, historico, codigoCliente);
	}
}
