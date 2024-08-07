package exercicios;

public class EstoqueExercicio4 {
	private BrinquedoExercicio4[] vetor;
	private int quantVetor;

	public EstoqueExercicio4(int tamanho) {
		this.vetor = new BrinquedoExercicio4[tamanho];
		this.quantVetor = 0;
	}

	public BrinquedoExercicio4 getVetor(int indice) {
		return this.vetor[indice];
	}

	public void setVetor(int indice, BrinquedoExercicio4 novo) {
		this.vetor[indice] = novo;
	}

	public int getQuantVetor() {
		return quantVetor;
	}

	public void setQuantVetor(int novo) {
		this.quantVetor = novo;
	}

	public String toString() {
		String resposta = " ";
		for (int i = 0; i < this.quantVetor; i++) {
			resposta += (i + 1) + " . " + this.vetor[i].toString();
		}
		return resposta;
	}

	public boolean cadastrarProduto(BrinquedoExercicio4 novo) {
		if (this.quantVetor == this.vetor.length) {
			return false;
		} else {
			this.vetor[this.quantVetor] = novo;
			this.quantVetor++;
			return true;
		}
	}

	public double lucroVenda(int codigo) {
		for (int i = 0; i < this.quantVetor; i++) {
			if (vetor[i].getCodigoBrinquedo() == codigo) {
				return vetor[i].getPrecoVenda() - vetor[i].getPrecoCompra();
			}
		}
		return 0;
	}

	public boolean abaixoEstoque() {

		for (int i = 0; i < this.quantVetor; i++) {
			if (vetor[i].getEstoque() < vetor[i].getEstoqueMin()) {
				return true;
			}
		}
		return false;
	}

}
