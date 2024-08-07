package dados;

import java.util.ArrayList;
import java.util.Arrays;

public class Jogo {

	private int codigoJogo;
	private String titulo;
	private String genero;
	private String plataforma;
	private double precoJogo;
	private int quantidade;

	public Jogo(int codigoJogo, String titulo, String genero, String plataforma, double precoJogo, int quantidade) {
		this.codigoJogo = codigoJogo;
		this.titulo = titulo;
		this.genero = genero;
		this.plataforma = plataforma;
		this.precoJogo = precoJogo;
		this.quantidade = quantidade;
	}

	public Jogo() {
		this.codigoJogo = 0;
		this.titulo = " ";
		this.genero = " ";
		this.plataforma = " ";
		this.precoJogo = 0;
		this.quantidade = 0;
	}

	public int getCodigoJogo() {
		return codigoJogo;
	}

	public void setCodigoJogo(int codigoJogo) {
		this.codigoJogo = codigoJogo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getPlataforma() {
		return plataforma;
	}

	public void setPlataforma(String plataforma) {
		this.plataforma = plataforma;
	}

	public double getPrecoJogo() {
		return precoJogo;
	}

	public void setPrecoJogo(double precoJogo) {
		this.precoJogo = precoJogo;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	@Override
	public String toString() {
		return "Codigo jogo: " + codigoJogo + ", " + "Titulo: " + titulo + ", " + "Genero: " + genero + ", "
				+ "Plataforma: " + plataforma + ", " + "Preço do jogo: R$" + precoJogo + ", "
				+ "Quantidade em estoque: " + quantidade;
	}

	public static Jogo fromString(String str) {
		ArrayList<String> parte = new ArrayList<>(Arrays.asList(str.split(", ")));

		System.out.println("Debug: partes da string - " + parte);

		if (parte.size() < 6) {
			System.err.println("Formato de string inválido para Jogo: " + str);
			throw new IllegalArgumentException("Formato de string inválido para Jogo");
		}

		int codigoJogo = Integer.parseInt(parte.get(0).replace("Codigo jogo: ", "").trim());
		String titulo = parte.get(1).replace("Titulo: ", "").trim();
		String genero = parte.get(2).replace("Genero: ", "").trim();
		String plataforma = parte.get(3).replace("Plataforma: ", "").trim();
		double precoJogo = Double.parseDouble(parte.get(4).replace("Preço do jogo: R$", "").trim());
		int quantidade = Integer.parseInt(parte.get(5).replace("Quantidade em estoque: ", "").trim());
		return new Jogo(codigoJogo, titulo, genero, plataforma, precoJogo, quantidade);
	}
}
