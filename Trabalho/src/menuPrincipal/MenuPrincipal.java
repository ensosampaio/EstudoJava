package menuPrincipal;

import java.io.FileReader;

import java.io.File;

import java.io.IOException;
import java.io.BufferedReader;

import java.util.Scanner;

import dados.ControleCliente;
import dados.ControleFuncionario;
import dados.ControleJogo;
import dados.ControleLocacao;

import dados.Cliente;
import dados.Funcionario;
import dados.Jogo;
import dados.Locacao;

public class MenuPrincipal {
	static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {
		String arquivoCliente = "controleCliente.txt";
		String arquivoFuncionario = "controleFuncionario.txt";
		String arquivoJogo = "controleJogo.txt";
		String arquivoLocacao = "controleLocacao.txt";

		try {
			criarArquivo(arquivoCliente);
			criarArquivo(arquivoFuncionario);
			criarArquivo(arquivoJogo);
			criarArquivo(arquivoLocacao);
		} catch (IOException e) {
			System.err.println("Erro ao criar arquivo! " + e.getMessage());
			return;
		}

		ControleCliente cliente = new ControleCliente("controleCliente.txt");
		ControleFuncionario funcionario = new ControleFuncionario("controleFuncionario.txt");
		ControleJogo jogo = new ControleJogo("controleJogo.txt");
		ControleLocacao locacao = new ControleLocacao("controleLocacao.txt");

		int opcao;

		do {
			System.out.println(
					"\n--- Menu elaborado por ARTHUR CHAGAS, ENZO SAMPAIO, LUCAS COSTA, PEDRO HENRIQUE MARQUES, VICTOR OLIVEIRA, VINICIUS DE SOUZA,---");
			System.out.println("1. Menu Funcionario");
			System.out.println("2. Menu Cliente");
			System.out.println("3. Menu Jogo");
			System.out.println("4. Menu Locação");
			System.out.println("0. SAIR");
			opcao = Integer.parseInt(teclado.nextLine());

			switch (opcao) {
			case 1:
				int subOpcaoFuncionario;
				do {
					System.out.println("1. Cadastrar novo funcionario");
					System.out.println("2. Mostrar funcionários");
					System.out.println("3. Deletar funcionário");
					System.out.println("4. Atualizar funcionário");
					System.out.println("0. Retornar ao Menu Anterior");
					subOpcaoFuncionario = Integer.parseInt(teclado.nextLine());
					switch (subOpcaoFuncionario) {
					case 1:
						cadastrarFuncionario(funcionario);
						break;
					case 2:
						lerFuncionario();
						break;
					case 3:
						deletarFuncionario(funcionario);
						break;
					case 4:
						atualizarFuncionario(funcionario);
						break;
					case 0:
						System.out.println("Retornando ao menu anterior...");
						break;
					default:
						System.out.println("\nOpção inválida, por favor, tente novamente.");
					}
				} while (subOpcaoFuncionario != 0);
				break;
			case 2:
				int subOpcaoCliente;
				do {
					System.out.println("1. Cadastrar novo cliente");
					System.out.println("2. Mostrar Clientes");
					System.out.println("3. Deletar cliente");
					System.out.println("4. Atualizar cliente");
					System.out.println("0. Retornar ao Menu Anterior");
					subOpcaoCliente = Integer.parseInt(teclado.nextLine());
					switch (subOpcaoCliente) {
					case 1:
						cadastrarCliente(cliente);
						break;
					case 2:
						lerCliente();
						break;
					case 3:
						deletarCliente(cliente);
						break;
					case 4:
						atualizarCliente(cliente);
						break;
					case 0:
						System.out.println("Retornando ao menu anterior...");
						break;
					default:
						System.out.println("\nOpção inválida, por favor, tente novamente.");
					}
				} while (subOpcaoCliente != 0);
				break;
			case 3:
				int subOpcaoJogo;
				do {
					System.out.println("1. Cadastrar novo jogo");
					System.out.println("2. Mostrar jogos cadastrados");
					System.out.println("3. Deletar jogo");
					System.out.println("4. Atualizar jogo");
					System.out.println("5. Calcular lucro (usar antes de realizar locação)");
					System.out.println("0. Retornar ao Menu Anterior");
					subOpcaoJogo = Integer.parseInt(teclado.nextLine());
					switch (subOpcaoJogo) {
					case 1:
						cadastrarJogo(jogo);
						break;
					case 2:
						lerJogo();
						break;
					case 3:
						deletarJogo(jogo);
						break;
					case 4:
						atualizarJogo(jogo);
						break;
					case 5:
						calcularLucro(jogo);
						break;
					case 0:
						System.out.println("Retornando ao menu anterior...");
						break;
					default:
						System.out.println("\nOpção inválida, por favor, tente novamente.");
					}
				} while (subOpcaoJogo != 0);
				break;
			case 4:
				int subOpcaoLocacao;
				do {
					System.out.println("1. Cadastrar uma locação");
					System.out.println("2. Mostrar as locações");
					System.out.println("3. Atualizar locação");
					System.out.println("4. Realizar devolução");
					System.out.println("0. Retornar ao Menu Anterior");
					subOpcaoLocacao = Integer.parseInt(teclado.nextLine());
					switch (subOpcaoLocacao) {
					case 1:
						registrarLocacao(locacao, cliente, jogo);
						break;
					case 2:
						lerLocacao();
						break;
					case 3:
						atualizarLocacao(locacao);
						break;
					case 4:
						devolverJogo(locacao, cliente, jogo);
						break;
					case 0:
						System.out.println("Retornando ao menu anterior...");
						break;
					default:
						System.out.println("\nOpção inválida, por favor, tente novamente.");
					}
				} while (subOpcaoLocacao != 0);
				break;
			case 0:
				System.out.println("Fim do programa!");
				break;
			default:
				System.out.println("\nOpção inválida, por favor, tente novamente.");
			}
		} while (opcao != 0);

	}

	public static void cadastrarCliente(ControleCliente controleCliente) {
		Cliente cliente = new Cliente();

		int codigo;
		while (true) {
			System.out.println("Digite o código do cliente: ");
			codigo = Integer.parseInt(teclado.nextLine());

			if (!controleCliente.existeCodigoCliente(codigo)) {
				break;
			} else {
				System.out.println("Código já existe! Por favor, digite um código diferente!");
			}
		}

		System.out.println("Digite o nome do cliente: ");
		String nomeCliente = teclado.nextLine();

		System.out.println("Digite o CPF do cliente: ");
		String CPF = teclado.nextLine();

		System.out.println("Digite o endereço do cliente: ");
		String endereco = teclado.nextLine();

		System.out.println("Digite a idade do cliente: ");
		int idade = Integer.parseInt(teclado.nextLine());

		cliente.setNomePessoa(nomeCliente);
		cliente.setCpf(CPF);
		cliente.setEndereco(endereco);
		cliente.setIdade(idade);
		cliente.setCodigoCliente(codigo);

		if (controleCliente.adicionarCliente(cliente)) {
			System.out.println("Cliente cadastrado com sucesso!");
		} else {
			System.out.println("Erro ao cadastrar cliente");
		}

	}

	public static void cadastrarFuncionario(ControleFuncionario controleFuncionario) {
		Funcionario funcionario = new Funcionario();

		int codigo;
		while (true) {
			System.out.println("Digite o código do funcionário: ");
			codigo = Integer.parseInt(teclado.nextLine());

			if (!controleFuncionario.existeCodigoFuncionario(codigo)) {
				break;
			} else {
				System.out.println("Código já existe! Por favor, digite um código diferente!");
			}
		}

		System.out.println("Digite o nome do funcionário: ");
		String nomeFuncionario = teclado.nextLine();

		System.out.println("Digite o CPF do funcionário: ");
		String CPF = teclado.nextLine();

		System.out.println("Digite o endereço do funcionário: ");
		String endereco = teclado.nextLine();

		System.out.println("Digite a idade do funcionário: ");
		int idade = Integer.parseInt(teclado.nextLine());

		System.out.println("Digite o salário do funcionário: ");
		double salario = Double.parseDouble(teclado.nextLine());

		System.out.println("Digite o cargo do funcionário: ");
		String cargo = teclado.nextLine();

		funcionario.setNomePessoa(nomeFuncionario);
		funcionario.setCpf(CPF);
		funcionario.setEndereco(endereco);
		funcionario.setIdade(idade);
		funcionario.setCodigoFuncionario(codigo);
		funcionario.setSalario(salario);
		funcionario.setCargo(cargo);

		if (controleFuncionario.adicionarFuncionario(funcionario)) {
			System.out.println("Funcionário cadastrado com sucesso!");
		} else {
			System.out.println("Erro ao cadastrar funcionario!");
		}
	}

	public static void lerCliente() {
		try (BufferedReader ler = new BufferedReader(new FileReader("controleCliente.txt"))) {
			String linha;
			while ((linha = ler.readLine()) != null) {
				System.out.println(linha);
			}
		} catch (IOException e) {
			System.err.println("Erro ao ler o arquivo controleCliente.txt: " + e.getMessage());
		}
	}

	public static void lerFuncionario() {
		try (BufferedReader ler = new BufferedReader(new FileReader("controleFuncionario.txt"))) {
			String linha;
			while ((linha = ler.readLine()) != null) {
				System.out.println(linha);
			}
		} catch (IOException e) {
			System.err.println("Erro ao ler o arquivo controleFuncionario.txt: " + e.getMessage());
		}
	}

	public static void cadastrarJogo(ControleJogo controleJogo) {
		Jogo jogo = new Jogo();

		int codigo;
		while (true) {
			System.out.println("Digite o código do jogo: ");
			codigo = Integer.parseInt(teclado.nextLine());

			if (!controleJogo.existeCodigoJogo(codigo)) {
				break;
			} else {
				System.out.println("Código já existe! Por favor, digite um código diferente!");
			}
		}

		System.out.println("Digite o título do jogo: ");
		String titulo = teclado.nextLine();

		System.out.println("Digite o gênero do jogo: ");
		String genero = teclado.nextLine();

		System.out.println("Digite a plataforma do jogo: ");
		String plataforma = teclado.nextLine();

		System.out.println("Digite o preço do jogo: ");
		double preco = Double.parseDouble(teclado.nextLine());

		System.out.println("Digite a quantidade do jogo em estoque: ");
		int quantJogo = Integer.parseInt(teclado.nextLine());

		jogo.setCodigoJogo(codigo);
		jogo.setTitulo(titulo);
		jogo.setGenero(genero);
		jogo.setPlataforma(plataforma);
		jogo.setPrecoJogo(preco);
		jogo.setQuantidade(quantJogo);

		if (controleJogo.adicionarJogo(jogo)) {
			System.out.println("Jogo cadastrado com sucesso!");
		} else {
			System.out.println("Erro ao cadastrar jogo!");
		}
	}

	public static void lerJogo() {
		try (BufferedReader ler = new BufferedReader(new FileReader("controleJogo.txt"))) {
			String linha;
			while ((linha = ler.readLine()) != null) {
				System.out.println(linha);
			}
		} catch (IOException e) {
			System.err.println("Erro ao ler o arquivo controleJogo.txt: " + e.getMessage());
		}
	}

	public static void registrarLocacao(ControleLocacao controleLocacao, ControleCliente controleCliente,
			ControleJogo controleJogo) {

		int codigoLocacao;
		while (true) {
			System.out.println("Digite o código da locação: ");
			codigoLocacao = Integer.parseInt(teclado.nextLine());

			if (!controleLocacao.existeCodigoLocacao(codigoLocacao)) {
				break;
			} else {
				System.out.println("Código já existe! Por favor, digite um código diferente!");
			}
		}

		System.out.println("Digite a data da locação: ");
		String dataLocacao = teclado.nextLine();

		System.out.println("Digite a data de devolução: ");
		String dataDevolucao = teclado.nextLine();

		System.out.println("Digite o código do cliente: ");
		int codigoCliente = Integer.parseInt(teclado.nextLine());
		Cliente cliente = controleCliente.buscarClientePorCodigo(codigoCliente);
		if (cliente == null) {
			System.out.println("Código de cliente não encontrado!");
			return;
		}

		System.out.println("Digite o código do jogo: ");
		int codigoJogo = Integer.parseInt(teclado.nextLine());
		Jogo jogo = controleJogo.buscarJogoPorCodigo(codigoJogo);
		if (jogo == null) {
			System.out.println("Código de jogo não encontrado!");
			return;
		}

		if (jogo.getQuantidade() > 0) {

			jogo.setQuantidade(jogo.getQuantidade() - 1);

			double novoDebito = cliente.getDebito() + jogo.getPrecoJogo();
			String novoHistorico = cliente.getHistorico();
			if (novoHistorico.isEmpty()) {
				novoHistorico = jogo.getTitulo();
			} else {
				novoHistorico += jogo.getTitulo() + ",";
			}
			cliente.setDebito(novoDebito);
			cliente.setHistorico(novoHistorico);

			controleCliente.atualizarLocacao(codigoCliente, cliente.getDebito(), cliente.getHistorico());
			controleJogo.atualizarJogo(jogo.getCodigoJogo(), jogo.getPrecoJogo(), jogo.getQuantidade(),
					jogo.getGenero());

			Locacao loc = new Locacao();
			loc.setCodigoLocacao(codigoLocacao);
			loc.setDataLocacao(dataLocacao);
			loc.setDataDevolucao(dataDevolucao);
			loc.setCodigoCliente(codigoCliente);
			loc.setCodigoJogo(codigoJogo);

			if (controleLocacao.adicionarLocacao(loc)) {
				System.out.println("Locação cadastrada com sucesso!");
			} else {
				System.out.println("Erro ao cadastrar locação!");
			}
		} else {
			System.out.println("Jogo fora de estoque!");
		}
	}

	public static void lerLocacao() {
		try (BufferedReader ler = new BufferedReader(new FileReader("controleLocacao.txt"))) {
			String linha;
			while ((linha = ler.readLine()) != null) {
				System.out.println(linha);
			}
		} catch (IOException e) {
			System.err.println("Erro ao ler o arquivo controleLocacao.txt: " + e.getMessage());
		}
	}

	public static void deletarCliente(ControleCliente controle) {
		System.out.println("Digite o código do cliente: ");
		int codigo = Integer.parseInt(teclado.nextLine());

		Cliente cliente = controle.buscarClientePorCodigo(codigo);
		if (cliente != null) {
			controle.removerCliente(cliente);
			System.out.println("Cliente removido com sucesso!");
		} else {
			System.out.println("Cliente não encontrado!");
		}
	}

	public static void deletarFuncionario(ControleFuncionario controle) {
		System.out.println("Digite o código do funcionário: ");
		int codigo = Integer.parseInt(teclado.nextLine());

		Funcionario funcionario = controle.buscarFuncionarioPorCodigo(codigo);
		if (funcionario != null) {
			controle.removerFuncionario(funcionario);
			System.out.println("Funcionário removido com sucesso!");
		} else {
			System.out.println("Funcionário não encontrado!");
		}
	}

	public static void deletarJogo(ControleJogo controle) {
		System.out.println("Digite o código do jogo: ");
		int codigo = Integer.parseInt(teclado.nextLine());

		Jogo jogo = controle.buscarJogoPorCodigo(codigo);
		if (jogo != null) {
			controle.removerJogo(jogo);
			System.out.println("Jogo removido com sucesso!");
		} else {
			System.out.println("Jogo não encontrado!");
		}
	}

	public static void atualizarCliente(ControleCliente controle) {
		System.out.println("Digite o código do cliente: ");
		int codigo = Integer.parseInt(teclado.nextLine());

		Cliente cliente = controle.buscarClientePorCodigo(codigo);
		if (cliente != null) {
			System.out.println("Digite o novo nome do cliente: ");
			String novoNome = teclado.nextLine();

			System.out.println("Digite o novo endereço do cliente: ");
			String novoEndereco = teclado.nextLine();

			System.out.println("Digite a nova idade do cliente: ");
			int idade = Integer.parseInt(teclado.nextLine());

			controle.atualizarCliente(codigo, novoNome, novoEndereco, idade);
			System.out.println("Cliente atualizado com sucesso!");
		} else {
			System.out.println("Cliente não encontrado!");
		}
	}

	public static void atualizarFuncionario(ControleFuncionario controle) {
		System.out.println("Digite o código do funcionário: ");
		int codigo = Integer.parseInt(teclado.nextLine());

		Funcionario funcionario = controle.buscarFuncionarioPorCodigo(codigo);
		if (funcionario != null) {
			System.out.println("Digite o novo nome do funcionário: ");
			String novoNome = teclado.nextLine();

			System.out.println("Digite o novo endereço do funcionário: ");
			String novoEndereco = teclado.nextLine();

			System.out.println("Digite a nova idade do funcionário: ");
			int novaIdade = Integer.parseInt(teclado.nextLine());

			System.out.println("Digite o novo salário do funcionário: ");
			double novoSalario = Double.parseDouble(teclado.nextLine());

			System.out.println("Digite o novo cargo do funcionário: ");
			String novoCargo = teclado.nextLine();

			controle.atualizarFuncionario(codigo, novoNome, novoEndereco, novaIdade, novoSalario, novoCargo);
			System.out.println("Funcionário atualizado com sucesso!");
		} else {
			System.out.println("Funcionário não encontrado!");
		}
	}

	public static void atualizarJogo(ControleJogo controle) {
		System.out.println("Digite o codigo do Jogo: ");
		int codigo = Integer.parseInt(teclado.nextLine());

		Jogo jogo = controle.buscarJogoPorCodigo(codigo);
		if (jogo != null) {
			System.out.println("Digite o novo preço do jogo: ");
			double precoJogo = Double.parseDouble(teclado.nextLine());

			System.out.println("Digite a quantidade atualizada: ");
			int quantidade = Integer.parseInt(teclado.nextLine());

			System.out.println("Digite o genero do jogo: ");
			String genero = teclado.nextLine();

			controle.atualizarJogo(codigo, precoJogo, quantidade, genero);
			System.out.println("Jogo atualizado com sucesso!");
		} else {
			System.out.println("Jogo não encontrado!");
		}
	}

	public static void atualizarLocacao(ControleLocacao controle) {
		System.out.println("Digite o código da Locação: ");
		int codigo = Integer.parseInt(teclado.nextLine());

		Locacao locacao = controle.buscarLocacaoPorCodigo(codigo);
		if (locacao != null) {
			System.out.println("Digite a nova data de locação: ");
			String dataLocacao = teclado.nextLine();

			System.out.println("Digite a nova data de devolução: ");
			String dataDevolucao = teclado.nextLine();

			controle.atualizarLocacao(codigo, dataLocacao, dataDevolucao);
			System.out.println("Locação atualizada com sucesso!");
		} else {
			System.out.println("Locação não encontrada!");
		}
	}

	public static void calcularLucro(ControleJogo controle) {
		System.out.println("Digite o código do jogo: ");
		int codigo = Integer.parseInt(teclado.nextLine());

		Jogo jogo = controle.buscarJogoPorCodigo(codigo);
		if (jogo != null) {
			System.out.printf("O lucro do jogo será de: R$%.2f%n", controle.lucroJogo(codigo));
		} else {
			System.out.println("Jogo não encontrado!");
		}

	}

	public static void devolverJogo(ControleLocacao controleLocacao, ControleCliente controleCliente,
			ControleJogo controleJogo) {

		int codigoLocacao;
		while (true) {
			try {
				System.out.println("Digite o código da locação: ");
				codigoLocacao = Integer.parseInt(teclado.nextLine());

				if (controleLocacao.existeCodigoLocacao(codigoLocacao)) {
					if (controleLocacao.LocacaoDevolvida(codigoLocacao)) {
						System.out.println("Esta locação já foi devolvida!");
						return;
					}
					break;
				} else {
					System.out.println("Código de locação não encontrado!");
				}
			} catch (NumberFormatException e) {
				System.out.println("Entrada inválida! Por favor, digite um número.");
			}
		}

		System.out.println("Digite o código do cliente: ");
		int codigoCliente;
		try {
			codigoCliente = Integer.parseInt(teclado.nextLine());
		} catch (NumberFormatException e) {
			System.out.println("Entrada inválida! Por favor, digite um número.");
			return;
		}

		Cliente cliente = controleCliente.buscarClientePorCodigo(codigoCliente);
		if (cliente == null) {
			System.out.println("Código de cliente não encontrado!");
			return;
		}

		System.out.println("Digite o código do jogo: ");
		int codigoJogo;
		try {
			codigoJogo = Integer.parseInt(teclado.nextLine());
		} catch (NumberFormatException e) {
			System.out.println("Entrada inválida! Por favor, digite um número.");
			return;
		}

		Jogo jogo = controleJogo.buscarJogoPorCodigo(codigoJogo);
		if (jogo == null) {
			System.out.println("Código de jogo não encontrado!");
			return;
		}

		System.out.println("Digite o código da devolução: ");
		int codigoDevolucao;
		try {
			codigoDevolucao = Integer.parseInt(teclado.nextLine());
		} catch (NumberFormatException e) {
			System.out.println("Entrada inválida! Por favor, digite um número.");
			return;
		}

		if (controleLocacao.existeCodigoDevolucao(codigoDevolucao)) {
			System.out.println("Código de devolução já existe! Por favor, digite um código diferente.");
			return;
		}

		controleLocacao.atualizarDevolucao(codigoLocacao, codigoDevolucao);
		int estoqueAtualizado = jogo.getQuantidade() + 1;
		controleJogo.atualizarJogoDevolucao(codigoJogo, estoqueAtualizado);
		System.out.println("Devolução feita com sucesso!");
	}

	private static void criarArquivo(String arquivo) throws IOException {
		File file = new File(arquivo);
		if (!file.exists()) {
			if (file.createNewFile()) {
				System.out.println("Arquivo criado: " + arquivo);
			} else {
				throw new IOException("Erro ao criar arquivo: " + arquivo);
			}
		}
	}

}