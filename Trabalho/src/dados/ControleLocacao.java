package dados;

import java.io.*;
import java.util.ArrayList;

public class ControleLocacao {
	private ArrayList<Locacao> listaLocacoes;
	private String arquivoLocacoes;

	public ControleLocacao(String arquivoLocacoes) {
		this.arquivoLocacoes = arquivoLocacoes;
		this.listaLocacoes = new ArrayList<>();
		carregarLocacoesDoArquivo();
	}

	public boolean adicionarLocacao(Locacao locacao) {
		listaLocacoes.add(locacao);
		salvarLocacoesNoArquivo();
		return true;
	}

	public void removerLocacao(Locacao locacao) {
		listaLocacoes.remove(locacao);
		salvarLocacoesNoArquivo();
	}

	public ArrayList<Locacao> getListaLocacoes() {
		return listaLocacoes;
	}

	public int quantidadeLocacoes() {
		return listaLocacoes.size();
	}

	public Locacao buscarLocacaoPorCodigo(int codigo) {
		for (Locacao locacao : listaLocacoes) {
			if (locacao.getCodigoLocacao() == codigo) {
				return locacao;
			}
		}
		return null;
	}

	public Locacao buscarDevolucaoPorCodigo(int codigo) {
		for (Locacao locacao : listaLocacoes) {
			if (locacao.getCodigoDevolucao() == codigo) {
				return locacao;
			}
		}
		return null;
	}

	public boolean existeCodigoLocacao(int codigo) {
		for (Locacao locacao : listaLocacoes) {
			if (locacao.getCodigoLocacao() == codigo) {
				return true;
			}
		}
		return false;
	}

	public boolean existeCodigoDevolucao(int codigo) {
		for (Locacao locacao : listaLocacoes) {
			if (locacao.getCodigoDevolucao() == codigo) {
				return true;
			}
		}
		return false;
	}

	public boolean atualizarLocacao(int codigo, String dataLocacao, String dataDevolucao) {
		Locacao locacao = buscarLocacaoPorCodigo(codigo);
		if (locacao != null) {
			locacao.setDataLocacao(dataLocacao);
			locacao.setDataDevolucao(dataDevolucao);
			salvarLocacoesNoArquivo();
			return true;
		}
		return false;
	}

	public boolean atualizarDevolucao(int codigo, int codigoDevolucao) {
		Locacao locacao = buscarLocacaoPorCodigo(codigo);
		if (locacao != null) {
			locacao.setCodigoDevolucao(codigoDevolucao);
			salvarLocacoesNoArquivo();
			return true;
		}
		return false;
	}

	public boolean LocacaoDevolvida(int codigoLocacao) {
		Locacao locacao = buscarLocacaoPorCodigo(codigoLocacao);
		return locacao != null && locacao.getCodigoDevolucao() != 0;
	}

	private void carregarLocacoesDoArquivo() {
		try (BufferedReader ler = new BufferedReader(new FileReader(arquivoLocacoes))) {
			String linha;
			StringBuilder locacaoString = new StringBuilder();

			while ((linha = ler.readLine()) != null) {
				if (linha.trim().isEmpty()) {
					if (locacaoString.length() > 0) {
						Locacao locacao = Locacao.fromString(locacaoString.toString().trim());
						listaLocacoes.add(locacao);
						locacaoString.setLength(0);
					}
				} else {
					locacaoString.append(linha).append("\n");
				}
			}

			if (locacaoString.length() > 0) {
				Locacao locacao = Locacao.fromString(locacaoString.toString().trim());
				listaLocacoes.add(locacao);
			}

		} catch (IOException e) {
			System.err.println("Erro ao ler o arquivo de locações: " + e.getMessage());
		}
	}

	private void salvarLocacoesNoArquivo() {
		try (BufferedWriter escrever = new BufferedWriter(new FileWriter(arquivoLocacoes))) {
			for (Locacao locacao : listaLocacoes) {
				escrever.write(locacao.toString());
				escrever.newLine();
				escrever.newLine();
			}
		} catch (IOException e) {
			System.err.println("Erro ao escrever no arquivo de locações: " + e.getMessage());
		}
	}
}
