package exercicios;

public class LocadoraExercicio1 {
	private FilmesExercicio1[] vetor;
	private int quantVetor;

	public LocadoraExercicio1(int tamanho) {
		this.vetor = new FilmesExercicio1[tamanho];
		this.quantVetor = 0;
	}

	public FilmesExercicio1 getVetor(int indice) {
		return this.vetor[indice];
	}

	public void setVetor(int indice, FilmesExercicio1 novo) {
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

	public boolean inserirFilme(FilmesExercicio1 novo) {
		if (this.quantVetor == this.vetor.length) {
			return false;
		} else {
			this.vetor[this.quantVetor] = novo;
			this.quantVetor++;
			return true;
		}
	}

	public int pesquisarGenero(char genero) {
		for (int i = 0; i < this.quantVetor; i++) {
			if (this.vetor[i].getGenero() == genero) {
				return i;
			}
		}
		return this.quantVetor;
	}

	public boolean removerFilme(String titulo) {
		if (this.quantVetor == 0) {
			return false;
		} else {
			int i = 0;
			while (i < this.quantVetor && !this.vetor[i].getTitulo().equalsIgnoreCase(titulo)) {
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

	public int contarFilmesGenero(char genero) {
		int contador = 0;
		for (int i = 0; i < quantVetor; i++) {
			if (vetor[i].getGenero() == genero) {
				contador++;
			}
		}
		return contador;
	}

}
