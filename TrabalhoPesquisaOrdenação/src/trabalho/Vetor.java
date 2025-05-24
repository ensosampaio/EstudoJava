package trabalho;

import java.util.HashMap;
import java.util.Map;

import dados.Item;

public class Vetor {
	private Item[] vetor;
	private int nElem;
	private int comparacoesSeq;
	private int comparacoesBin;

	public Vetor(int tamanho) {
		this.vetor = new Item[tamanho];
		this.nElem = 0;
		this.comparacoesSeq = 0;
		this.comparacoesBin = 0;
	}

	public int getTamanho() {
		return vetor.length;
	}

	public int getnElem() {
		return nElem;
	}

	public void setnElem(int nElem) {
		this.nElem = nElem;
	}

	public boolean inserirDados(Item novo) {
		if (this.nElem == this.vetor.length) {
			return false;
		} else {
			this.vetor[this.nElem] = novo;
			this.nElem++;
			return true;
		}
	}

	public int getComparacoesSeq() {
		return comparacoesSeq;
	}

	public int getComparacoesBin() {
		return comparacoesBin;
	}

	public int pesquisaSequencial(int chave) {
		comparacoesSeq = 0;
		for (int i = 0; i < nElem; i++) {
			comparacoesSeq++;
			if (vetor[i].getChave() == chave) {
				return i;
			}
		}
		return -1;
	}

	public void bubblesort() {
		int n, i, j;
		Item temp;
		n = this.nElem - 1;
		do {
			i = 0;
			for (j = 0; j < n; j++) {
				if (this.vetor[j].getChave() > this.vetor[j + 1].getChave()) {
					temp = this.vetor[j];
					this.vetor[j] = this.vetor[j + 1];
					this.vetor[j + 1] = temp;
					i = j;
				}
			}
			n = i;
		} while (n >= 1);
	}

	public int pesquisaBinaria(int chave) {
		comparacoesBin = 0;
		int esquerda = 0;
		int direita = nElem - 1;

		while (esquerda <= direita) {
			comparacoesBin++;
			int meio = (esquerda + direita) / 2;
			if (vetor[meio].getChave() == chave) {
				return meio;
			} else {
				comparacoesBin++;
				if (vetor[meio].getChave() < chave) {

					esquerda = meio + 1;

				} else {
					direita = meio - 1;
				}
			}
		}
		return -1;
	}

	public int pesquisaHashing(int chave) {
		Map<Integer, Integer> hashMap = new HashMap<>();
		for (int i = 0; i < nElem; i++) {
			hashMap.put(vetor[i].getChave(), i);
		}
		return hashMap.getOrDefault(chave, -1);
	}

	public String imprimirVetor() {
		StringBuilder resultado = new StringBuilder();
		for (int i = 0; i < nElem; i++) {
			resultado.append(vetor[i].getChave()).append(" ");
		}
		return resultado.toString();
	}

}