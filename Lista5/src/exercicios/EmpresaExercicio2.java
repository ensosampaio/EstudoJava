package exercicios;

public class EmpresaExercicio2 {
	private VendedorExercicio2[] vetor;
	private int quantVetor;

	public EmpresaExercicio2(int tamanho) {
		this.vetor = new VendedorExercicio2[tamanho];
		this.quantVetor = 0;
	}

	public VendedorExercicio2 getVetor(int indice) {
		return this.vetor[indice];
	}

	public void setVetor(int indice, VendedorExercicio2 novo) {
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

	public boolean inserirVendedor(VendedorExercicio2 novo) {
		if (this.quantVetor == this.vetor.length) {
			return false;
		} else {
			this.vetor[this.quantVetor] = novo;
			this.quantVetor++;
			return true;
		}
	}

	public boolean removerVendedor(String nome) {
		if (this.quantVetor == 0) {
			return false;
		} else {
			int i = 0;
			while (i < this.quantVetor && !this.vetor[i].getNomeVendedor().equalsIgnoreCase(nome)) {
				i++;
			}
			if (i == this.quantVetor) {
				return false;
			} else {
				this.vetor[i] = this.vetor[this.quantVetor - 1];
				this.quantVetor--;
				return true;
			}

		}
	}

	public int contarVendedorMercadoria(char mercadoria) {
		int contador = 0;
		for (int i = 0; i < this.quantVetor; i++) {
			if (vetor[i].getTipoMercadoria() == mercadoria) {
				contador++;
			}
		}
		return contador;
	}
}
