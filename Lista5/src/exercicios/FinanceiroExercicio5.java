package exercicios;

public class FinanceiroExercicio5 {
	private ClienteExercicio5[] vetor;
	private int quantVetor;

	public FinanceiroExercicio5(int tamanho) {
		this.vetor = new ClienteExercicio5[tamanho];
		this.quantVetor = 0;
	}

	public ClienteExercicio5 getVetor(int indice) {
		return this.vetor[indice];
	}

	public void setVetor(int indice, ClienteExercicio5 novo) {
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

	public boolean cadastrarCliente(ClienteExercicio5 novo) {
		if (this.quantVetor == this.vetor.length) {
			return false;
		} else {
			for (int i = 0; i < this.quantVetor; i++) {
				if (vetor[i].getNome().equalsIgnoreCase(novo.getNome())) {
					return false;
				}
			}
			this.vetor[quantVetor] = novo;
			this.quantVetor++;
			return true;
		}

	}

	public boolean alterarJuros(double novoJuros) {
		if (quantVetor <= 0) {
			return false;
		}
		double maior = 0;
		int clienteMaior = -1;
		for (int i = 0; i < quantVetor; i++) {
			if (vetor[i].getValorEmprestimo() > maior) {
				maior = vetor[i].getValorEmprestimo();
				clienteMaior = i;
			}
		}
		if (clienteMaior != -1) {
			vetor[clienteMaior].setJurosMes(novoJuros);
			return true;
		} else {
			return false;
		}
	}

}
