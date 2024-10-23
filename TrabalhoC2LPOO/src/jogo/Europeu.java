package jogo;

public class Europeu extends Castelo {

	private int numPaladino;

	public Europeu(int defesa, int pontosVida, String nome, int numPaladino) {
		super(defesa, pontosVida, nome);
		this.numPaladino = numPaladino;
	}

	public int getNumPaladino() {
		return numPaladino;
	}

	public void setNumPaladino(int numPaladino) {
		this.numPaladino = numPaladino;
	}

	@Override
	public String situacao() {
		return super.situacao() + " NumPaladino: " + this.numPaladino;
	}

	@Override
	public boolean ataque(int p) {

		this.numPaladino -= p;

		if (this.numPaladino <= 0) {
			boolean resultado = super.ataque(p);
			if (resultado) {
				this.numPaladino += 10;
			}
			return resultado;
		}
		return true;

	}

}
