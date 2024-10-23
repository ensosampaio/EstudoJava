package ordenacao;

import java.util.Arrays;

import dados.Item;

public class Vetor {
	private Item[] vetor;
	private int nElem;
	private int comparacao;
	private int movimentos;

	public Vetor(int tamanho) {
		this.vetor = new Item[tamanho];
		this.nElem = 0;
		this.comparacao = 0;
		this.movimentos = 0;
	}

	public int getnElem() {
		return nElem;
	}

	public void setnElem(int nElem) {
		this.nElem = nElem;
	}

	public int getComparacao() {
		return comparacao;
	}

	public int getMovimentos() {
		return movimentos;
	}

	public void resetarContadores() {
		this.comparacao = 0;
		this.movimentos = 0;
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

	public void selecaoDireta() {
		resetarContadores();
		int i, j, minimo;
		Item temp;
		for (i = 0; i < this.nElem - 1; i++) {
			minimo = i;
			for (j = i + 1; j < this.nElem; j++) {
				comparacao++;
				if (this.vetor[j].getChave() < this.vetor[minimo].getChave())
					minimo = j;
			}
			temp = this.vetor[minimo];
			this.vetor[minimo] = this.vetor[i];
			this.vetor[i] = temp;
			movimentos += 1;
		}
	}

	public void heapSort() {
		resetarContadores();
		int dir = nElem - 1;
		int esq = (dir - 1) / 2;
		Item temp;
		while (esq >= 0)
			refazHeap(esq--, this.nElem - 1);
		while (dir > 0) {
			temp = this.vetor[0];
			this.vetor[0] = this.vetor[dir];
			this.vetor[dir--] = temp;
			movimentos += 1;
			refazHeap(0, dir);
		}
	}

	private void refazHeap(int esq, int dir) {
		int i = esq;
		int MaiorFolha = 2 * i + 1;
		Item raiz = this.vetor[i];
		boolean heap = false;

		while ((MaiorFolha <= dir) && (!heap)) {
			comparacao++;

			if (MaiorFolha < dir) {
				comparacao++;
				if (this.vetor[MaiorFolha].getChave() < this.vetor[MaiorFolha + 1].getChave()) {
					MaiorFolha++;
				}
			}

			comparacao++;
			if (raiz.getChave() < this.vetor[MaiorFolha].getChave()) {
				this.vetor[i] = this.vetor[MaiorFolha];
				i = MaiorFolha;
				MaiorFolha = 2 * i + 1;
				movimentos++;
			} else {
				heap = true;
			}
		}
		this.vetor[i] = raiz;
		movimentos++;
	}

	public void insercaoDireta() {
		resetarContadores();
		int i, j;
		Item temp;
		for (i = 1; i < this.nElem; i++) {
			temp = this.vetor[i];
			j = i - 1;
			comparacao++;
			while ((j >= 0) && (this.vetor[j].getChave() > temp.getChave())) {
				this.vetor[j + 1] = this.vetor[j];
				j--;
				movimentos++;
				comparacao++;
			}
			this.vetor[j + 1] = temp;
			movimentos++;
		}
	}

	public void shellSort() {
		resetarContadores();
		int i, j, h;
		Item temp;
		h = 1;

		do {
			h = 3 * h + 1;
		} while (h < this.nElem);
		do {
			h = h / 3;
			for (i = h; i < this.nElem; i++) {
				temp = this.vetor[i];
				j = i;

				comparacao++;
				while (j >= h && this.vetor[j - h].getChave() > temp.getChave()) {
					this.vetor[j] = this.vetor[j - h];
					movimentos++;
					j -= h;
					if (j >= h) {
						comparacao++;
					}
				}
				this.vetor[j] = temp;
				movimentos++;
			}
		} while (h > 1);
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

	public void shakersort() {
		resetarContadores();
		int esq, dir, i, j;
		Item temp;
		esq = 1;
		dir = this.nElem - 1;
		j = dir;
		do {
			for (i = dir; i >= esq; i--) {
				comparacao++;
				if (this.vetor[i - 1].getChave() > this.vetor[i].getChave()) {
					temp = this.vetor[i];
					this.vetor[i] = this.vetor[i - 1];
					this.vetor[i - 1] = temp;
					movimentos += 1;
					j = i;
				}
			}
			esq = j + 1;
			for (i = esq; i <= dir; i++) {
				comparacao++;
				if (this.vetor[i - 1].getChave() > this.vetor[i].getChave()) {
					temp = this.vetor[i];
					this.vetor[i] = this.vetor[i - 1];
					this.vetor[i - 1] = temp;
					movimentos += 1;
					j = i;
				}
			}
			dir = j - 1;
		} while (esq <= dir);
	}

	public void quicksort() {
		resetarContadores();
		ordena(0, this.nElem - 1);
	}

	private void ordena(int esq, int dir) {
		int pivo, i = esq, j = dir;
		Item temp;
		pivo = this.vetor[(i + j) / 2].getChave();
		do {
			while (this.vetor[i].getChave() < pivo) {
				comparacao++;
				i++;
			}
			while (this.vetor[j].getChave() > pivo) {
				comparacao++;
				j--;
			}
			if (i <= j) {
				temp = this.vetor[i];
				this.vetor[i] = this.vetor[j];
				this.vetor[j] = temp;
				movimentos += 1;
				i++;
				j--;
			}
		} while (i <= j);
		if (esq < j) {
			ordena(esq, j);
		}
		if (dir > i) {
			ordena(i, dir);
		}
	}
}
