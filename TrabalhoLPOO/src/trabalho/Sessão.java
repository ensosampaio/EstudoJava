package trabalho;

public class Sessão {

	private String nomeFilme;
	private String horario;
	private static double preco = 50;

	
	public Sessão(String nomeFilme, String horario) {
		super();
		this.nomeFilme = nomeFilme;
		this.horario = horario;
	}

	public Sessão() {
		super();
		this.nomeFilme = "";
		this.horario = "";
	}
	
	public String getNomeFilme() {
		return nomeFilme;
	}

	
	public void setNomeFilme(String nomeFilme) {
		this.nomeFilme = nomeFilme;
	}

	
	public String getHorario() {
		return horario;
	}

	
	public void setHorario(String horario) {
		this.horario = horario;
	}

	
	public static double getPreco() {
		return preco;
	}

	
	public static void setPreco(double preco) {
		Sessão.preco = preco;
	}

}
