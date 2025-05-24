package exercicios;

import java.util.Random;

public class PagamentoBoleto implements Pagamento {
	public static Random r = new Random();
	private int codigoPagamento;

	public PagamentoBoleto(int codigoPagamento) {
		super();
		this.codigoPagamento = codigoPagamento;
	}

	public int getCodigoPagamento() {
		return codigoPagamento;
	}

	public void setCodigoPagamento(int codigoPagamento) {
		this.codigoPagamento = codigoPagamento;
	}

	@Override
	public boolean autorizarPagamento(double valor) {
		do {
			this.codigoPagamento = r.nextInt(10000);
		}while(this.codigoPagamento<=1000);
		return true;
	}

	@Override
	public double estornarPagamento(double valor) {
		valor = 0;
		return valor;
	}

	public String codigoPagamento() {
		return "Codigo do pagamento: " + this.codigoPagamento;
	}

}
