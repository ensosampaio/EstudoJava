package jogo;

public class Japones extends Castelo {

	private int numSamurai;

	public Japones(int defesa, int pontosVida, String nome, int numSamurai) {
		super(defesa, pontosVida, nome);
		this.numSamurai = numSamurai;

	}

	public int getNumSamurai() {
		return numSamurai;
	}

	public void setNumSamurai(int numSamurai) {
		this.numSamurai = numSamurai;
	}

	@Override
	public String situacao() {
		return super.situacao() + " NumSamurai: " + this.numSamurai;
	}

	@Override
	public boolean ataque(int p) {
		this.numSamurai -= p;

		if (this.numSamurai <= 0) {
			boolean resultado = super.ataque(p);
			if (resultado) {
				this.numSamurai += 15;
			}
			return resultado;
		}

		return true;
	}

}
