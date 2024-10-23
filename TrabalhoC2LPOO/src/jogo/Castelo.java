package jogo;

public abstract class Castelo {

		private int defesa;
		private int pontosVida;
		private String nome;
		
		public Castelo(int defesa, int pontosVida, String nome) {
			super();
			this.defesa = defesa;
			this.pontosVida = pontosVida;
			this.nome = nome;
		}

		public int getDefesa() {
			return defesa;
		}

		public void setDefesa(int defesa) {
			this.defesa = defesa;
		}

		public int getPontosVida() {
			return pontosVida;
		}

		public void setPontosVida(int pontosVida) {
			this.pontosVida = pontosVida;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}
		
		public String situacao() {
			return "Nome: " + this.nome + " Vida: "+ this.pontosVida + " Defesa: "+ this.defesa;
		}
		
		public boolean ataque(int p) {
			if (this.defesa > 0) {
				this.defesa -= p;
				return true;
			}
			else {
				if(this.pontosVida>0) {
					this.pontosVida -=p;
					this.defesa = 2;
					return true;
				}
				else {
					return false;
				}
			}

		}
	
}
