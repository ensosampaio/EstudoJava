package exercicios;

public class PagamentoCartaoCredito implements Pagamento {

	private double limiteDisp;

	public PagamentoCartaoCredito(double limiteDisp) {
		super();
		this.limiteDisp = limiteDisp;
	}

	public double getLimiteDisp() {
		return limiteDisp;
	}

	public void setLimiteDisp(double limiteDisp) {
		this.limiteDisp = limiteDisp;
	}

	@Override
	public boolean autorizarPagamento(double valor) {
		if (valor > this.limiteDisp) {
			return false;
		} else {
			this.limiteDisp -= valor;
			return true;
		}

	}

	@Override
	public double estornarPagamento(double valor) {
		return this.limiteDisp += valor;
	}

	public String limite() {
		return "Limite: " + this.limiteDisp;
	}
	


	


}
