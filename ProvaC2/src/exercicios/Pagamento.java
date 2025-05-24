package exercicios;

public interface Pagamento {
	public boolean autorizarPagamento(double valor);
	public double estornarPagamento(double valor);
}
