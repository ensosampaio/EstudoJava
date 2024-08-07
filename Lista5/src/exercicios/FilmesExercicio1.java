package exercicios;

public class FilmesExercicio1 {

	private int codigo;
	private String titulo;
	private char genero;

	public FilmesExercicio1(int codigo, String titulo, char genero) {
		this.codigo = codigo;
		this.titulo = titulo;
		this.genero = genero;
	}

	public FilmesExercicio1() {
		this.codigo = 0;
		this.titulo = " ";
		this.genero = ' ';
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public char getGenero() {
		return genero;
	}

	public void setGenero(char genero) {
		this.genero = genero;
	}

	@Override
	public String toString() {
		return "\nFilme: " + this.titulo + "\n" + "Codigo: " + this.codigo + "\nGenero: " + this.genero;

	}

}
