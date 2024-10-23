package exercicioDiagnostico;

public class Paciente {

	private String nome;
	public String CPF;
	private String dataNascimento;
	private String historico;
	
	public Paciente(String nome, String historico) {
		this.nome = nome;
		this.historico = historico;
	}
	public Paciente() {
		this.nome = "";
		this.historico = "";
	}
	
	
	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getCPF() {
		return CPF;
	}


	public void setCPF(String cPF) {
		CPF = cPF;
	}


	public String getDataNascimento() {
		return dataNascimento;
	}


	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}


	public String getHistorico() {
		return historico;
	}


	public void setHistorico(String historico) {
		this.historico = historico;
	}


	@Override
	public String toString() {
		return "Paciente: Nome: " + nome + ", CPF: " + CPF + ", Data de Nascimento: " + dataNascimento + "\nHistorico: "
				+ historico;
	}
	
	
	
	
	
	
	
	
	
	
	
}
