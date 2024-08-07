package exercicios;

public class FolhaTrabalhoExercicio7 {
	private FuncionarioExercicio7[] vetor;
	private int quantVetor;

	public FolhaTrabalhoExercicio7(int tamanho) {
		this.vetor = new FuncionarioExercicio7[tamanho];
		this.quantVetor = 0;
	}

	public FuncionarioExercicio7 getVetor(int indice) {
		return this.vetor[indice];
	}

	public void setVetor(int indice, FuncionarioExercicio7 novo) {
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

	public boolean cadastrarFuncionario(FuncionarioExercicio7 novo) {
		if (this.quantVetor == this.vetor.length) {
			return false;
		} else {
			this.vetor[this.quantVetor] = novo;
			this.quantVetor++;
			return true;
		}
	}

	public boolean alterarHora(int novaHora, String nome) {

		if (quantVetor <= 0) {
			return false;
		}
		for (int i = 0; i < this.quantVetor; i++) {
			if (vetor[i].getNome().equalsIgnoreCase(nome)) {
				vetor[i].setHoraTrabalhada(novaHora);
				return true;
			}
		}

		return false;
	}

	public double calcularSalario(FuncionarioExercicio7 funcionario) {
		double salarioBase = 112.0;
		double salarioCategoria = 0.0;

		if (funcionario.getCategoria() == 'G') {
			salarioCategoria = 0.15 * salarioBase * funcionario.getHoraTrabalhada();
		} else if (funcionario.getCategoria() == 'O') {
			salarioCategoria = 0.10 * salarioBase * funcionario.getHoraTrabalhada();
		}

		return salarioBase * funcionario.getHoraTrabalhada() + salarioCategoria;
	}

}
