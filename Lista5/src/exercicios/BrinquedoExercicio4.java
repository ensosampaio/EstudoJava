package exercicios;

public class BrinquedoExercicio4 {

	private int codigoBrinquedo;
	private String descricaoBrinquedo;
	private double precoCompra;
	private double precoVenda;
	private int estoque;
	private int estoqueMin;

	public BrinquedoExercicio4(int codigoBrinquedo, String descricaoBrinquedo, double precoCompra, double precoVenda,
			int estoque, int estoqueMin) {
		this.codigoBrinquedo = codigoBrinquedo;
		this.descricaoBrinquedo = descricaoBrinquedo;
		this.precoCompra = precoCompra;
		this.precoVenda = precoVenda;
		this.estoque = estoque;
		this.estoqueMin = estoqueMin;
	}

	public BrinquedoExercicio4() {
		this.codigoBrinquedo = 0;
		this.descricaoBrinquedo = " ";
		this.precoCompra = 0;
		this.precoVenda = 0;
		this.estoque = 0;
		this.estoqueMin = 0;
	}

	public int getCodigoBrinquedo() {
		return codigoBrinquedo;
	}

	public void setCodigoBrinquedo(int codigoBrinquedo) {
		this.codigoBrinquedo = codigoBrinquedo;
	}

	public String getDescricaoBrinquedo() {
		return descricaoBrinquedo;
	}

	public void setDescricaoBrinquedo(String descricaoBrinquedo) {
		this.descricaoBrinquedo = descricaoBrinquedo;
	}

	public double getPrecoCompra() {
		return precoCompra;
	}

	public void setPrecoCompra(double precoCompra) {
		this.precoCompra = precoCompra;
	}

	public double getPrecoVenda() {
		return precoVenda;
	}

	public void setPrecoVenda(double precoVenda) {
		this.precoVenda = precoVenda;
	}

	public int getEstoque() {
		return estoque;
	}

	public void setEstoque(int estoque) {
		this.estoque = estoque;
	}

	public int getEstoqueMin() {
		return estoqueMin;
	}

	public void setEstoqueMin(int estoqueMin) {
		this.estoqueMin = estoqueMin;
	}

	@Override
	public String toString() {
		return "Brinquedo [codigoBrinquedo=" + codigoBrinquedo + ", descricaoBrinquedo=" + descricaoBrinquedo
				+ ", precoCompra=" + precoCompra + ", precoVenda=" + precoVenda + ", estoque=" + estoque
				+ ", estoqueMin=" + estoqueMin + "]";
	}

}
