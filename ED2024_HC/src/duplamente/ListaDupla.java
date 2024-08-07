package duplamente;

import dados.Item;

public class ListaDupla {
	private NoDupla prim;
	private NoDupla ult;
	private int quantNos;

	public ListaDupla() {
		this.prim = null;
		this.ult = null;
		this.quantNos = 0;
	}

	public int getQuantNos() {
		return this.quantNos;
	}

	public NoDupla getPrim() {
		return this.prim;
	}

	public NoDupla getUlt() {
		return this.ult;
	}

	public void setQuantNos(int valorNovo) {
		this.quantNos = valorNovo;
	}

	public void setPrim(NoDupla novoNo) {
		this.prim = novoNo;
	}

	public void setUlt(NoDupla novoNo) {
		this.ult = novoNo;
	}

	public boolean eVazia() {
		return (this.prim == null);
	}

	// insere um novo n� no final da lista ou se a lista estiver vazia, insere
	// o primeiro n� na lista
	public void inserirUltimo(Item elem) {
		NoDupla novoNo = new NoDupla(elem);
		if (this.eVazia())
			this.prim = novoNo;
		else {
			novoNo.setAnt(this.ult);
			this.ult.setProx(novoNo);
		}
		this.ult = novoNo;
		this.quantNos++;
	}

	// retorna o endere�o do n� que est� contendo o valor a ser procurado.
	public NoDupla pesquisarNo(int chave) {
		NoDupla atual = this.prim;
		while ((atual != null) && (atual.getInfo().getChave() != chave))
			atual = atual.getProx();
		return atual;
	}

	// remove um determinado n� em qualquer posi��o na lista.
	public boolean removerNo(int chave) {
		NoDupla atual = this.prim;
		while ((atual != null) && (atual.getInfo().getChave() != chave)) {
			atual = atual.getProx();
		}
		if (atual == null)
			return false;
		else if (atual == this.prim) {
			this.prim = prim.getProx();
			if (this.prim == null) // se a lista tem somente um n�
				this.ult = null;
			else
				this.prim.setAnt(null);
		} else if (atual == this.ult) {
			this.ult = this.ult.getAnt();
			this.ult.setProx(null);
		} else {
			atual.getProx().setAnt(atual.getAnt());
			atual.getAnt().setProx(atual.getProx());
		}
		this.quantNos--;
		return true;
	}

	public String toString() {
		String msg = "";
		NoDupla atual = this.prim;
		while (atual != null) {
			msg += atual.getInfo().getChave() + "\n";
			atual = atual.getProx();
		}
		return msg;
	}

	// atividade 04 - quest�o 06
	public void concatenarListas(ListaDupla lista2) {
		lista2.prim.setAnt(this.ult);
		this.ult.setProx(lista2.prim);
		this.ult = lista2.ult;
		lista2.prim = null;
		lista2.ult = null;
		this.quantNos += lista2.quantNos;
		lista2.quantNos = 0;
	}

	// atividade 04 - quest�o 07
	public ListaDupla partirLista() {
		ListaDupla lista2 = new ListaDupla();

		NoDupla atual = this.prim;

		for (int i = 1; i < this.quantNos / 2; i++) {
			atual = atual.getProx();
		}
		lista2.prim = atual.getProx();
		lista2.ult = this.ult;
		this.ult = atual;
		lista2.prim.setAnt(null);
		this.ult.setProx(null);

		lista2.quantNos = this.quantNos - this.quantNos / 2;
		this.quantNos = this.quantNos / 2;
		return lista2;
	}
	// atividade 04 - questao 08

	public int acharMaior() {
		NoDupla atual = this.prim;
		int maior = 0;

		if (this.eVazia()) {
			return 0;
		} else {
			while (atual != null) {
				if (atual.getInfo().getChave() > maior) {
					maior = atual.getInfo().getChave();
				}
				atual = atual.getProx();
			}
		}
		return maior;

	}

	// atividade 04 - questao 09;
	public double calcularMedia() {
		double media = 0;
		double soma = 0;
		int qntNos = 0;
		NoDupla atual = this.prim;
		if (this.eVazia()) {
			return 0;
		} else {
			while (atual != null) {
				soma += atual.getInfo().getChave();
				qntNos += 1;
				atual = atual.getProx();
			}
			media = soma / qntNos;
		}
		return media;
	}

	// atividade 04 - questao 10
	public void removerZero() {
		NoDupla atual = this.prim;
		while (atual != null) {
			if (atual.getInfo().getChave() == 0) {
				if (atual == this.prim) {
					this.prim = prim.getProx();
					if (this.prim == null)
						this.ult = null;
					else
						this.prim.setAnt(null);
				} else if (atual == this.ult) {
					this.ult = this.ult.getAnt();
					this.ult.setProx(null);
				} else {
					atual.getProx().setAnt(atual.getAnt());
					atual.getAnt().setProx(atual.getProx());
				}
				this.quantNos--;

			}
			atual = atual.getProx();
		}
	}

	// atividade 04 - questao 11
	public void retirarRepetido() {
		NoDupla atual = this.prim;
		while (atual != null) {
			NoDupla auxiliar = atual.getProx();
			while (auxiliar != null) {
				if (atual.getInfo().getChave() == auxiliar.getInfo().getChave()) {
					if (auxiliar == this.ult) {
						this.ult = auxiliar.getAnt();
						this.ult.setProx(null);
					} else {
						auxiliar.getAnt().setProx(auxiliar.getProx());
						auxiliar.getProx().setAnt(auxiliar.getAnt());
					}
					auxiliar = auxiliar.getProx();
					this.quantNos--;

				} else {
					auxiliar = auxiliar.getProx();
				}
			}
			atual = atual.getProx();
		}
	}

	// atividade 04 - questao 12
	public String mostrarAcimaDe20() {
		NoDupla atual = this.prim;
		String msg = "";
		while (atual != null) {
			if (atual.getInfo().getChave() > 2.0) {
				msg += atual.getInfo().getChave() + "\n";
			}

			atual = atual.getProx();
		}

		return msg;
	}

	// atividade 04 - questao 13
	public void inserirPacote(ListaDupla l2) {
		NoDupla atual = this.prim;
		while (atual != null) {
			if (atual.getInfo().getChave() > 100) {
				l2.inserirUltimo(new Item(atual.getInfo().getChave()));
				this.quantNos++;
			}
			atual = atual.getProx();
		}

	}

	// atividade 04 - questao 14
	public boolean acharPalindromo() {

		NoDupla atual = this.prim;

		NoDupla auxiliar = this.ult;

		while (atual != null && auxiliar != null && atual != auxiliar && atual.getAnt() != auxiliar) {
			if (atual.getInfo().getChave() != auxiliar.getInfo().getChave()) {
				return false;
			}
			atual = atual.getProx();
			auxiliar = auxiliar.getAnt();
		}
		return true;

	}

	// atividade 04 - questao 15
	public void inserirOrdenado(Item elem) {
		NoDupla novoNo = new NoDupla(elem);

		if (elem.getChave() < this.prim.getInfo().getChave()) {
			novoNo.setProx(this.prim);
			this.prim.setAnt(novoNo);
			this.prim = novoNo;
		}

		else if (elem.getChave() > this.ult.getInfo().getChave()) {
			novoNo.setAnt(this.ult);
			this.ult.setProx(novoNo);
			this.ult = novoNo;
		}

		else {
			NoDupla atual = this.prim.getProx();
			while (atual != null && elem.getChave() > atual.getInfo().getChave()) {
				atual = atual.getProx();
			}

			novoNo.setProx(atual);
			novoNo.setAnt(atual.getAnt());
			atual.getAnt().setProx(novoNo);
			atual.setAnt(novoNo);
		}
	}
}
