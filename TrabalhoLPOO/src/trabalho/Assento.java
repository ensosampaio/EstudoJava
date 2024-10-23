package trabalho;

import java.util.ArrayList;

public class Assento {
	private ArrayList<Sessão> filmes;
	private ArrayList<ArrayList<String>> assento;
	private static int coluna = 5;
	private static int fila = 4;

	public Assento() {
		filmes = new ArrayList<Sessão>(5);
		assento = new ArrayList<ArrayList<String>>();
		for (int i = 0; i < fila; i++) {
			ArrayList<String> linha = new ArrayList<>();
			for (int j = 0; j < coluna; j++) {
				linha.add(" ");
			}
			assento.add(linha);
		}
	}

	public void exibirAssentos() {
		for (ArrayList<String> linha : assento) {
			System.out.println(linha);
		}
	}

	public boolean checarAssentos(int linha, int coluna) {
		if (linha >= 0 && linha < fila && coluna >= 0 && coluna < this.coluna) {
			if (assento.get(linha).get(coluna).equals(" ")) {
				return true;
			}

		}
		return false;
	}

	public boolean vender(int linha, int coluna) {
		if (checarAssentos(linha, coluna) == true) {
			assento.get(linha).set(coluna, "X");
			return true;
		}
		return false;
	}

	public boolean eCheia() {
		if (filmes.size() > 4) {
			return true;
		}
		return false;
	}

	public boolean adicionarFilme(Sessão sessão) {
		if (!eCheia() && !checarFilme(sessão.getNomeFilme())) {
			filmes.add(sessão);
			return true;
		}
		return false;
	}

	public String exibirFilmes() {

		String resultado = "";
		for (Sessão filme : filmes) {
			resultado += filme.getNomeFilme() + "\n";
		}
		return resultado;
	}

	public boolean checarFilme(String nome) {
		for (Sessão sessão : filmes) {
			if (sessão.getNomeFilme().equalsIgnoreCase(nome)) {
				return true;
			}
		}
		return false;
	}

}
