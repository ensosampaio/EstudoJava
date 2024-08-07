package filaCircular;

import dados.Item;
import pilha.PilhaContig;

public class FilaCircular {
	private Item[] info;
	private int frente;
	private int tras;
	private int tamanho;

	public FilaCircular(int qte) {// qte é o tamanho do vetor
		this.frente = 0;
		this.tras = 0;
		this.tamanho = 0;
		this.info = new Item[qte];
	}

	public Item getInfo() {
		return this.info[this.frente];
	}

	public int getFrente() {
		return this.frente;
	}

	public int getTras() {
		return this.tras;
	}

	public int getTamanho() {
		return this.tamanho;
	}

	public boolean eVazia() {
		return (this.tamanho == 0);
	}

	public boolean eCheia() {
		return (this.tamanho == this.info.length);
	}

	public boolean enfileirar(Item elem) {
		if (this.eCheia())
			return false;
		else {
			this.info[this.tras] = elem;
			this.tras = (++this.tras % this.info.length);
			this.tamanho++;
			return true;
		}
	}

	public Item desenfileirar() {
		Item no;
		if (this.eVazia())
			return null;
		else {
			no = this.info[this.frente];
			this.frente = (++this.frente % this.info.length);
			this.tamanho--;
			return no;
		}
	}

	public String toString() { // imprimir o conteúdo da fila
		String msg = "";
		int aux = this.frente;
		for (int i = 1; i <= this.tamanho; i++) {
			msg += this.info[aux].getChave() + " ";
			aux = (++aux % this.info.length);
		}
		return msg;
	}

	// atividade 06 - questao 01
	public void retirarNegativo() {
		int aux = this.frente;
		int numRemovido = 0;
		for (int i = 1; i <= this.tamanho; i++) {
			if (this.info[aux].getChave() < 0) {
				aux = (++aux % this.info.length);
				numRemovido++;
			} else {
				this.info[this.frente] = this.info[aux];
				this.frente = (++this.frente % this.info.length);
				aux = this.frente;
			}
		}

		this.tamanho -= numRemovido;
	}

	// atividade 06 - questao 02
	public int somarFila() {
		int soma = 0;
		int aux = this.frente;
		for (int i = 0; i < this.tamanho; i++) {
			soma += this.info[aux].getChave();
			aux = (++aux % this.info.length);
		}
		// enzo sampaio
		return soma;
	}

	// atividade 06 - questao 03
	public FilaCircular transferirPilhaParaFila(PilhaContig pilha) {
		FilaCircular fila = new FilaCircular(pilha.getTopo());
		while (!pilha.eVazia()) {
			Item elemento = pilha.desempilhar();
			fila.enfileirar(elemento);
		}
		return fila;
	}

	// atividade 06 - questao 04

	public FilaCircular imprimirPaginas(PilhaContig pilha) {

		FilaCircular fila = new FilaCircular(this.info.length);
		while (!this.eVazia()) {
			Item elemento = this.desenfileirar();
			pilha.empilhar(elemento);
		}
		while (!pilha.eVazia()) {
			Item elemento = pilha.desempilhar();
			fila.enfileirar(elemento);
		}

		return fila;
	}

	// atividade 06 - questao 05
	public void retirarIdade() {
		int aux = this.frente;
		int idade = 0;

		for (int i = 0; i < this.tamanho; i++) {
			if (this.info[aux].getChave() >= 70) {
				aux = (++aux % this.info.length);
				idade++;
			} else {
				this.info[this.tras] = this.info[aux];
				this.tras = (++this.tras % this.info.length);
			}
			aux = (++aux % this.info.length);
		}

		this.tamanho -= idade;

		FilaCircular idoso = new FilaCircular(idade);

		for (int i = 0; i < idade; i++) {
			idoso.enfileirar(this.info[(this.frente + i) % this.info.length]);
		}
	}


























}