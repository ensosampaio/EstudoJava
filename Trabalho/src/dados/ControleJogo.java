package dados;

import java.io.*;
import java.util.ArrayList;

public class ControleJogo {
	private ArrayList<Jogo> listaJogos;
	private String arquivoJogos;

	public ControleJogo(String arquivoJogos) {
		this.arquivoJogos = arquivoJogos;
		this.listaJogos = new ArrayList<>();
		carregarJogosDoArquivo();
	}

	public boolean adicionarJogo(Jogo jogo) {
		listaJogos.add(jogo);
		salvarJogosNoArquivo();
		return true;
	}

	public void removerJogo(Jogo jogo) {
		listaJogos.remove(jogo);

		salvarJogosNoArquivo();

	}

	public ArrayList<Jogo> getListaJogos() {
		return listaJogos;
	}

	public int quantidadeJogos() {
		return listaJogos.size();
	}

	public Jogo buscarJogoPorCodigo(int codigo) {
		for (int i = 0; i < listaJogos.size(); i++) {
			Jogo jogo = listaJogos.get(i);
			if (jogo.getCodigoJogo() == codigo) {
				return jogo;
			}
		}
		return null;
	}

	public boolean existeCodigoJogo(int codigo) {
		for (Jogo jogo : listaJogos) {
			if (jogo.getCodigoJogo() == codigo) {
				return true;
			}
		}
		return false;
	}

	
	public boolean atualizarJogo(int codigo, double precoJogo, int quantidade, String genero) {
		Jogo jogo = buscarJogoPorCodigo(codigo);
		if (jogo != null) {
			jogo.setPrecoJogo(precoJogo);
			jogo.setQuantidade(quantidade);
			jogo.setGenero(genero);
			salvarJogosNoArquivo();
			return true;
		}
		return false;
	}
	public boolean atualizarJogoLocacao(int codigo,int quantidade) {
		Jogo jogo = buscarJogoPorCodigo(codigo);
		if (jogo != null) {
			jogo.setQuantidade(quantidade);
			salvarJogosNoArquivo();
			return true;
		}
		return false;
	}
	public boolean atualizarJogoDevolucao(int codigo,int quantidade) {
		Jogo jogo = buscarJogoPorCodigo(codigo);
		if (jogo != null) {
			jogo.setQuantidade(quantidade);
			salvarJogosNoArquivo();
			return true;
		}
		return false;
	}
	
	public double lucroJogo(int codigo) {
	    Jogo jogo = buscarJogoPorCodigo(codigo);
	    if (jogo != null) {
	        return jogo.getPrecoJogo() * jogo.getQuantidade();
	    } else {
	        return 0;
	    }
	}
	

	
	private void carregarJogosDoArquivo() {
		try (BufferedReader ler = new BufferedReader(new FileReader(arquivoJogos))) {
			String linha;
			StringBuilder jogoString = new StringBuilder();

			while ((linha = ler.readLine()) != null) {

				if (linha.trim().isEmpty()) {
					if (jogoString.length() > 0) {

						Jogo jogo = Jogo.fromString(jogoString.toString().trim());
						listaJogos.add(jogo);
						jogoString.setLength(0);
					}
				} else {

					jogoString.append(linha).append("\n");
				}
			}

			if (jogoString.length() > 0) {
				Jogo jogo = Jogo.fromString(jogoString.toString().trim());
				listaJogos.add(jogo);
			}

		} catch (IOException e) {
			System.err.println("Erro ao ler o arquivo de jogos: " + e.getMessage());
		}
	}

	private void salvarJogosNoArquivo() {
		try (BufferedWriter escrever = new BufferedWriter(new FileWriter(arquivoJogos))) {
			for (Jogo jogo : listaJogos) {
				escrever.write(jogo.toString());
				escrever.newLine();
				escrever.newLine();
			}
		} catch (IOException e) {
			System.err.println("Erro ao escrever no arquivo de clientes: " + e.getMessage());
		}
	}
}