package classe;

public class Pessoa {
	String nome;
	double peso;

	public Pessoa(String nome, double peso) {
		this.nome = nome;
		this.peso = peso;
	}

	public Pessoa() {
		this.nome = " ";
		this.peso = 0;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	@Override
	public String toString() {
		return "Pessoa [nome=" + nome + ", peso=" + peso + "]";
	}


	public void comer(Comida comida) {
		if(comida != null) {
			this.peso += comida.pesoComida;
		}
	}












}
