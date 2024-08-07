package dados;

import java.util.ArrayList;
import java.io.*;

public class ControleFuncionario {
	private ArrayList<Funcionario> listaFuncionarios;
	private String arquivoFuncionarios;

	public ControleFuncionario(String arquivoFuncionarios) {
		this.arquivoFuncionarios = arquivoFuncionarios;
		this.listaFuncionarios = new ArrayList<>();
		carregarFuncionariosDoArquivo();
	}

	public boolean adicionarFuncionario(Funcionario funcionario) {
		listaFuncionarios.add(funcionario);
		salvarFuncionariosNoArquivo();
		return true;
	}

	public void removerFuncionario(Funcionario funcionario) {
		listaFuncionarios.remove(funcionario);

		salvarFuncionariosNoArquivo();

	}

	public ArrayList<Funcionario> getListaFuncionarios() {
		return listaFuncionarios;
	}

	public int quantidadeFuncionarios() {
		return listaFuncionarios.size();
	}

	public Funcionario buscarFuncionarioPorCodigo(int codigo) {
		for (int i = 0; i < listaFuncionarios.size(); i++) {
			Funcionario funcionario = listaFuncionarios.get(i);
			if (funcionario.getCodigoFuncionario() == codigo) {
				return funcionario;
			}
		}
		return null;
	}

	public boolean existeCodigoFuncionario(int codigo) {
		for (Funcionario funcionario : listaFuncionarios) {
			if (funcionario.getCodigoFuncionario() == codigo) {
				return true;
			}
		}
		return false;
	}
	
	
	public boolean atualizarFuncionario(int codigo, String nome, String endereco, int idade, double salario,
			String cargo) {
		Funcionario funcionario = buscarFuncionarioPorCodigo(codigo);
		if (funcionario != null) {
			funcionario.setNomePessoa(nome);
			funcionario.setEndereco(endereco);
			funcionario.setIdade(idade);
			funcionario.setSalario(salario);
			funcionario.setCargo(cargo);
			salvarFuncionariosNoArquivo();
			return true;
		}
		return false;
	}

	private void carregarFuncionariosDoArquivo() {
		try (BufferedReader ler = new BufferedReader(new FileReader(arquivoFuncionarios))) {
			String linha;
			StringBuilder funcionarioString = new StringBuilder();
			while ((linha = ler.readLine()) != null) {
				if (linha.trim().isEmpty()) {
					if (funcionarioString.length() > 0) {
						Funcionario funcionario = Funcionario.fromString(funcionarioString.toString().trim());
						listaFuncionarios.add(funcionario);
						funcionarioString.setLength(0);
					}
				} else {

					funcionarioString.append(linha).append("\n");
				}
			}

			if (funcionarioString.length() > 0) {
				Funcionario funcionario = Funcionario.fromString(funcionarioString.toString().trim());
				listaFuncionarios.add(funcionario);
			}

		} catch (IOException e) {
			System.err.println("Erro ao ler o arquivo de clientes: " + e.getMessage());
		}
	}

	private void salvarFuncionariosNoArquivo() {
		try (BufferedWriter escrever = new BufferedWriter(new FileWriter(arquivoFuncionarios))) {
			for (Funcionario funcionario : listaFuncionarios) {
				escrever.write(funcionario.toString());
				escrever.newLine();
				escrever.newLine();
			}
		} catch (IOException e) {
			System.err.println("Erro ao escrever no arquivo de clientes: " + e.getMessage());
		}
	}


}