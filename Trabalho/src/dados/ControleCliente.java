package dados;

import java.io.*;
import java.util.ArrayList;

public class ControleCliente {
	private ArrayList<Cliente> listaCliente;

	private String arquivoClientes;

	public ControleCliente(String arquivoClientes) {
		this.arquivoClientes = arquivoClientes;
		this.listaCliente = new ArrayList<>();
		carregarClientesDoArquivo();
	}

	public boolean adicionarCliente(Cliente cliente) {
		listaCliente.add(cliente);
		salvarClientesNoArquivo();
		return true;
	}

	public void removerCliente(Cliente cliente) {
		listaCliente.remove(cliente);
		salvarClientesNoArquivo();
	}

	public ArrayList<Cliente> getListaClientes() {
		return listaCliente;
	}

	public int quantidadeCliente() {
		return listaCliente.size();
	}

	public Cliente buscarClientePorCodigo(int codigo) {
		for (int i = 0; i < listaCliente.size(); i++) {
			Cliente cliente = listaCliente.get(i);
			if (cliente.getCodigoCliente() == codigo) {
				return cliente;
			}
		}
		return null;
	}

	public boolean existeCodigoCliente(int codigo) {
		for (Cliente cliente : listaCliente) {
			if (cliente.getCodigoCliente() == codigo) {
				return true;
			}
		}
		return false;
	}

	public boolean atualizarCliente(int codigo, String nome, String endereco, int idade) {
		Cliente cliente = buscarClientePorCodigo(codigo);
		if (cliente != null) {
			cliente.setNomePessoa(nome);
			cliente.setEndereco(endereco);
			cliente.setIdade(idade);
			salvarClientesNoArquivo();
			return true;
		}
		return false;
	}

	public boolean atualizarLocacao(int codigo, double debito, String historico) {
		Cliente cliente = buscarClientePorCodigo(codigo);
		if (cliente != null) {
			cliente.setDebito(debito);
			cliente.setHistorico(historico);
			salvarClientesNoArquivo();
			return true;
		}
		return false;
	}

	private void carregarClientesDoArquivo() {
		try (BufferedReader ler = new BufferedReader(new FileReader(arquivoClientes))) {
			String linha;
			StringBuilder clienteString = new StringBuilder();
			while ((linha = ler.readLine()) != null) {

				if (linha.trim().isEmpty()) {
					if (clienteString.length() > 0) {

						Cliente cliente = Cliente.fromString(clienteString.toString().trim());
						listaCliente.add(cliente);
						clienteString.setLength(0);
					}
				} else {

					clienteString.append(linha).append("\n");
				}
			}

			if (clienteString.length() > 0) {
				Cliente cliente = Cliente.fromString(clienteString.toString().trim());
				listaCliente.add(cliente);
			}

		} catch (IOException e) {
			System.err.println("Erro ao ler o arquivo de clientes: " + e.getMessage());
		}
	}

	private void salvarClientesNoArquivo() {
		try (BufferedWriter escrever = new BufferedWriter(new FileWriter(arquivoClientes))) {
			for (Cliente cliente : listaCliente) {

				escrever.write(cliente.toString());
				escrever.newLine();
				escrever.newLine();
			}
		} catch (IOException e) {
			System.err.println("Erro ao escrever no arquivo de clientes: " + e.getMessage());
		}
	}
}