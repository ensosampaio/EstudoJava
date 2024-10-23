package exercicioLista1;

/*
1) Uma empresa deve informatizar seu estoque. Para isso, faça:
a) Uma classe com os atributos de cada produto (código,
descrição, valor unitário, quantidade em estoque, quantidade
mínima no estoque), os métodos gets, sets e toString.
b) Um aplicativo que:
b.1) Armazene 10 produtos
b.2) Permita alterar valor unitário ou quantidade em estoque de
um produto (a chave de pesquisa será seu código).
b.3) Permita pesquisar todos os produtos cuja descrição começa
por uma determinada letra (informada pelo usuário)
b.4) Listar todos os produtos cuja quantidade em estoque é
menor que a quantidade mínima.
 */

public class Estoque {
	private int codigo;
	private String descricao;
	private double valorUni;
	private double qntEstoque;
	private double qntMin;

	public Estoque(int codigo, String descricao, double valorUni, double qntEstoque, double qntMin) {
		this.codigo = codigo;
		this.descricao = descricao;
		this.valorUni = valorUni;
		this.qntEstoque = qntEstoque;
		this.qntMin = qntMin;
	}

	public Estoque() {
		this.codigo = 0;
		this.descricao = "";
		this.valorUni = 0;
		this.qntEstoque = 0;
		this.qntMin = 0;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getValorUni() {
		return valorUni;
	}

	public void setValorUni(double valorUni) {
		this.valorUni = valorUni;
	}

	public double getQntEstoque() {
		return qntEstoque;
	}

	public void setQntEstoque(double qntEstoque) {
		this.qntEstoque = qntEstoque;
	}

	public double getQntMin() {
		return qntMin;
	}

	public void setQntMin(double qntMin) {
		this.qntMin = qntMin;
	}

	@Override
	public String toString() {
		return "EstoqueVet [codigo=" + codigo + ", descricao=" + descricao + ", valorUni=" + valorUni + ", qntEstoque="
				+ qntEstoque + ", qntMin=" + qntMin + "]";
	}

}
