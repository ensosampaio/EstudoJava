package exercicios;

public class FuncionarioExercicio7 {
	private String nome;
	private int horaTrabalhada;
	private char categoria;
	
	public FuncionarioExercicio7(String nome, int horaTrabalhada, char categoria) {
		super();
		this.nome = nome;
		this.horaTrabalhada = horaTrabalhada;
		this.categoria = categoria;
	}
	public FuncionarioExercicio7() {
		super();
		this.nome = " ";
		this.horaTrabalhada = 0;
		this.categoria = ' ';
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getHoraTrabalhada() {
		return horaTrabalhada;
	}
	public void setHoraTrabalhada(int horaTrabalhada) {
		this.horaTrabalhada = horaTrabalhada;
	}
	public char getCategoria() {
		return categoria;
	}
	public void setCategoria(char categoria) {
		this.categoria = categoria;
	}
	@Override
	public String toString() {
	    return "Cliente: \n" +
	           "  Nome: " + nome + "\n" +
	           "  Horas Trabalhadas: " + horaTrabalhada + "\n" +
	           "  Categoria: " + categoria + "\n";
	}
	
	
	
	
	
	
	
	
	
	
	
}
