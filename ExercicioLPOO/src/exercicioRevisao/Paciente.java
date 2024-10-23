package exercicioRevisao;

public class Paciente {
	private String nome;
	private String cpf;
	private String dataNasc;
	private String historico;
	
	public Paciente(String nome, String cpf, String dataNasc, String historico) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.dataNasc = dataNasc;
		this.historico = historico;
	}
	
	
	public Paciente() {
		super();
		this.nome = "";
		this.cpf = "";
		this.dataNasc = "";
		this.historico = "";
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getCpf() {
		return cpf;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


	public String getDataNasc() {
		return dataNasc;
	}


	public void setDataNasc(String dataNasc) {
		this.dataNasc = dataNasc;
	}


	public String getHistorico() {
		return historico;
	}


	public void setHistorico(String historico) {
		this.historico = historico;
	}


	@Override
	public String toString() {
		return "Paciente [nome=" + nome + ", cpf=" + cpf + ", dataNasc=" + dataNasc + ", historico=" + historico + "]";
	}
	
	
	
	
	
	
	
}
