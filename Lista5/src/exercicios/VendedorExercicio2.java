package exercicios;

public class VendedorExercicio2 {
	private int codigoVendedor;
	private String nomeVendedor;
	private char tipoMercadoria;

	public VendedorExercicio2(int codigoVendedor, String nomeVendedor, char tipoMercadoria) { // construtor

		this.codigoVendedor = codigoVendedor;
		this.nomeVendedor = nomeVendedor;
		this.tipoMercadoria = tipoMercadoria;
	}

	public VendedorExercicio2() { // construtor

		this.codigoVendedor = 0;
		this.nomeVendedor = " ";
		this.tipoMercadoria = ' ';
	}

	public int getCodigoVendedor() {
		return codigoVendedor;
	}

	public void setCodigoVendedor(int codigoVendedor) {
		this.codigoVendedor = codigoVendedor;
	}

	public String getNomeVendedor() {
		return nomeVendedor;
	}

	public void setNomeVendedor(String nomeVendedor) {
		this.nomeVendedor = nomeVendedor;
	}

	public char getTipoMercadoria() {
		return tipoMercadoria;
	}

	public void setTipoMercadoria(char tipoMercadoria) {
		this.tipoMercadoria = tipoMercadoria;
	}

	@Override
	public String toString() {
		return "\nNome do vendedor: " + nomeVendedor + "\nCódigo do vendedor: " + codigoVendedor
				+ "\nTipo de mercadoria: " + tipoMercadoria;
	}

}
