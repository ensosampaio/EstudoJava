package exercicios;

import java.util.Scanner;

public class MenuPrincipalExercicio6 {
	static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {
		BancoExercicio6 registro = new BancoExercicio6(15);
		int opcao;

		do {
			System.out.println("\n--- Menu ---");
			System.out.println("1. Cadastrar uma conta");
			System.out.println("2. Mostrar todas as contas");
			System.out.println("3. Mostrar contas do mesmo cliente");
			System.out.println("4. Excluir conta com menor saldo");
			System.out.println("5. Finalizar operações");
			System.out.print("Escolha uma opção: ");
			opcao = Integer.parseInt(teclado.nextLine());

			switch (opcao) {
			case 1:
				cadastrarConta(registro);
				break;
			case 2:
				System.out.println("\n--- Lista de Contas ---");
				System.out.println(registro);
				break;
			case 3:
				visualizarConta(registro);
				break;
			case 4:
				excluirContaMenorSaldo(registro);
				break;
			case 5:
				System.out.println("\nEncerrando o programa...");
				break;
			default:
				System.out.println("\nOpção inválida, por favor, tente novamente.");
			}
		} while (opcao != 5);
	}

	static void cadastrarConta(BancoExercicio6 a) {
		ContaExercicio6 conta = new ContaExercicio6();
		String nome;
		int numeroConta;
		double saldoConta;

		System.out.println("\n--- Cadastro de Clientes ---");
		System.out.print("Digite o nome: ");
		nome = teclado.nextLine();

		System.out.print("Digite o numero da conta: ");
		numeroConta = Integer.parseInt(teclado.nextLine());

		System.out.print("Digite o saldo em conta: ");
		saldoConta = Double.parseDouble(teclado.nextLine());

		conta.setNomeCliente(nome);
		conta.setNumeroConta(numeroConta);
		conta.setSaldo(saldoConta);

		if (a.cadastrarCliente(conta)) {
			System.out.println("\nCliente cadastrado com sucesso.");
		} else {
			System.out.println("\nNão foi possível cadastrar o cliente, verifique numero da conta ou tamanho do arquivo");
		}
	}

	static void visualizarConta(BancoExercicio6 a) {
		System.out.print("Digite o nome do cliente: ");
		String nome = teclado.nextLine();

		boolean contaEncontrada = false;

		System.out.println("\n--- Dados da Conta ---");
		for (int i = 0; i < a.getQuantVetor(); i++) {
			ContaExercicio6 conta = a.getVetor(i);
			if (conta.getNomeCliente().equalsIgnoreCase(nome)) {
				contaEncontrada = true;
				System.out.printf("Nome: %s, Numero de conta: %d, Saldo na conta: %.2f\n", conta.getNomeCliente(),
						conta.getNumeroConta(), conta.getSaldo());
			}
		}

		if (!contaEncontrada) {
			System.out.println("Conta não encontrada");
		}
	}

	static void excluirContaMenorSaldo(BancoExercicio6 a) {
		boolean resposta = a.removerMenorSaldo(0);
		if (resposta) {
			System.out.println("Conta com menor saldo excluida com sucesso!");
		} else {
			System.out.println("Erro: Nenhuma conta encontrada para excluir!");
		}

	}

}
