package classe;

public class Comida {

	String nomeComida;
	double pesoComida;

	public Comida(String nomeComida, double pesoComida) {
		super();
		this.nomeComida = nomeComida;
		this.pesoComida = pesoComida;
	}

	public Comida() {
		super();
		this.nomeComida = "";
		this.pesoComida = 0;
	}

	public String getNomeComida() {
		return nomeComida;
	}

	public void setNomeComida(String nomeComida) {
		this.nomeComida = nomeComida;
	}

	public double getPesoComida() {
		return pesoComida;
	}

	public void setPesoComida(double pesoComida) {
		this.pesoComida = pesoComida;
	}

	@Override
	public String toString() {
		return "Comida [nomeComida=" + nomeComida + ", pesoComida=" + pesoComida + "]";
	}









}
