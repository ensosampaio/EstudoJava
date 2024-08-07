package pilha;

import dados.Item;

public class PilhaContigChar {
	private ItemChar[] info;
	private int topo;

	public PilhaContigChar(int qte) {
		this.topo = 0;
		this.info = new ItemChar[qte];
	}

	public ItemChar getInfo() {
		return this.info[this.topo - 1];
	}

	public int getTopo() {
		return this.topo;
	}

	public boolean eVazia() {
		return (this.topo == 0);
	}

	public boolean eCheia() {
		return (this.topo == this.info.length);
	}

	// inserir um novo dado no topo da pilha.
	public boolean empilhar(ItemChar elem) {
		if (this.eCheia())
			return false;
		else {
			this.info[this.topo] = elem;
			this.topo++;
			return true;
		}
	}

	// remove o dado que está no topo da pilha (somente um dado).
	public ItemChar desempilhar() {
		if (this.eVazia())
			return null;
		else {
			this.topo--;
			return this.info[this.topo];
		}
	}

	// Atividade 05 - questão 01
	public String inverterPalavra(String palavra) {
		String invertida = "";
		// PilhaContigChar pilha = new PilhaContigChar(palavra.length());
		for (int i = 0; i < palavra.length(); i++) {
			this.empilhar(new ItemChar(palavra.charAt(i)));
		}
		while (!this.eVazia()) {
			invertida += this.desempilhar().getChave();
		}
		return invertida;
	}

}