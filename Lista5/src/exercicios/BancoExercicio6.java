package exercicios;

public class BancoExercicio6 {
	private ContaExercicio6[] vetor;
	private int quantVetor;

	public BancoExercicio6(int tamanho) {
		this.vetor = new ContaExercicio6[tamanho];
		this.quantVetor = 0;
	}

	public ContaExercicio6 getVetor(int indice) {
		return this.vetor[indice];
	}

	public void setVetor(int indice, ContaExercicio6 novo) {
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

	public boolean cadastrarCliente(ContaExercicio6 novo) {
		if (this.quantVetor == this.vetor.length) {
			return false;
		} else {
			for (int i = 0; i < quantVetor; i++) {
				if (vetor[i].getNumeroConta() == novo.getNumeroConta()) {
					return false;
				}
			}
		}
		this.vetor[this.quantVetor] = novo;
		this.quantVetor++;
		return true;

	}

	public ContaExercicio6 visualizarConta(String cliente) {
		for (int i = 0; i < this.quantVetor; i++) {
			if (this.vetor[i].getNomeCliente().equalsIgnoreCase(cliente)) {
				return vetor[i];
			}
		}
		return null;
	}

	public boolean removerMenorSaldo(double saldo) {
		if (this.quantVetor == 0) {
			return false;
		}
		double menor = vetor[0].getSaldo();
		int indiceMenor = 0;
		for (int i = 1; i<this.quantVetor; i++) {
			if (vetor[i].getSaldo() < menor) {
			 menor = vetor[i].getSaldo();
			 indiceMenor = i;
			}
		}
		this.vetor[indiceMenor] = this.vetor[this.quantVetor - 1];
	    this.quantVetor--;
	    return true;
	}

}
